package pub.sanalar.wms.daos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.TransportDetailItem;
import pub.sanalar.wms.models.TransportDetailList;
import pub.sanalar.wms.models.TransportSubmitItem;
import pub.sanalar.wms.models.TransportSummary;
import pub.sanalar.wms.models.WmsDispatch;
import pub.sanalar.wms.models.WmsDispatchProductShelf;
import pub.sanalar.wms.models.WmsDispatchState;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsProductShelf;
import pub.sanalar.wms.models.WmsShelf;
import pub.sanalar.wms.models.WmsUser;
import pub.sanalar.wms.models.WmsWarehouse;

@Transactional
public class TransportQueryDao extends HibernateDaoSupport {

	public String newTransport(Integer userId, Integer fromWId, Integer toWId, 
			List<TransportSubmitItem> items, String desc){
		WmsUser user = getHibernateTemplate().get(WmsUser.class, userId);
		if(user == null){
			return "用户信息无效，无法添加！";
		}
		
		WmsWarehouse fromHouse = getHibernateTemplate().get(WmsWarehouse.class, fromWId);
		WmsWarehouse toHouse = getHibernateTemplate().get(WmsWarehouse.class, toWId);
		if(fromHouse == null || toHouse == null){
			return "无效的仓库信息！";
		}
		
		// 检查需要添加的信息是否合法
		HashMap<Integer, Integer> trans = new HashMap<Integer, Integer>();
		for(TransportSubmitItem i : items){
			if(trans.containsKey(i.getId())){
				trans.put(i.getId(), trans.get(i.getId()) + i.getNumber());
			}else{
				trans.put(i.getId(), i.getNumber());
			}
		}
		for(Integer i : trans.keySet()){
			WmsProductShelf sh = getHibernateTemplate().get(WmsProductShelf.class, i);
			if(sh == null){
				return "无效的列表参数！";
			}
			if(sh.getWmsShelf().getWmsStorage().getWmsWarehouse().getWarehouseId() != fromWId){
				return "试图转移一个不属于自己的库位里的货物！";
			}
			if(sh.getPsNumber() < trans.get(i)){
				return "【" + sh.getWmsShelf().getShelfName() + "】货架中存放的【" + sh.getWmsProduct().getProductName()
						+ "】的数量不足以完成这次调度。存放的数量为：" + sh.getPsNumber() + "，需要调度的数量为：" + trans.get(i);
			}
		}
		
		// 检查通过，开始添加记录
		Session session = getSessionFactory().getCurrentSession();
		WmsDispatch dispatch = new WmsDispatch();
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		dispatch.setDispatchId("WMS-DISP-" + sdf.format(cl.getTime()));
		dispatch.setDispatchAcceptTime(null);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cl.getTime());
		dispatch.setDispatchCreateTime(Timestamp.valueOf(time));
		dispatch.setDispatchDescription(desc);
		dispatch.setDispatchFinishTime(null);
		dispatch.setWmsDispatchState(
				getHibernateTemplate().get(WmsDispatchState.class, 1)
				);
		dispatch.setWmsUserByDispatchAccpetor(null);
		dispatch.setWmsUserByDispatchCreator(user);
		dispatch.setWmsUserByDispatchFinisher(null);
		dispatch.setWmsWarehouseByDispatchFrom(fromHouse);
		dispatch.setWmsWarehouseByDispatchTo(toHouse);
		session.save(dispatch);
		for(TransportSubmitItem i : items){
			WmsDispatchProductShelf s = new WmsDispatchProductShelf();
			s.setDpsCost(i.getCost());
			s.setDpsNumber(i.getNumber());
			s.setWmsDispatch(dispatch);
			s.setWmsProduct(
					getHibernateTemplate().get(WmsProduct.class, i.getProductId())
					);
			s.setWmsShelf(
					getHibernateTemplate().get(WmsShelf.class, i.getShelfId())
					);
			session.save(s);
		}
		
		session.flush();
		return "提交新的调度任务申请成功！";
	}
	
	public TransportDetailList getTransportDetailList(String tid){
		WmsDispatch d = getHibernateTemplate().get(WmsDispatch.class, tid);
		TransportDetailList res = new TransportDetailList();
		WmsUser user = d.getWmsUserByDispatchAccpetor();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		res.setAcceptor(user==null?"(无)":user.getUserRealName());
		res.setAcceptTime(user==null?"(无)":sdf.format(d.getDispatchAcceptTime()));
		user = d.getWmsUserByDispatchFinisher();
		res.setFinisher(user==null?"(无)":user.getUserRealName());
		res.setFinishTime(user==null?"(无)":sdf.format(d.getDispatchFinishTime()));
		res.setCreator(d.getWmsUserByDispatchCreator().getUserRealName());
		res.setCreateTime(sdf.format(d.getDispatchCreateTime()));
		res.setDesc(d.getDispatchDescription());
		res.setFromHouse(d.getWmsWarehouseByDispatchFrom().getWarehouseName());
		res.setToHouse(d.getWmsWarehouseByDispatchTo().getWarehouseName());
		res.setId(tid);
		
		List<TransportDetailItem> items = new ArrayList<TransportDetailItem>();
		String hql = "from WmsDispatchProductShelf s where s.wmsDispatch.dispatchId=?";
		@SuppressWarnings("unchecked")
		List<WmsDispatchProductShelf> list = (List<WmsDispatchProductShelf>)getHibernateTemplate().find(hql, tid);
		for(WmsDispatchProductShelf ps : list){
			TransportDetailItem it = new TransportDetailItem();
			it.setCategory(ps.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName() + " > "
					+ ps.getWmsProduct().getWmsCategory().getCategoryName());
			it.setCode(ps.getWmsProduct().getProductCode());
			it.setCost(ps.getDpsCost());
			it.setLastNum(getProductNumberInShelf(ps.getWmsProduct().getProductId(), ps.getWmsShelf().getShelfId()));
			it.setName(ps.getWmsProduct().getProductName());
			it.setNumber(ps.getDpsNumber());
			it.setPid(ps.getWmsProduct().getProductId());
			it.setShelf(ps.getWmsShelf().getShelfName());
			it.setStorage(ps.getWmsShelf().getWmsStorage().getStorageName());
			items.add(it);
		}
		res.setItems(items);
		return res;
	}
	
	private Integer getProductNumberInShelf(Integer productId, Integer shelfId) {
		String hql = "from WmsProductShelf ps where ps.wmsProduct.productId=? and ps.wmsShelf.shelfId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> list = (List<WmsProductShelf>)getHibernateTemplate().find(hql, productId, shelfId);
		Integer sum = 0;
		if(list != null){
			for(WmsProductShelf ps : list){
				sum += ps.getPsNumber();
			}
		}
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransportSummary> getTransportSummary(Integer warehouseId, boolean needAll, boolean useFrom){
		String hql;
		List<WmsDispatch> list;
		if(needAll){
			hql = "from WmsDispatch p where p.wmsWarehouseByDispatchFrom.warehouseId=? or p.wmsWarehouseByDispatchTo.warehouseId=?";
			list = (List<WmsDispatch>)getHibernateTemplate().find(hql, warehouseId, warehouseId);
		}else if(useFrom){
			hql = "from WmsDispatch p where p.wmsWarehouseByDispatchFrom.warehouseId=? and p.wmsDispatchState.stateId=1";
			list = (List<WmsDispatch>)getHibernateTemplate().find(hql, warehouseId);
		}else{
			hql = "from WmsDispatch p where p.wmsWarehouseByDispatchTo.warehouseId=? and p.wmsDispatchState.stateId=3";
			list = (List<WmsDispatch>)getHibernateTemplate().find(hql, warehouseId);
		}
		
		List<TransportSummary> res = new ArrayList<TransportSummary>();
		for(WmsDispatch dis : list){
			TransportSummary ts = new TransportSummary();
			WmsUser user = dis.getWmsUserByDispatchAccpetor();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			ts.setAcceptor(user==null?"(无)":user.getUserRealName());
			ts.setAcceptTime(user==null?"(无)":sdf.format(dis.getDispatchAcceptTime()));
			user = dis.getWmsUserByDispatchFinisher();
			ts.setFinisher(user==null?"(无)":user.getUserRealName());
			ts.setFinishTime(user==null?"(无)":sdf.format(dis.getDispatchFinishTime()));
			ts.setCreator(dis.getWmsUserByDispatchCreator().getUserRealName());
			ts.setCreateTime(sdf.format(dis.getDispatchCreateTime()));
			ts.setFromHouse(dis.getWmsWarehouseByDispatchFrom().getWarehouseName());
			ts.setToHouse(dis.getWmsWarehouseByDispatchTo().getWarehouseName());
			ts.setId(dis.getDispatchId());
			ts.setState(dis.getWmsDispatchState().getStateName());
			
			hql = "from WmsDispatchProductShelf ps where ps.wmsDispatch.dispatchId=?";
			List<WmsDispatchProductShelf> pss = (List<WmsDispatchProductShelf>)getHibernateTemplate().find(hql, dis.getDispatchId());
			Integer totalNum = 0;
			Double totalCost = 0.0;
			for(WmsDispatchProductShelf ps : pss){
				totalNum += ps.getDpsNumber();
				totalCost += ps.getDpsCost();
			}
			ts.setCost(totalCost);
			ts.setNumber(totalNum);
			res.add(ts);
		}
		
		return res;
	}
}

package pub.sanalar.wms.daos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.TransportDetailItem;
import pub.sanalar.wms.models.TransportDetailList;
import pub.sanalar.wms.models.TransportSubmitItem;
import pub.sanalar.wms.models.TransportSummary;
import pub.sanalar.wms.models.WmsApplicationState;
import pub.sanalar.wms.models.WmsDispatch;
import pub.sanalar.wms.models.WmsDispatchProductShelf;
import pub.sanalar.wms.models.WmsDispatchState;
import pub.sanalar.wms.models.WmsInApplication;
import pub.sanalar.wms.models.WmsInApplicationProduct;
import pub.sanalar.wms.models.WmsOutApplication;
import pub.sanalar.wms.models.WmsOutApplicationProduct;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsProductCondition;
import pub.sanalar.wms.models.WmsProductShelf;
import pub.sanalar.wms.models.WmsShelf;
import pub.sanalar.wms.models.WmsStorageCondition;
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

	@SuppressWarnings("unchecked")
	public String acceptTransport(String id, Integer userId) {
		WmsUser user = getHibernateTemplate().get(WmsUser.class, userId);
		if(user == null){
			return "无效的用户！";
		}
		
		WmsDispatch dispatch = getHibernateTemplate().get(WmsDispatch.class, id);
		if(dispatch == null){
			return "不存在的调度单！";
		}
		
		if(dispatch.getWmsDispatchState().getStateId() != 1){
			return "不能对该订单进行审核操作！";
		}
		
		String hql = "from WmsDispatchProductShelf p where p.wmsDispatch.dispatchId=?";
		List<WmsDispatchProductShelf> list = (List<WmsDispatchProductShelf>)getHibernateTemplate().find(hql, dispatch.getDispatchId());
		for(WmsDispatchProductShelf p : list){
			Integer remain = getProductNumberInShelf(p.getWmsProduct().getProductId(), p.getWmsShelf().getShelfId());
			if(p.getDpsNumber() >= remain){
				return "该调度单无法通过审核！因为【"+
						p.getWmsShelf().getShelfName()+"】所存的【"+
						p.getWmsProduct().getProductName()+"】的数量仅为："+
						remain+"，少于需要调度的值："+
						p.getDpsNumber()+"！您可以考虑关闭该调度单或者补充货源。";
			}
		}
		
		// 创建出库单
		Session session = getSessionFactory().getCurrentSession();
		WmsOutApplication out = new WmsOutApplication();
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		out.setApplicationId("WMS-OUT-" + sdf.format(cl.getTime()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cl.getTime());
		out.setApplicationTime(Timestamp.valueOf(time));
		out.setApplicationDescription("Auto generated By Dispatch \"" + dispatch.getDispatchId() + "\"");
		out.setWmsApplicationState(getHibernateTemplate().get(WmsApplicationState.class, 1));
		out.setWmsUserByApplicationAcceptor(null);
		out.setWmsUserByApplicationCreator(user);
		out.setWmsWarehouse(dispatch.getWmsWarehouseByDispatchFrom());
		session.save(out);
		
		for(WmsDispatchProductShelf p : list){
			WmsOutApplicationProduct ap = new WmsOutApplicationProduct();
			ap.setWmsOutApplication(out);
			ap.setWmsProduct(p.getWmsProduct());
			ap.setWmsShelf(p.getWmsShelf());
			ap.setApNumber(p.getDpsNumber());
			session.save(ap);
		}
		
		// 修改调度单状态
		dispatch.setWmsUserByDispatchAccpetor(user);
		dispatch.setDispatchAcceptTime(Timestamp.valueOf(time));
		dispatch.setWmsDispatchState(getHibernateTemplate().get(WmsDispatchState.class, 3));
		session.save(dispatch);
		
		session.flush();
		
		return "调度单审核成功！同时生成了一张单号为【" + out.getApplicationId() + "】的出库单！";
	}

	public String abandonTransport(String id, Integer userId) {
		WmsUser user = getHibernateTemplate().get(WmsUser.class, userId);
		if(user == null){
			return "无效的用户！";
		}
		
		WmsDispatch dispatch = getHibernateTemplate().get(WmsDispatch.class, id);
		if(dispatch == null){
			return "不存在的调度单！";
		}
		
		if(dispatch.getWmsDispatchState().getStateId() != 1){
			return "不能对该订单进行审核操作！";
		}
			
		// 修改调度单状态
		Session session = getSessionFactory().getCurrentSession();
		dispatch.setWmsUserByDispatchAccpetor(user);
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cl.getTime());
		dispatch.setDispatchAcceptTime(Timestamp.valueOf(time));
		dispatch.setWmsDispatchState(getHibernateTemplate().get(WmsDispatchState.class, 2));
		session.save(dispatch);
		
		session.flush();
		
		return "调度单审核驳回成功！";
	}

	@SuppressWarnings("unchecked")
	public String finishTransport(String id, Integer userId) {
		WmsUser user = getHibernateTemplate().get(WmsUser.class, userId);
		if(user == null){
			return "无效的用户！";
		}
		
		WmsDispatch dispatch = getHibernateTemplate().get(WmsDispatch.class, id);
		if(dispatch == null){
			return "不存在的调度单！";
		}
		
		if(dispatch.getWmsDispatchState().getStateId() != 3){
			return "不能对该订单进行确认操作！";
		}
		
		String hql = "from WmsDispatchProductShelf p where p.wmsDispatch.dispatchId=?";
		List<WmsDispatchProductShelf> list = (List<WmsDispatchProductShelf>)getHibernateTemplate().find(hql, dispatch.getDispatchId());
		HashMap<Integer, Integer> storeMap = new HashMap<Integer, Integer>();
		for(WmsDispatchProductShelf p : list){
			Integer shId = getAvailableShelf(p.getWmsProduct().getProductId(), p.getDpsNumber(),
					dispatch.getWmsWarehouseByDispatchTo().getWarehouseId());
			if(shId == null){
				return "该调度单无法确认！因为无法为【"+
						p.getWmsProduct().getProductName()+"】的找到可以存储"+
						p.getDpsNumber()+"件的货架！您可以考虑关闭该调度单或者整理空间。";
			}
			
			storeMap.put(p.getDpsId(), shId);
		}
		
		// 创建入库单
		Session session = getSessionFactory().getCurrentSession();
		WmsInApplication in = new WmsInApplication();
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		in.setApplicationId("WMS-IN-" + sdf.format(cl.getTime()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cl.getTime());
		in.setApplicationTime(Timestamp.valueOf(time));
		in.setApplicationDescription("Auto generated By Dispatch \"" + dispatch.getDispatchId() + "\"");
		in.setWmsApplicationState(getHibernateTemplate().get(WmsApplicationState.class, 1));
		in.setWmsUserByApplicationAcceptor(null);
		in.setWmsUserByApplicationCreator(user);
		in.setWmsWarehouse(dispatch.getWmsWarehouseByDispatchTo());
		session.save(in);
		
		for(WmsDispatchProductShelf p : list){
			WmsInApplicationProduct ap = new WmsInApplicationProduct();
			ap.setApNumber(p.getDpsNumber());
			ap.setWmsInApplication(in);
			ap.setWmsProduct(p.getWmsProduct());
			ap.setWmsShelf(getHibernateTemplate().get(WmsShelf.class, storeMap.get(p.getDpsId())));
			session.save(ap);
		}
		
		// 修改调度单状态
		dispatch.setWmsUserByDispatchFinisher(user);
		dispatch.setDispatchFinishTime(Timestamp.valueOf(time));
		dispatch.setWmsDispatchState(getHibernateTemplate().get(WmsDispatchState.class, 4));
		session.save(dispatch);
		
		session.flush();
		
		return "调度单确认成功！同时生成了一张单号为【" + in.getApplicationId() + "】的入库单！";
	}

	@SuppressWarnings("unchecked")
	private Integer getAvailableShelf(Integer productId, Integer dpsNumber, Integer warehouseId) {
		String hql = "from WmsProductCondition c where c.wmsProduct.productId=?";
		List<WmsProductCondition> wcs = (List<WmsProductCondition>)getHibernateTemplate().find(hql, productId);
		
		// 寻找符合条件的货架
		hql = "from WmsShelf s where s.wmsStorage.wmsWarehouse.warehouseId=?";
		List<WmsShelf> list = (List<WmsShelf>)getHibernateTemplate().find(hql, warehouseId);
		if(list.size() == 0){
			return null;
		}
		
		for(WmsShelf s : list){
			hql = "from WmsStorageCondition c where c.wmsStorage.storageId=?";
			List<WmsStorageCondition> scs = (List<WmsStorageCondition>)getHibernateTemplate().find(hql, s.getWmsStorage().getStorageId());

			// 比对条件
			HashSet<Integer> conSet = new HashSet<Integer>();
			for(WmsStorageCondition con : scs){
				conSet.add(con.getWmsCondition().getConditionId());
			}
			for(WmsProductCondition c : wcs){
				if(!conSet.contains(c.getWmsCondition().getConditionId())){
					continue;
				}
			}
			
			// 比对容量
			if(getShelfAvaliableCapacity(s) >= dpsNumber){
				return s.getShelfId();
			}
		}
		
		return null;
	}

	private Integer getShelfAvaliableCapacity(WmsShelf s) {
		String hql = "from WmsProductShelf s where s.wmsShelf.shelfId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> wps = (List<WmsProductShelf>)getHibernateTemplate().find(hql, s.getShelfId());
		Integer total = s.getShelfCapacity();
		
		for(WmsProductShelf f : wps){
			total -= f.getPsNumber();
		}
		
		return total;
	}

	public String closeTransport(String id, Integer userId) {
		WmsUser user = getHibernateTemplate().get(WmsUser.class, userId);
		if(user == null){
			return "无效的用户！";
		}
		
		WmsDispatch dispatch = getHibernateTemplate().get(WmsDispatch.class, id);
		if(dispatch == null){
			return "不存在的调度单！";
		}
		
		if(dispatch.getWmsDispatchState().getStateId() != 1){
			return "不能对该订单进行确认操作！";
		}
			
		// 修改调度单状态
		Session session = getSessionFactory().getCurrentSession();
		dispatch.setWmsUserByDispatchFinisher(user);
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cl.getTime());
		dispatch.setDispatchFinishTime(Timestamp.valueOf(time));
		dispatch.setWmsDispatchState(getHibernateTemplate().get(WmsDispatchState.class, 5));
		session.save(dispatch);
		
		session.flush();
		
		return "调度单确认驳回成功！";
	}
}

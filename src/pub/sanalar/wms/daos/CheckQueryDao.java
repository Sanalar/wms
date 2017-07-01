package pub.sanalar.wms.daos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.CheckDetailsItem;
import pub.sanalar.wms.models.CheckDetailsObject;
import pub.sanalar.wms.models.CheckItemSubmitObject;
import pub.sanalar.wms.models.CheckSummaryObject;
import pub.sanalar.wms.models.WmsCheck;
import pub.sanalar.wms.models.WmsCheckProductShelf;
import pub.sanalar.wms.models.WmsCheckState;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsProductShelf;
import pub.sanalar.wms.models.WmsShelf;
import pub.sanalar.wms.models.WmsUser;
import pub.sanalar.wms.models.WmsWarehouse;

@Transactional
public class CheckQueryDao extends HibernateDaoSupport {

	public void newCheck(Integer userId, Integer warehouseId, List<CheckItemSubmitObject> items, String description){
		WmsCheck check = new WmsCheck();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
		
		check.setCheckId("WMS-CHECK-" + sdf.format(cal.getTime()));
		check.setCheckAcceptTime(null);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cal.getTime());
		check.setCheckCreateTime(Timestamp.valueOf(time));
		check.setCheckDescription(description);
		check.setWmsUserByCheckCreator(
				getHibernateTemplate().get(WmsUser.class, userId)
				);
		check.setWmsWarehouse(
				getHibernateTemplate().get(WmsWarehouse.class, warehouseId)
				);
		check.setWmsUserByCheckAcceptor(null);
		check.setWmsCheckState(
				getHibernateTemplate().get(WmsCheckState.class, 1)
				);
		Session session = getSessionFactory().getCurrentSession();
		session.save(check);
		
		for(CheckItemSubmitObject it : items){
			WmsCheckProductShelf cps = new WmsCheckProductShelf();
			cps.setCpsNumber(it.getNumber());
			cps.setWmsCheck(check);
			cps.setWmsProduct(
					getHibernateTemplate().get(WmsProduct.class, it.getProductId())
					);
			cps.setWmsShelf(
					getHibernateTemplate().get(WmsShelf.class, it.getShelfId())
					);
			session.save(cps);
		}
		
		session.flush();
	}

	public CheckDetailsObject getCheckDetailsObject(String checkId) {
		String hql = "from WmsCheckProductShelf cps where cps.wmsCheck.checkId=?";
		@SuppressWarnings("unchecked")
		List<WmsCheckProductShelf> list = (List<WmsCheckProductShelf>)getHibernateTemplate().find(hql, checkId);
		
		CheckDetailsObject o = new CheckDetailsObject();
		WmsCheck ch = getHibernateTemplate().get(WmsCheck.class, checkId);
		WmsUser user = ch.getWmsUserByCheckAcceptor();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		if(user == null){
			o.setAcceptor("(未确认)");
			o.setAcceptTime("(未确认)");
		}else{
			o.setAcceptor(user.getUserRealName());
			o.setAcceptTime(sdf.format(ch.getCheckAcceptTime()));
		}
		o.setCreateTime(sdf.format(ch.getCheckCreateTime()));
		o.setCreator(ch.getWmsUserByCheckCreator().getUserRealName());
		o.setDesc(ch.getCheckDescription());
		o.setId(checkId);
		o.setWarehouse(ch.getWmsWarehouse().getWarehouseName());
		
		List<CheckDetailsItem> items = new ArrayList<CheckDetailsItem>();
		int i=1;
		for(WmsCheckProductShelf p : list){
			CheckDetailsItem item = new CheckDetailsItem();
			item.setCategory(p.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName() + " > "
					+ p.getWmsProduct().getWmsCategory().getCategoryName());
			item.setCode(p.getWmsProduct().getProductCode());
			item.setId(i);
			++i;
			item.setName(p.getWmsProduct().getProductName());
			item.setNewNumber(p.getCpsNumber());
			item.setOldNumber(getProductNumberInShelf(p.getWmsProduct().getProductId(), p.getWmsShelf().getShelfId()));
			item.setShelf(p.getWmsShelf().getShelfName());
			item.setStorage(p.getWmsShelf().getWmsStorage().getStorageName());
			items.add(item);
		}
		
		o.setItems(items);
		return o;
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
	
	public List<CheckSummaryObject> getCheckSummary(Integer warehouseId, boolean unAccepted){
		String hql = "from WmsCheck ps where ps.wmsWarehouse.warehouseId=?";
		if(unAccepted)
			hql += " and ps.wmsCheckState.stateId=1";
		@SuppressWarnings("unchecked")
		List<WmsCheck> list = (List<WmsCheck>)getHibernateTemplate().find(hql, warehouseId);
		
		List<CheckSummaryObject> res = new ArrayList<CheckSummaryObject>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		String warehouseName = getHibernateTemplate().get(WmsWarehouse.class, warehouseId).getWarehouseName();
		for(WmsCheck ch : list){
			CheckSummaryObject o = new CheckSummaryObject();
			WmsUser user = ch.getWmsUserByCheckAcceptor();
			if(user == null){
				o.setAcceptor("(未确认)");
				o.setAcceptTime("(未确认)");
			}else{
				o.setAcceptor(user.getUserRealName());
				o.setAcceptTime(sdf.format(ch.getCheckAcceptTime()));
			}
			o.setCreateTime(sdf.format(ch.getCheckCreateTime()));
			o.setCreator(ch.getWmsUserByCheckCreator().getUserRealName());
			o.setId(ch.getCheckId());
			o.setWarehouse(warehouseName);
			o.setState(ch.getWmsCheckState().getStateName());
			
			hql = "from WmsCheckProductShelf cps where cps.wmsCheck.checkId=?";
			@SuppressWarnings("unchecked")
			List<WmsCheckProductShelf> cps = (List<WmsCheckProductShelf>)getHibernateTemplate().find(hql, ch.getCheckId());
			HashSet<Integer> productSet = new HashSet<Integer>();
			HashSet<Integer> shelfSet = new HashSet<Integer>();
			Integer addNum = 0;
			Integer subNum = 0;
			for(WmsCheckProductShelf ps : cps){
				Integer oldNum = getProductNumberInShelf(ps.getWmsProduct().getProductId(), ps.getWmsShelf().getShelfId());
				Integer nowNum = ps.getCpsNumber();
				if(oldNum < nowNum){
					addNum += nowNum - oldNum;
				}else{
					subNum = oldNum - nowNum;
				}
				productSet.add(ps.getWmsProduct().getProductId());
				shelfSet.add(ps.getWmsShelf().getShelfId());
			}
			
			o.setAddNumber(addNum);
			o.setLostNumber(subNum);
			o.setProductNumber(productSet.size());
			o.setShelfNumber(shelfSet.size());
			
			res.add(o);
		}
		
		return res;
	}
}

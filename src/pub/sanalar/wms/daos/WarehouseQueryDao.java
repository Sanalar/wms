package pub.sanalar.wms.daos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.IdNameObject;
import pub.sanalar.wms.models.ProductStorageObject;
import pub.sanalar.wms.models.StorageInfoObject;
import pub.sanalar.wms.models.StreamInItem;
import pub.sanalar.wms.models.StreamOutItem;
import pub.sanalar.wms.models.WmsInApplicationProduct;
import pub.sanalar.wms.models.WmsOutApplicationProduct;
import pub.sanalar.wms.models.WmsProductShelf;
import pub.sanalar.wms.models.WmsShelf;
import pub.sanalar.wms.models.WmsStorage;
import pub.sanalar.wms.models.WmsStorageCondition;
import pub.sanalar.wms.models.WmsWarehouse;

@Transactional
public class WarehouseQueryDao extends HibernateDaoSupport {

	public String getWarehouseNameById(Integer id){
		WmsWarehouse house = getHibernateTemplate().get(WmsWarehouse.class, id);
		if(house == null){
			return null;
		}
		
		return house.getWarehouseName();
	}
	
	@SuppressWarnings("unchecked")
	public List<WmsWarehouse> getWarehouseList(){
		return (List<WmsWarehouse>)getHibernateTemplate().find("from WmsWarehouse");
	}
	
	public List<IdNameObject> getSimpleStorageList(Integer warehouseId){
		String hql = "from WmsStorage s where s.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsStorage> list = (List<WmsStorage>)getHibernateTemplate().find(hql, warehouseId);
		
		List<IdNameObject> res = new ArrayList<IdNameObject>();
		for(WmsStorage s : list){
			res.add(new IdNameObject(s.getStorageId(), s.getStorageName()));
		}
		
		return res;
	}
	
	public List<StorageInfoObject> getStorageInfos(Integer warehouseId){
		String hql = "from WmsStorage s where s.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsStorage> storages = (List<WmsStorage>)getHibernateTemplate().find(hql, warehouseId);
		
		List<StorageInfoObject> res = new ArrayList<StorageInfoObject>();
		int i=1;
		for(WmsStorage s : storages){
			StorageInfoObject o = new StorageInfoObject();
			setStorageInfoCapacities(s.getStorageId(), o);
			o.setCharger(s.getWmsUser().getUserRealName());
			o.setConditions(getStorageConditionString(s.getStorageId()));
			o.setId(i);
			o.setName(s.getStorageName());
			++i;
			res.add(o);
		}
		
		return res;
	}

	private String getStorageConditionString(Integer storageId) {
		String hql = "from WmsStorageCondition sc where sc.wmsStorage.storageId=?";
		@SuppressWarnings("unchecked")
		List<WmsStorageCondition> scs = (List<WmsStorageCondition>)getHibernateTemplate().find(hql, storageId);
		
		StringBuilder sb = new StringBuilder();
		for(WmsStorageCondition c : scs){
			sb.append(c.getWmsCondition().getConditionName());
			sb.append(',');
		}
		if(sb.length() > 0){
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}
		
		return "<无>";
	}

	private void setStorageInfoCapacities(Integer storageId, StorageInfoObject o) {
		String hql = "from WmsShelf s where s.wmsStorage.storageId=?";
		@SuppressWarnings("unchecked")
		List<WmsShelf> shelfs = (List<WmsShelf>)getHibernateTemplate().find(hql, storageId);
		
		Integer capacity = 0;
		Integer used = 0;
		hql = "from WmsProductShelf ps where ps.wmsShelf.shelfId=?";
		for(WmsShelf s : shelfs){
			capacity += s.getShelfCapacity();
			@SuppressWarnings("unchecked")
			List<WmsProductShelf> ps = (List<WmsProductShelf>)getHibernateTemplate().find(hql, s.getShelfId());
			for(WmsProductShelf p : ps){
				used += p.getPsNumber();
			}
		}
		
		o.setCapacity(capacity);
		o.setUsed(used);
	}
	
	public List<ProductStorageObject> getProductStorages(Integer warehouseId){
		String hql = "from WmsProductShelf ps where ps.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> list = (List<WmsProductShelf>)getHibernateTemplate().find(hql, warehouseId);
		
		List<ProductStorageObject> res = new ArrayList<ProductStorageObject>();
		for(WmsProductShelf s : list){
			ProductStorageObject o = new ProductStorageObject();
			o.setNumber(s.getPsNumber());
			o.setProductCategory(s.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName() + " > "
					+ s.getWmsProduct().getWmsCategory().getCategoryName());
			o.setProductCode(s.getWmsProduct().getProductCode());
			o.setProductName(s.getWmsProduct().getProductName());
			o.setProductId(s.getWmsProduct().getProductId());
			o.setShelfName(s.getWmsShelf().getShelfName());
			o.setStorageName(s.getWmsShelf().getWmsStorage().getStorageName());
			res.add(o);
		}
		
		return res;
	}
	
	public Map<String, Integer> getCategoryProductNumber(Integer warehouseId){
		Map<String, Integer> res = new HashMap<String, Integer>();
		String hql = "from WmsProductShelf ps where ps.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> list = (List<WmsProductShelf>)getHibernateTemplate().find(hql, warehouseId);
		
		for(WmsProductShelf s : list){
			String key = s.getWmsProduct().getWmsCategory().getCategoryName();
			if(res.containsKey(key)){
				res.put(key, res.get(key) + s.getPsNumber());
			}else{
				res.put(key, s.getPsNumber());
			}
		}
		
		return res;
	}

	public Integer getProductKindsNumber(Integer warehouseId) {
		HashSet<Integer> kindSet = new HashSet<Integer>();
		String hql = "from WmsProductShelf ps where ps.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> list = (List<WmsProductShelf>)getHibernateTemplate().find(hql, warehouseId);
		
		for(WmsProductShelf s : list){
			kindSet.add(s.getWmsProduct().getProductId());
		}
		
		return kindSet.size();
	}
	
	public Integer getDefaultWarehouseId(){
		return 1;
	}
	
	public List<StreamInItem> getStreamInItems(Integer warehouseId){
		String hql = "from WmsInApplicationProduct p where p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsInApplicationProduct> list = (List<WmsInApplicationProduct>)getHibernateTemplate().find(hql, warehouseId);
		
		List<StreamInItem> res = new ArrayList<StreamInItem>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		for(WmsInApplicationProduct p : list){
			StreamInItem item = new StreamInItem();
			item.setCharger(p.getWmsInApplication().getWmsUserByApplicationCreator().getUserRealName());
			item.setId(p.getWmsInApplication().getApplicationId());
			Timestamp time = p.getWmsInApplication().getApplicationAcceptTime();
			item.setInTime(time == null ? "<未确认>" : sdf.format(time));
			item.setNumber(p.getApNumber());
			item.setProductCode(p.getWmsProduct().getProductCode());
			item.setProductName(p.getWmsProduct().getProductName());
			item.setShelfName(p.getWmsShelf().getShelfName());
			item.setStorageName(p.getWmsShelf().getWmsStorage().getStorageName());
			item.setState(p.getWmsInApplication().getWmsApplicationState().getStateName());
			item.setProductId(p.getWmsProduct().getProductId());
			res.add(item);
		}
		
		return res;
	}
	
	public List<StreamOutItem> getStreamOutItems(Integer warehouseId){
		String hql = "from WmsOutApplicationProduct p where p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsOutApplicationProduct> list = (List<WmsOutApplicationProduct>)getHibernateTemplate().find(hql, warehouseId);
		
		List<StreamOutItem> res = new ArrayList<StreamOutItem>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		for(WmsOutApplicationProduct p : list){
			StreamOutItem item = new StreamOutItem();
			item.setCharger(p.getWmsOutApplication().getWmsUserByApplicationCreator().getUserRealName());
			item.setId(p.getWmsOutApplication().getApplicationId());
			Timestamp time = p.getWmsOutApplication().getApplicationAcceptTime();
			item.setInTime(time == null ? "<未确认>" : sdf.format(time));
			item.setNumber(p.getApNumber());
			item.setProductCode(p.getWmsProduct().getProductCode());
			item.setProductName(p.getWmsProduct().getProductName());
			item.setShelfName(p.getWmsShelf().getShelfName());
			item.setStorageName(p.getWmsShelf().getWmsStorage().getStorageName());
			item.setState(p.getWmsOutApplication().getWmsApplicationState().getStateName());
			item.setProductId(p.getWmsProduct().getProductId());
			res.add(item);
		}
		
		return res;
	}

	public List<IdNameObject> getSimpleShelfList(Integer storageId) {
		String hql = "from WmsShelf s where s.wmsStorage.storageId=?";
		@SuppressWarnings("unchecked")
		List<WmsShelf> list = (List<WmsShelf>)getHibernateTemplate().find(hql, storageId);
		
		List<IdNameObject> res = new ArrayList<IdNameObject>();
		for(WmsShelf s : list){
			res.add(new IdNameObject(s.getShelfId(), s.getShelfName()));
		}
		
		return res;
	}
}

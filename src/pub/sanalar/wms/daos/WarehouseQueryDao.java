package pub.sanalar.wms.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.StorageInfoObject;
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
		}
		
		return sb.toString();
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
}

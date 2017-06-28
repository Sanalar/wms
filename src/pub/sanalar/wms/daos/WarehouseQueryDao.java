package pub.sanalar.wms.daos;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

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
}

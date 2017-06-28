package pub.sanalar.wms.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.SimpleWarehouseInfo;
import pub.sanalar.wms.models.WmsWarehouse;

public class JsonDataProvideAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WarehouseQueryDao warehouseQueryDao;

	private List<SimpleWarehouseInfo> warehouseList;
	
	public String getAllWarehouseList(){
		List<WmsWarehouse> houses = warehouseQueryDao.getWarehouseList();
		warehouseList = new ArrayList<SimpleWarehouseInfo>();
		for(WmsWarehouse h : houses){
			SimpleWarehouseInfo m = new SimpleWarehouseInfo();
			m.setId(h.getWarehouseId());
			m.setName(h.getWarehouseName());
			warehouseList.add(m);
		}
		
		return SUCCESS;
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public void setWarehouseList(List<SimpleWarehouseInfo> warehouseList) {
		this.warehouseList = warehouseList;
	}
	
	public List<SimpleWarehouseInfo> getWarehouseList(){
		return this.warehouseList;
	}
}

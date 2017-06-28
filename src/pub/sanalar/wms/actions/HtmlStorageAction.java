package pub.sanalar.wms.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.ProductStorageObject;
import pub.sanalar.wms.models.StorageInfoObject;

public class HtmlStorageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WarehouseQueryDao warehouseQueryDao;
	private Integer warehouseId = 1;
	private String warehouseName;
	private Map<Integer, String> warehouses;
	private List<StorageInfoObject> storageInfos;
	private List<ProductStorageObject> products;
	
	@Override
	public String execute() throws Exception {
		storageInfos = warehouseQueryDao.getStorageInfos(warehouseId);
		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		products = warehouseQueryDao.getProductStorages(warehouseId);
		return SUCCESS;
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public Map<Integer, String> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Map<Integer, String> warehouses) {
		this.warehouses = warehouses;
	}

	public List<StorageInfoObject> getStorageInfos() {
		return storageInfos;
	}

	public void setStorageInfos(List<StorageInfoObject> storageInfos) {
		this.storageInfos = storageInfos;
	}

	public List<ProductStorageObject> getProducts() {
		return products;
	}

	public void setProducts(List<ProductStorageObject> products) {
		this.products = products;
	}

}

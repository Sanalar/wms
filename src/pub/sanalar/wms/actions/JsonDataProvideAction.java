package pub.sanalar.wms.actions;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CheckQueryDao;
import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.CheckDetailsObject;
import pub.sanalar.wms.models.IdNameObject;
import pub.sanalar.wms.models.JsonProductBasicInfo;
import pub.sanalar.wms.models.SimpleProductShelfInfo;
import pub.sanalar.wms.models.SimpleWarehouseInfo;
import pub.sanalar.wms.models.WmsWarehouse;

public class JsonDataProvideAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WarehouseQueryDao warehouseQueryDao;
	private ProductQueryDao productQueryDao;
	private CheckQueryDao checkQueryDao;

	private List<SimpleWarehouseInfo> warehouseList;
	private List<JsonProductBasicInfo> productList;
	private List<IdNameObject> storageList;
	private List<IdNameObject> shelfList;
	private List<SimpleProductShelfInfo> trList;
	private Integer warehouseId;
	private Integer storageId;
	private String checkId;
	private CheckDetailsObject checkDetails;
	
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
	
	public String getAllProductBasicList(){
		productList = productQueryDao.getAllProductBasic();
		return SUCCESS;
	}
	
	public String getAllStorageList(){
		storageList = warehouseQueryDao.getSimpleStorageList(warehouseId);
		return SUCCESS;
	}
	
	public String getAllShelfList(){
		shelfList = warehouseQueryDao.getSimpleShelfList(storageId);
		return SUCCESS;
	}
	
	public String getCheckDetailsObject(){
		checkDetails = checkQueryDao.getCheckDetailsObject(checkId);
		return SUCCESS;
	}
	
	public String getTransportProductList(){
		trList = productQueryDao.getTransportProductList(warehouseId);
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

	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}

	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}

	public List<JsonProductBasicInfo> getProductList() {
		return productList;
	}

	public void setProductList(List<JsonProductBasicInfo> productList) {
		this.productList = productList;
	}

	public List<IdNameObject> getStorageList() {
		return storageList;
	}

	public void setStorageList(List<IdNameObject> storageList) {
		this.storageList = storageList;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public List<IdNameObject> getShelfList() {
		return shelfList;
	}

	public void setShelfList(List<IdNameObject> shelfList) {
		this.shelfList = shelfList;
	}

	public Integer getStorageId() {
		return storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public CheckQueryDao getCheckQueryDao() {
		return checkQueryDao;
	}

	public void setCheckQueryDao(CheckQueryDao checkQueryDao) {
		this.checkQueryDao = checkQueryDao;
	}

	public void setCheckDetails(CheckDetailsObject checkDetails) {
		this.checkDetails = checkDetails;
	}

	public CheckDetailsObject getCheckDetails() {
		return checkDetails;
	}

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public List<SimpleProductShelfInfo> getTrList() {
		return trList;
	}

	public void setTrList(List<SimpleProductShelfInfo> trList) {
		this.trList = trList;
	}
}

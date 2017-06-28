package pub.sanalar.wms.actions;

import java.text.DecimalFormat;
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
	private String categoryJson;
	private String capacityJson;
	private Integer totalCapacity;
	private Integer totalUsedCapacity;
	private Integer totalProduct;
	private Integer totalCategory;
	private String percentage;
	
	private String getCapacityJsonString(){
		totalCapacity = 0;
		totalUsedCapacity = 0;
		
		StringBuilder sb = new StringBuilder("[");
		DecimalFormat df = new DecimalFormat("0.00");
		for(StorageInfoObject o : storageInfos){
			totalCapacity += o.getCapacity();
			totalUsedCapacity += o.getUsed();
			sb.append("{");
			sb.append("value:" + df.format(o.getUsed() * 100.0 / o.getCapacity()) + ",");
			sb.append("color:\"#BBE0E9\",highlight:\"#15BA67\",");
			sb.append("label:\"" + o.getName() + "\"");
			sb.append("},");
		}
		
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
	
	private String getCategoryJsonString(){
		Map<String, Integer> m = warehouseQueryDao.getCategoryProductNumber(warehouseId);
		totalCategory = m.size();
		totalProduct = warehouseQueryDao.getProductKindsNumber(warehouseId);
		
		StringBuilder sb = new StringBuilder("[");
		DecimalFormat df = new DecimalFormat("0.00");
		for(String key : m.keySet()){
			sb.append("{");
			sb.append("value:" + df.format(m.get(key) * 100.0 / totalUsedCapacity) + ",");
			sb.append("color:\"#BBE0E9\",highlight:\"#15BA67\",");
			sb.append("label:\"" + key + "\"");
			sb.append("},");
		}
		
		sb.setCharAt(sb.length() - 1, ']');
		percentage = df.format(totalUsedCapacity * 100.0 / totalCapacity) + "%";
		return sb.toString();
	}
	
	@Override
	public String execute() throws Exception {
		storageInfos = warehouseQueryDao.getStorageInfos(warehouseId);
		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		products = warehouseQueryDao.getProductStorages(warehouseId);
		capacityJson = getCapacityJsonString();
		categoryJson = getCategoryJsonString();
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

	public String getCategoryJson() {
		return categoryJson;
	}

	public void setCategoryJson(String categoryJson) {
		this.categoryJson = categoryJson;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public Integer getTotalUsedCapacity() {
		return totalUsedCapacity;
	}

	public void setTotalUsedCapacity(Integer totalUsedCapacity) {
		this.totalUsedCapacity = totalUsedCapacity;
	}

	public String getCapacityJson() {
		return capacityJson;
	}

	public void setCapacityJson(String capacityJson) {
		this.capacityJson = capacityJson;
	}

	public Integer getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(Integer totalProduct) {
		this.totalProduct = totalProduct;
	}

	public Integer getTotalCategory() {
		return totalCategory;
	}

	public void setTotalCategory(Integer totalCategory) {
		this.totalCategory = totalCategory;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}

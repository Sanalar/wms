package pub.sanalar.wms.actions;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;
import pub.sanalar.wms.daos.ConditionQueryDao;
import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.ProductInOutStreamOfWarehouse;
import pub.sanalar.wms.models.WarehouseAndNumber;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsProductSupplier;

public class HtmlProductDetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoryQueryDao categoryQueryDao;
	private ProductQueryDao productQueryDao;
	private ConditionQueryDao conditionQueryDao;
	private WarehouseQueryDao warehouseQueryDao;
	private String topCategoryListString;
	private String allSubCategoryListString;
	private WmsProduct product;
	private Set<WmsProductSupplier> productSupplier;
	private Map<Integer, String> conditionList;
	private HashSet<Integer> productConditions;
	private List<WarehouseAndNumber> warehouseAndNumbers;
	private List<ProductInOutStreamOfWarehouse> streams;
	private DateFormat sdf = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ HH:mm:ss"); 
	private String warehouseName;
	private Integer id;
	private Integer warehouse;
	private String msg;
	private DecimalFormat df = new DecimalFormat("0.00");

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		if(id == null || id == 0){
			return ERROR;
		}
		
		product = productQueryDao.getProductById(id);
		if(product == null){
			return ERROR;
		}
		productSupplier = product.getWmsProductSuppliers();
		productConditions = conditionQueryDao.getProductConditions(product.getProductId());
		warehouseAndNumbers = productQueryDao.getAllWarehouseStoreNumberOfProduct(product.getProductId());
		
		if(warehouse != null){
			streams = productQueryDao.getProductInOutStream(product.getProductId(), warehouse);
			warehouseName = warehouseQueryDao.getWarehouseNameById(warehouse);
		}
		
		Map<Integer, String> topCategories = categoryQueryDao.getTopCategories();
		topCategoryListString = categoryQueryDao.getTopCategoryListString(topCategories);
		allSubCategoryListString = categoryQueryDao.getAllSubCategoryListString(topCategories);
		
		conditionList = conditionQueryDao.getAllConditions();
		
		return SUCCESS;
	}

	public CategoryQueryDao getCategoryQueryDao() {
		return categoryQueryDao;
	}

	public void setCategoryQueryDao(CategoryQueryDao categoryQueryDao) {
		this.categoryQueryDao = categoryQueryDao;
	}

	public String getTopCategoryListString() {
		return topCategoryListString;
	}

	public void setTopCategoryListString(String topCategoryListString) {
		this.topCategoryListString = topCategoryListString;
	}

	public String getAllSubCategoryListString() {
		return allSubCategoryListString;
	}

	public void setAllSubCategoryListString(String allSubCategoryListString) {
		this.allSubCategoryListString = allSubCategoryListString;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}

	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}

	public WmsProduct getProduct() {
		return product;
	}

	public void setProduct(WmsProduct product) {
		this.product = product;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public ConditionQueryDao getConditionQueryDao() {
		return conditionQueryDao;
	}

	public void setConditionQueryDao(ConditionQueryDao conditionQueryDao) {
		this.conditionQueryDao = conditionQueryDao;
	}

	public Map<Integer, String> getConditionList() {
		return conditionList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Set<WmsProductSupplier> getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(Set<WmsProductSupplier> productSupplier) {
		this.productSupplier = productSupplier;
	}

	public HashSet<Integer> getProductConditions() {
		return productConditions;
	}

	public void setProductConditions(HashSet<Integer> productConditions) {
		this.productConditions = productConditions;
	}

	public Integer getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Integer warehouse) {
		this.warehouse = warehouse;
	}

	public List<WarehouseAndNumber> getWarehouseAndNumbers() {
		return warehouseAndNumbers;
	}

	public void setWarehouseAndNumbers(List<WarehouseAndNumber> warehouseAndNumbers) {
		this.warehouseAndNumbers = warehouseAndNumbers;
	}

	public List<ProductInOutStreamOfWarehouse> getStreams() {
		return streams;
	}

	public void setStreams(List<ProductInOutStreamOfWarehouse> streams) {
		this.streams = streams;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public DateFormat getSdf() {
		return sdf;
	}

	public void setSdf(DateFormat sdf) {
		this.sdf = sdf;
	}

}

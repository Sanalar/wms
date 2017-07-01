package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;
import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.models.WmsCategory;
import pub.sanalar.wms.models.WmsProduct;

public class EditProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String location;
	private ProductQueryDao productQueryDao;
	private CategoryQueryDao categoryQueryDao;
	private String productName;
	private String productCode;
	private String productCategory;
	private String productSupplier;
	private String productStandard;
	private String productUnit;
	private Double productInPrice;
	private Double productOutPrice;
	private String productDescription;
	
	@Override
	public String execute() throws Exception {
		if(productName == null || productCode == null
				|| productCategory == null || productSupplier == null
				|| productStandard == null || productUnit == null
				|| productInPrice == null || productOutPrice == null
				|| productDescription == null || id == null){
			return ERROR;
		}
		
		WmsCategory category = categoryQueryDao.getCategoryByCategoryString(productCategory);
		if(category == null){
			return ERROR;
		}
		
		WmsProduct product = productQueryDao.getProductById(id);
		if(product == null){
			return ERROR;
		}
		
		product.setProductName(productName);
		product.setProductCode(productCode);
		product.setProductStandard(productStandard);
		product.setProductDescription(productDescription);
		product.setWmsCategory(category);
		productQueryDao.updateProduct(product);
		
		location = "product-details.html?id=" + id + "&msg=产品信息保存成功！";
		return SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}
	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}

	public String getProductStandard() {
		return productStandard;
	}

	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public Double getProductInPrice() {
		return productInPrice;
	}

	public void setProductInPrice(Double productInPrice) {
		this.productInPrice = productInPrice;
	}

	public Double getProductOutPrice() {
		return productOutPrice;
	}

	public void setProductOutPrice(Double productOutPrice) {
		this.productOutPrice = productOutPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public CategoryQueryDao getCategoryQueryDao() {
		return categoryQueryDao;
	}

	public void setCategoryQueryDao(CategoryQueryDao categoryQueryDao) {
		this.categoryQueryDao = categoryQueryDao;
	}

}

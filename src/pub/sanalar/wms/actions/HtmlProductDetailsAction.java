package pub.sanalar.wms.actions;

import java.text.DecimalFormat;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;
import pub.sanalar.wms.daos.ConditionQueryDao;
import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.models.WmsProduct;

public class HtmlProductDetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoryQueryDao categoryQueryDao;
	private ProductQueryDao productQueryDao;
	private ConditionQueryDao conditionQueryDao;
	private String topCategoryListString;
	private String allSubCategoryListString;
	private WmsProduct product;
	private Map<Integer, String> conditionList;
	private Integer id;
	private DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public String execute() throws Exception {
		if(id == null || id == 0){
			return ERROR;
		}
		
		product = productQueryDao.getProductById(id);
		if(product == null){
			return ERROR;
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

}

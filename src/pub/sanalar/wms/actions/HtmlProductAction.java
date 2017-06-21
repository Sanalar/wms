package pub.sanalar.wms.actions;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;
import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.models.WmsProduct;

public class HtmlProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	private Long pageCount;
	private Integer category1;
	private Integer category2;
	private String search;
	private ProductQueryDao productQueryDao;
	private CategoryQueryDao categoryQueryDao;
	private List<WmsProduct> products;
	private Map<Integer, String> category1List;
	private Map<Integer, String> category1IconList;
	private Map<Integer, String> category2List;
	private DecimalFormat df = new DecimalFormat("0.00");
	public final static Integer pageSize = 20;
	
	public Map<Integer, String> getCategory1List() {
		return category1List;
	}
	
	public Map<Integer, String> getCategory1IconList() {
		return category1IconList;
	}
	
	public Map<Integer, String> getCategory2List() {
		return category2List;
	}
	
	public DecimalFormat getDf() {
		return df;
	}
	
	public Long getPageCount() {
		return pageCount;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCategory1() {
		return category1;
	}
	public void setCategory1(Integer category1) {
		this.category1 = category1;
	}
	public Integer getCategory2() {
		return category2;
	}
	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}
	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}
	public CategoryQueryDao getCategoryQueryDao() {
		return categoryQueryDao;
	}
	public void setCategoryQueryDao(CategoryQueryDao categoryQueryDao) {
		this.categoryQueryDao = categoryQueryDao;
	}
	
	public List<WmsProduct> getProducts() {
		return products;
	}
	public void setProducts(List<WmsProduct> products) {
		this.products = products;
	}
	
	@Override
	public String execute() throws Exception {
		search = java.net.URLDecoder.decode(search, "UTF-8");
		pageCount = productQueryDao.getProductCount(category1, category2, search);
		pageCount = (pageCount + pageSize - 1) / pageSize;
		category1List = categoryQueryDao.getTopCategories();
		category1IconList = categoryQueryDao.getTopCategoryIcons();
		category2List = categoryQueryDao.getSubCategories(category1);
		products = productQueryDao.getProductList(category1, category2, search, pageSize, page);
		return SUCCESS;
	}

}

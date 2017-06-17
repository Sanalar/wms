package pub.sanalar.wms.actions;

import java.util.List;

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
	private Integer category1;
	private Integer category2;
	private String search;
	private ProductQueryDao productQueryDao;
	private CategoryQueryDao categoryQueryDao;
	private List<WmsProduct> products;
	public final static Integer pageSize = 20;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCategrory1() {
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
		products = productQueryDao.getProductList(category1, category2, search, pageSize, page);
		return SUCCESS;
	}

}

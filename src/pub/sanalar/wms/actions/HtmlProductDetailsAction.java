package pub.sanalar.wms.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;

public class HtmlProductDetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CategoryQueryDao categoryQueryDao;
	private String topCategoryListString;
	private String allSubCategoryListString;

	@Override
	public String execute() throws Exception {
		Map<Integer, String> topCategories = categoryQueryDao.getTopCategories();
		topCategoryListString = categoryQueryDao.getTopCategoryListString(topCategories);
		allSubCategoryListString = categoryQueryDao.getAllSubCategoryListString(topCategories);
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

}

package pub.sanalar.wms.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CategoryQueryDao;
import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.WmsWarehouse;

public class HtmlNewCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WarehouseQueryDao warehouseQueryDao;
	private CategoryQueryDao categoryQueryDao;
	private Integer wid;
	private List<WmsWarehouse> warehouseList;
	private String topCategoryListString;
	private String allSubCategoryListString;

	@Override
	public String execute() throws Exception {
		if(wid == null){
			wid = warehouseQueryDao.getDefaultWarehouseId();
		}
		warehouseList = warehouseQueryDao.getWarehouseList();
		Map<Integer, String> topCategories = categoryQueryDao.getTopCategories();
		topCategoryListString = categoryQueryDao.getTopCategoryListString(topCategories);
		allSubCategoryListString = categoryQueryDao.getAllSubCategoryListString(topCategories);
		return super.execute();
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public List<WmsWarehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WmsWarehouse> warehouseList) {
		this.warehouseList = warehouseList;
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

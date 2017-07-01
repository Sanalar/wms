package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CheckQueryDao;
import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.CheckSummaryObject;

public class HtmlChecksAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer warehouseId;
	private CheckQueryDao checkQueryDao;
	private WarehouseQueryDao warehouseQueryDao;
	private String displayNew;
	private String warehouseName;
	private String displayCheck;
	private List<CheckSummaryObject> unSummarys;
	private List<CheckSummaryObject> allSummarys;

	@Override
	public String execute() throws Exception {
		if(warehouseId == null){
			warehouseId = warehouseQueryDao.getDefaultWarehouseId();
		}
		unSummarys = checkQueryDao.getCheckSummary(warehouseId, true);
		allSummarys = checkQueryDao.getCheckSummary(warehouseId, false);
		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		
		return SUCCESS;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public CheckQueryDao getCheckQueryDao() {
		return checkQueryDao;
	}

	public void setCheckQueryDao(CheckQueryDao checkQueryDao) {
		this.checkQueryDao = checkQueryDao;
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public String getDisplayNew() {
		return displayNew;
	}

	public void setDisplayNew(String displayNew) {
		this.displayNew = displayNew;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getDisplayCheck() {
		return displayCheck;
	}

	public void setDisplayCheck(String displayCheck) {
		this.displayCheck = displayCheck;
	}

	public List<CheckSummaryObject> getUnSummarys() {
		return unSummarys;
	}

	public void setUnSummarys(List<CheckSummaryObject> unSummarys) {
		this.unSummarys = unSummarys;
	}

	public List<CheckSummaryObject> getAllSummarys() {
		return allSummarys;
	}

	public void setAllSummarys(List<CheckSummaryObject> allSummarys) {
		this.allSummarys = allSummarys;
	}

}

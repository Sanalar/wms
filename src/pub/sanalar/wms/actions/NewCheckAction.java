package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CheckQueryDao;
import pub.sanalar.wms.models.CheckItemSubmitObject;
import pub.sanalar.wms.models.WmsUser;

public class NewCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CheckItemSubmitObject> checkItem;
	private String checkDescription;
	private Integer warehouseId;
	private CheckQueryDao checkQueryDao;

	@Override
	public String execute() throws Exception {
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		checkQueryDao.newCheck(user==null?1:user.getUserId(), warehouseId, checkItem, checkDescription);
		return SUCCESS;
	}

	public List<CheckItemSubmitObject> getCheckItem() {
		return checkItem;
	}

	public void setCheckItem(List<CheckItemSubmitObject> checkItem) {
		this.checkItem = checkItem;
	}

	public String getCheckDescription() {
		return checkDescription;
	}

	public void setCheckDescription(String checkDescription) {
		this.checkDescription = checkDescription;
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

}

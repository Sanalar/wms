package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CheckQueryDao;
import pub.sanalar.wms.models.WmsUser;

public class CheckReviewAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private CheckQueryDao checkQueryDao;
	private String msg;
	private String location;
	
	public String acceptCheck(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = checkQueryDao.acceptCheck(id, userId);
		location = "checks.html";
		return SUCCESS;
	}
	
	public String abandonCheck(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = checkQueryDao.abandonCheck(id, userId);
		location = "checks.html";
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CheckQueryDao getCheckQueryDao() {
		return checkQueryDao;
	}

	public void setCheckQueryDao(CheckQueryDao checkQueryDao) {
		this.checkQueryDao = checkQueryDao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

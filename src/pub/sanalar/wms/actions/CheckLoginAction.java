package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.CheckLoginDao;
import pub.sanalar.wms.models.WmsUser;

public class CheckLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CheckLoginDao checkLoginDao;
	private String userName;
	private String pswd;

	@Override
	public String execute() throws Exception {
		WmsUser user = checkLoginDao.login(userName, pswd);
		if(user == null){
			return "error-login";
		}
		
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}

	public CheckLoginDao getCheckLoginDao() {
		return checkLoginDao;
	}

	public void setCheckLoginDao(CheckLoginDao checkLoginDao) {
		this.checkLoginDao = checkLoginDao;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}

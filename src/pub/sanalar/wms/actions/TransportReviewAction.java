package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.TransportQueryDao;
import pub.sanalar.wms.models.WmsUser;

public class TransportReviewAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TransportQueryDao transportQueryDao;
	private String id;
	private String msg;
	private String location;
	
	public String acceptTransport(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = transportQueryDao.acceptTransport(id, userId);
		location = "transports.html";
		return SUCCESS;
	}
	
	public String abandonTransport(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = transportQueryDao.abandonTransport(id, userId);
		location = "transports.html";
		return SUCCESS;
	}
	
	public String finishTransport(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = transportQueryDao.finishTransport(id, userId);
		location = "transports.html";
		return SUCCESS;
	}
	
	public String closeTransport(){
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		Integer userId = user == null ? 1 : user.getUserId();
		msg = transportQueryDao.closeTransport(id, userId);
		location = "transports.html";
		return SUCCESS;
	}

	public TransportQueryDao getTransportQueryDao() {
		return transportQueryDao;
	}

	public void setTransportQueryDao(TransportQueryDao transportQueryDao) {
		this.transportQueryDao = transportQueryDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

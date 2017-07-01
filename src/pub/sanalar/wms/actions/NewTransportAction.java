package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.TransportQueryDao;
import pub.sanalar.wms.models.TransportSubmitItem;
import pub.sanalar.wms.models.WmsUser;

public class NewTransportAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TransportQueryDao transportQueryDao;
	private List<TransportSubmitItem> trItem;
	private Integer wid;
	private Integer toid;
	private String desc;
	private String msg;
	private String location;
	
	@Override
	public String execute() throws Exception {
		WmsUser user = (WmsUser)ActionContext.getContext().getSession().get("user");
		location = "transports.html";
		msg = transportQueryDao.newTransport(user==null?1:user.getUserId(), wid, toid, trItem, desc);
		if(!msg.equals("提交新的调度任务申请成功！")){
			location = "new-transport.html";
		}
		return SUCCESS;
	}

	public TransportQueryDao getTransportQueryDao() {
		return transportQueryDao;
	}

	public void setTransportQueryDao(TransportQueryDao transportQueryDao) {
		this.transportQueryDao = transportQueryDao;
	}

	public List<TransportSubmitItem> getTrItem() {
		return trItem;
	}

	public void setTrItem(List<TransportSubmitItem> trItem) {
		this.trItem = trItem;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getToid() {
		return toid;
	}

	public void setToid(Integer toid) {
		this.toid = toid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

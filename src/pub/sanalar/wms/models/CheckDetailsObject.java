package pub.sanalar.wms.models;

import java.util.List;

public class CheckDetailsObject {

	private String id;
	private String warehouse;
	private String createTime;
	private String acceptTime;
	private String creator;
	private String acceptor;
	private String desc;
	private List<CheckDetailsItem> items;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<CheckDetailsItem> getItems() {
		return items;
	}
	public void setItems(List<CheckDetailsItem> items) {
		this.items = items;
	}
}

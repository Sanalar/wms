package pub.sanalar.wms.models;

import java.util.List;

public class TransportDetailList {

	private String id;
	private String fromHouse;
	private String toHouse;
	private String createTime;
	private String acceptTime;
	private String finishTime;
	private String creator;
	private String acceptor;
	private String finisher;
	private String desc;
	private List<TransportDetailItem> items;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromHouse() {
		return fromHouse;
	}
	public void setFromHouse(String fromHouse) {
		this.fromHouse = fromHouse;
	}
	public String getToHouse() {
		return toHouse;
	}
	public void setToHouse(String toHouse) {
		this.toHouse = toHouse;
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
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
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
	public String getFinisher() {
		return finisher;
	}
	public void setFinisher(String finisher) {
		this.finisher = finisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<TransportDetailItem> getItems() {
		return items;
	}
	public void setItems(List<TransportDetailItem> items) {
		this.items = items;
	}
}

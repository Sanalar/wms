package pub.sanalar.wms.models;

public class TransportSummary {

	private String id;
	private String createTime;
	private String acceptTime;
	private String finishTime;
	private String creator;
	private String acceptor;
	private String finisher;
	private String fromHouse;
	private String toHouse;
	private Integer number;
	private Double cost;
	private String state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}

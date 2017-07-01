package pub.sanalar.wms.models;

public class CheckSummaryObject {

	private String id;
	private String createTime;
	private String warehouse;
	private String creator;
	private Integer addNumber;
	private Integer lostNumber;
	private Integer shelfNumber;
	private Integer productNumber;
	private String state;
	private String acceptor;
	private String acceptTime;
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
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getAddNumber() {
		return addNumber;
	}
	public void setAddNumber(Integer addNumber) {
		this.addNumber = addNumber;
	}
	public Integer getLostNumber() {
		return lostNumber;
	}
	public void setLostNumber(Integer lostNumber) {
		this.lostNumber = lostNumber;
	}
	public Integer getShelfNumber() {
		return shelfNumber;
	}
	public void setShelfNumber(Integer shelfNumber) {
		this.shelfNumber = shelfNumber;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAcceptor() {
		return acceptor;
	}
	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
}

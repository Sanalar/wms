package pub.sanalar.wms.models;

public class CheckItemSubmitObject {

	private Integer productId;
	private Integer shelfId;
	private Integer number;
	private String shelfName;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getShelfId() {
		return shelfId;
	}
	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getShelfName() {
		return shelfName;
	}
	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}
}

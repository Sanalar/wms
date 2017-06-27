package pub.sanalar.wms.models;

import java.sql.Timestamp;

public class ProductInOutStreamOfWarehouse implements Comparable<ProductInOutStreamOfWarehouse> {

	private String streamId;
	private Timestamp streamCreateTime;
	private Timestamp streamAcceptTime;
	private String createUser;
	private String acceptUser;
	private boolean isInStream;
	private Integer streamNumber;
	private String state;
	
	public String getStreamId() {
		return streamId;
	}
	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	public Timestamp getStreamCreateTime() {
		return streamCreateTime;
	}
	public void setStreamCreateTime(Timestamp streamCreateTime) {
		this.streamCreateTime = streamCreateTime;
	}
	public Timestamp getStreamAcceptTime() {
		return streamAcceptTime;
	}
	public void setStreamAcceptTime(Timestamp streamAcceptTime) {
		this.streamAcceptTime = streamAcceptTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getAcceptUser() {
		return acceptUser;
	}
	public void setAcceptUser(String acceptUser) {
		this.acceptUser = acceptUser;
	}
	public boolean isInStream() {
		return isInStream;
	}
	public void setInStream(boolean isInStream) {
		this.isInStream = isInStream;
	}
	public Integer getStreamNumber() {
		return streamNumber;
	}
	public void setStreamNumber(Integer streamNumber) {
		this.streamNumber = streamNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int compareTo(ProductInOutStreamOfWarehouse o) {
		// TODO Auto-generated method stub
		return 0 - this.streamCreateTime.compareTo(o.streamCreateTime);
	}
}

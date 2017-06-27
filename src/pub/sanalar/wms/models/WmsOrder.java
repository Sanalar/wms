package pub.sanalar.wms.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * WmsOrder entity. @author MyEclipse Persistence Tools
 */

public class WmsOrder implements java.io.Serializable {

	// Fields

	private String orderId;
	private WmsUser wmsUser;
	private WmsOrderState wmsOrderState;
	private WmsWarehouse wmsWarehouse;
	private Timestamp orderDate;
	private Timestamp orderDeadLine;
	private String orderDescription;
	private Set wmsOrderLines = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsOrder() {
	}

	/** minimal constructor */
	public WmsOrder(String orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public WmsOrder(String orderId, WmsUser wmsUser, WmsOrderState wmsOrderState, WmsWarehouse wmsWarehouse,
			Timestamp orderDate, Timestamp orderDeadLine, String orderDescription, Set wmsOrderLines) {
		this.orderId = orderId;
		this.wmsUser = wmsUser;
		this.wmsOrderState = wmsOrderState;
		this.wmsWarehouse = wmsWarehouse;
		this.orderDate = orderDate;
		this.orderDeadLine = orderDeadLine;
		this.orderDescription = orderDescription;
		this.wmsOrderLines = wmsOrderLines;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public WmsUser getWmsUser() {
		return this.wmsUser;
	}

	public void setWmsUser(WmsUser wmsUser) {
		this.wmsUser = wmsUser;
	}

	public WmsOrderState getWmsOrderState() {
		return this.wmsOrderState;
	}

	public void setWmsOrderState(WmsOrderState wmsOrderState) {
		this.wmsOrderState = wmsOrderState;
	}

	public WmsWarehouse getWmsWarehouse() {
		return this.wmsWarehouse;
	}

	public void setWmsWarehouse(WmsWarehouse wmsWarehouse) {
		this.wmsWarehouse = wmsWarehouse;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getOrderDeadLine() {
		return this.orderDeadLine;
	}

	public void setOrderDeadLine(Timestamp orderDeadLine) {
		this.orderDeadLine = orderDeadLine;
	}

	public String getOrderDescription() {
		return this.orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Set getWmsOrderLines() {
		return this.wmsOrderLines;
	}

	public void setWmsOrderLines(Set wmsOrderLines) {
		this.wmsOrderLines = wmsOrderLines;
	}

}
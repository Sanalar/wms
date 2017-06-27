package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsOrderState entity. @author MyEclipse Persistence Tools
 */

public class WmsOrderState implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private Set wmsOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsOrderState() {
	}

	/** minimal constructor */
	public WmsOrderState(Integer stateId) {
		this.stateId = stateId;
	}

	/** full constructor */
	public WmsOrderState(Integer stateId, String stateName, Set wmsOrders) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.wmsOrders = wmsOrders;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Set getWmsOrders() {
		return this.wmsOrders;
	}

	public void setWmsOrders(Set wmsOrders) {
		this.wmsOrders = wmsOrders;
	}

}
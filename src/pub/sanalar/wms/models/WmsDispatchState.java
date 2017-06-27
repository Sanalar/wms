package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsDispatchState entity. @author MyEclipse Persistence Tools
 */

public class WmsDispatchState implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private Set wmsDispatchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsDispatchState() {
	}

	/** minimal constructor */
	public WmsDispatchState(Integer stateId) {
		this.stateId = stateId;
	}

	/** full constructor */
	public WmsDispatchState(Integer stateId, String stateName, Set wmsDispatchs) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.wmsDispatchs = wmsDispatchs;
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

	public Set getWmsDispatchs() {
		return this.wmsDispatchs;
	}

	public void setWmsDispatchs(Set wmsDispatchs) {
		this.wmsDispatchs = wmsDispatchs;
	}

}
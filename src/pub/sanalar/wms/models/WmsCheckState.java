package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsCheckState entity. @author MyEclipse Persistence Tools
 */

public class WmsCheckState implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private Set wmsChecks = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsCheckState() {
	}

	/** minimal constructor */
	public WmsCheckState(Integer stateId) {
		this.stateId = stateId;
	}

	/** full constructor */
	public WmsCheckState(Integer stateId, String stateName, Set wmsChecks) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.wmsChecks = wmsChecks;
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

	public Set getWmsChecks() {
		return this.wmsChecks;
	}

	public void setWmsChecks(Set wmsChecks) {
		this.wmsChecks = wmsChecks;
	}

}
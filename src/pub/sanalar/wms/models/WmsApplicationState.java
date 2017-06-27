package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsApplicationState entity. @author MyEclipse Persistence Tools
 */

public class WmsApplicationState implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private String stateName;
	private Set wmsInApplications = new HashSet(0);
	private Set wmsOutApplications = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsApplicationState() {
	}

	/** minimal constructor */
	public WmsApplicationState(Integer stateId) {
		this.stateId = stateId;
	}

	/** full constructor */
	public WmsApplicationState(Integer stateId, String stateName, Set wmsInApplications, Set wmsOutApplications) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.wmsInApplications = wmsInApplications;
		this.wmsOutApplications = wmsOutApplications;
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

	public Set getWmsInApplications() {
		return this.wmsInApplications;
	}

	public void setWmsInApplications(Set wmsInApplications) {
		this.wmsInApplications = wmsInApplications;
	}

	public Set getWmsOutApplications() {
		return this.wmsOutApplications;
	}

	public void setWmsOutApplications(Set wmsOutApplications) {
		this.wmsOutApplications = wmsOutApplications;
	}

}
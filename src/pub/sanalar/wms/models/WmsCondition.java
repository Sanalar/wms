package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsCondition entity. @author MyEclipse Persistence Tools
 */

public class WmsCondition implements java.io.Serializable {

	// Fields

	private Integer conditionId;
	private String conditionName;
	private Set wmsProductConditions = new HashSet(0);
	private Set wmsStorageConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsCondition() {
	}

	/** minimal constructor */
	public WmsCondition(Integer conditionId) {
		this.conditionId = conditionId;
	}

	/** full constructor */
	public WmsCondition(Integer conditionId, String conditionName, Set wmsProductConditions, Set wmsStorageConditions) {
		this.conditionId = conditionId;
		this.conditionName = conditionName;
		this.wmsProductConditions = wmsProductConditions;
		this.wmsStorageConditions = wmsStorageConditions;
	}

	// Property accessors

	public Integer getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionName() {
		return this.conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public Set getWmsProductConditions() {
		return this.wmsProductConditions;
	}

	public void setWmsProductConditions(Set wmsProductConditions) {
		this.wmsProductConditions = wmsProductConditions;
	}

	public Set getWmsStorageConditions() {
		return this.wmsStorageConditions;
	}

	public void setWmsStorageConditions(Set wmsStorageConditions) {
		this.wmsStorageConditions = wmsStorageConditions;
	}

}
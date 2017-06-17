package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsCondition entity. @author MyEclipse Persistence Tools
 */

public class WmsCondition implements java.io.Serializable {

	// Fields

	private Integer conditionId;
	private String conditionDesciption;
	private Set wmsProductConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsCondition() {
	}

	/** minimal constructor */
	public WmsCondition(String conditionDesciption) {
		this.conditionDesciption = conditionDesciption;
	}

	/** full constructor */
	public WmsCondition(String conditionDesciption, Set wmsProductConditions) {
		this.conditionDesciption = conditionDesciption;
		this.wmsProductConditions = wmsProductConditions;
	}

	// Property accessors

	public Integer getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionDesciption() {
		return this.conditionDesciption;
	}

	public void setConditionDesciption(String conditionDesciption) {
		this.conditionDesciption = conditionDesciption;
	}

	public Set getWmsProductConditions() {
		return this.wmsProductConditions;
	}

	public void setWmsProductConditions(Set wmsProductConditions) {
		this.wmsProductConditions = wmsProductConditions;
	}

}
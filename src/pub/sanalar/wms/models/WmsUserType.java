package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsUserType entity. @author MyEclipse Persistence Tools
 */

public class WmsUserType implements java.io.Serializable {

	// Fields

	private Integer userTypeId;
	private String userTypeName;
	private Set wmsUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsUserType() {
	}

	/** minimal constructor */
	public WmsUserType(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	/** full constructor */
	public WmsUserType(Integer userTypeId, String userTypeName, Set wmsUsers) {
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
		this.wmsUsers = wmsUsers;
	}

	// Property accessors

	public Integer getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Set getWmsUsers() {
		return this.wmsUsers;
	}

	public void setWmsUsers(Set wmsUsers) {
		this.wmsUsers = wmsUsers;
	}

}
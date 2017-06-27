package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsStorage entity. @author MyEclipse Persistence Tools
 */

public class WmsStorage implements java.io.Serializable {

	// Fields

	private Integer storageId;
	private WmsUser wmsUser;
	private WmsWarehouse wmsWarehouse;
	private String storageName;
	private Set wmsShelfs = new HashSet(0);
	private Set wmsStorageConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsStorage() {
	}

	/** minimal constructor */
	public WmsStorage(Integer storageId) {
		this.storageId = storageId;
	}

	/** full constructor */
	public WmsStorage(Integer storageId, WmsUser wmsUser, WmsWarehouse wmsWarehouse, String storageName, Set wmsShelfs,
			Set wmsStorageConditions) {
		this.storageId = storageId;
		this.wmsUser = wmsUser;
		this.wmsWarehouse = wmsWarehouse;
		this.storageName = storageName;
		this.wmsShelfs = wmsShelfs;
		this.wmsStorageConditions = wmsStorageConditions;
	}

	// Property accessors

	public Integer getStorageId() {
		return this.storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public WmsUser getWmsUser() {
		return this.wmsUser;
	}

	public void setWmsUser(WmsUser wmsUser) {
		this.wmsUser = wmsUser;
	}

	public WmsWarehouse getWmsWarehouse() {
		return this.wmsWarehouse;
	}

	public void setWmsWarehouse(WmsWarehouse wmsWarehouse) {
		this.wmsWarehouse = wmsWarehouse;
	}

	public String getStorageName() {
		return this.storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Set getWmsShelfs() {
		return this.wmsShelfs;
	}

	public void setWmsShelfs(Set wmsShelfs) {
		this.wmsShelfs = wmsShelfs;
	}

	public Set getWmsStorageConditions() {
		return this.wmsStorageConditions;
	}

	public void setWmsStorageConditions(Set wmsStorageConditions) {
		this.wmsStorageConditions = wmsStorageConditions;
	}

}
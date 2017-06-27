package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsWarehouse entity. @author MyEclipse Persistence Tools
 */

public class WmsWarehouse implements java.io.Serializable {

	// Fields

	private Integer warehouseId;
	private WmsUser wmsUser;
	private String warehouseName;
	private String warehouseAddress;
	private String warehouseLocation;
	private Set wmsOrders = new HashSet(0);
	private Set wmsDispatchsForDispatchTo = new HashSet(0);
	private Set wmsChecks = new HashSet(0);
	private Set wmsStorages = new HashSet(0);
	private Set wmsInApplications = new HashSet(0);
	private Set wmsDispatchsForDispatchFrom = new HashSet(0);
	private Set wmsOutApplications = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsWarehouse() {
	}

	/** minimal constructor */
	public WmsWarehouse(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	/** full constructor */
	public WmsWarehouse(Integer warehouseId, WmsUser wmsUser, String warehouseName, String warehouseAddress,
			String warehouseLocation, Set wmsOrders, Set wmsDispatchsForDispatchTo, Set wmsChecks, Set wmsStorages,
			Set wmsInApplications, Set wmsDispatchsForDispatchFrom, Set wmsOutApplications) {
		this.warehouseId = warehouseId;
		this.wmsUser = wmsUser;
		this.warehouseName = warehouseName;
		this.warehouseAddress = warehouseAddress;
		this.warehouseLocation = warehouseLocation;
		this.wmsOrders = wmsOrders;
		this.wmsDispatchsForDispatchTo = wmsDispatchsForDispatchTo;
		this.wmsChecks = wmsChecks;
		this.wmsStorages = wmsStorages;
		this.wmsInApplications = wmsInApplications;
		this.wmsDispatchsForDispatchFrom = wmsDispatchsForDispatchFrom;
		this.wmsOutApplications = wmsOutApplications;
	}

	// Property accessors

	public Integer getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public WmsUser getWmsUser() {
		return this.wmsUser;
	}

	public void setWmsUser(WmsUser wmsUser) {
		this.wmsUser = wmsUser;
	}

	public String getWarehouseName() {
		return this.warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseAddress() {
		return this.warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public String getWarehouseLocation() {
		return this.warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public Set getWmsOrders() {
		return this.wmsOrders;
	}

	public void setWmsOrders(Set wmsOrders) {
		this.wmsOrders = wmsOrders;
	}

	public Set getWmsDispatchsForDispatchTo() {
		return this.wmsDispatchsForDispatchTo;
	}

	public void setWmsDispatchsForDispatchTo(Set wmsDispatchsForDispatchTo) {
		this.wmsDispatchsForDispatchTo = wmsDispatchsForDispatchTo;
	}

	public Set getWmsChecks() {
		return this.wmsChecks;
	}

	public void setWmsChecks(Set wmsChecks) {
		this.wmsChecks = wmsChecks;
	}

	public Set getWmsStorages() {
		return this.wmsStorages;
	}

	public void setWmsStorages(Set wmsStorages) {
		this.wmsStorages = wmsStorages;
	}

	public Set getWmsInApplications() {
		return this.wmsInApplications;
	}

	public void setWmsInApplications(Set wmsInApplications) {
		this.wmsInApplications = wmsInApplications;
	}

	public Set getWmsDispatchsForDispatchFrom() {
		return this.wmsDispatchsForDispatchFrom;
	}

	public void setWmsDispatchsForDispatchFrom(Set wmsDispatchsForDispatchFrom) {
		this.wmsDispatchsForDispatchFrom = wmsDispatchsForDispatchFrom;
	}

	public Set getWmsOutApplications() {
		return this.wmsOutApplications;
	}

	public void setWmsOutApplications(Set wmsOutApplications) {
		this.wmsOutApplications = wmsOutApplications;
	}

}
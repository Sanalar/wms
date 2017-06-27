package pub.sanalar.wms.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * WmsDispatch entity. @author MyEclipse Persistence Tools
 */

public class WmsDispatch implements java.io.Serializable {

	// Fields

	private String dispatchId;
	private WmsDispatchState wmsDispatchState;
	private WmsUser wmsUserByDispatchAccpetor;
	private WmsWarehouse wmsWarehouseByDispatchTo;
	private WmsWarehouse wmsWarehouseByDispatchFrom;
	private WmsUser wmsUserByDispatchFinisher;
	private WmsUser wmsUserByDispatchCreator;
	private Timestamp dispatchCreateTime;
	private Timestamp dispatchAcceptTime;
	private Timestamp dispatchFinishTime;
	private String dispatchDescription;
	private Set wmsDispatchProductShelfs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsDispatch() {
	}

	/** minimal constructor */
	public WmsDispatch(String dispatchId) {
		this.dispatchId = dispatchId;
	}

	/** full constructor */
	public WmsDispatch(String dispatchId, WmsDispatchState wmsDispatchState, WmsUser wmsUserByDispatchAccpetor,
			WmsWarehouse wmsWarehouseByDispatchTo, WmsWarehouse wmsWarehouseByDispatchFrom,
			WmsUser wmsUserByDispatchFinisher, WmsUser wmsUserByDispatchCreator, Timestamp dispatchCreateTime,
			Timestamp dispatchAcceptTime, Timestamp dispatchFinishTime, String dispatchDescription,
			Set wmsDispatchProductShelfs) {
		this.dispatchId = dispatchId;
		this.wmsDispatchState = wmsDispatchState;
		this.wmsUserByDispatchAccpetor = wmsUserByDispatchAccpetor;
		this.wmsWarehouseByDispatchTo = wmsWarehouseByDispatchTo;
		this.wmsWarehouseByDispatchFrom = wmsWarehouseByDispatchFrom;
		this.wmsUserByDispatchFinisher = wmsUserByDispatchFinisher;
		this.wmsUserByDispatchCreator = wmsUserByDispatchCreator;
		this.dispatchCreateTime = dispatchCreateTime;
		this.dispatchAcceptTime = dispatchAcceptTime;
		this.dispatchFinishTime = dispatchFinishTime;
		this.dispatchDescription = dispatchDescription;
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
	}

	// Property accessors

	public String getDispatchId() {
		return this.dispatchId;
	}

	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
	}

	public WmsDispatchState getWmsDispatchState() {
		return this.wmsDispatchState;
	}

	public void setWmsDispatchState(WmsDispatchState wmsDispatchState) {
		this.wmsDispatchState = wmsDispatchState;
	}

	public WmsUser getWmsUserByDispatchAccpetor() {
		return this.wmsUserByDispatchAccpetor;
	}

	public void setWmsUserByDispatchAccpetor(WmsUser wmsUserByDispatchAccpetor) {
		this.wmsUserByDispatchAccpetor = wmsUserByDispatchAccpetor;
	}

	public WmsWarehouse getWmsWarehouseByDispatchTo() {
		return this.wmsWarehouseByDispatchTo;
	}

	public void setWmsWarehouseByDispatchTo(WmsWarehouse wmsWarehouseByDispatchTo) {
		this.wmsWarehouseByDispatchTo = wmsWarehouseByDispatchTo;
	}

	public WmsWarehouse getWmsWarehouseByDispatchFrom() {
		return this.wmsWarehouseByDispatchFrom;
	}

	public void setWmsWarehouseByDispatchFrom(WmsWarehouse wmsWarehouseByDispatchFrom) {
		this.wmsWarehouseByDispatchFrom = wmsWarehouseByDispatchFrom;
	}

	public WmsUser getWmsUserByDispatchFinisher() {
		return this.wmsUserByDispatchFinisher;
	}

	public void setWmsUserByDispatchFinisher(WmsUser wmsUserByDispatchFinisher) {
		this.wmsUserByDispatchFinisher = wmsUserByDispatchFinisher;
	}

	public WmsUser getWmsUserByDispatchCreator() {
		return this.wmsUserByDispatchCreator;
	}

	public void setWmsUserByDispatchCreator(WmsUser wmsUserByDispatchCreator) {
		this.wmsUserByDispatchCreator = wmsUserByDispatchCreator;
	}

	public Timestamp getDispatchCreateTime() {
		return this.dispatchCreateTime;
	}

	public void setDispatchCreateTime(Timestamp dispatchCreateTime) {
		this.dispatchCreateTime = dispatchCreateTime;
	}

	public Timestamp getDispatchAcceptTime() {
		return this.dispatchAcceptTime;
	}

	public void setDispatchAcceptTime(Timestamp dispatchAcceptTime) {
		this.dispatchAcceptTime = dispatchAcceptTime;
	}

	public Timestamp getDispatchFinishTime() {
		return this.dispatchFinishTime;
	}

	public void setDispatchFinishTime(Timestamp dispatchFinishTime) {
		this.dispatchFinishTime = dispatchFinishTime;
	}

	public String getDispatchDescription() {
		return this.dispatchDescription;
	}

	public void setDispatchDescription(String dispatchDescription) {
		this.dispatchDescription = dispatchDescription;
	}

	public Set getWmsDispatchProductShelfs() {
		return this.wmsDispatchProductShelfs;
	}

	public void setWmsDispatchProductShelfs(Set wmsDispatchProductShelfs) {
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
	}

}
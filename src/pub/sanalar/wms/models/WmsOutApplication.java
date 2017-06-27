package pub.sanalar.wms.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * WmsOutApplication entity. @author MyEclipse Persistence Tools
 */

public class WmsOutApplication implements java.io.Serializable {

	// Fields

	private String applicationId;
	private WmsUser wmsUserByApplicationCreator;
	private WmsApplicationState wmsApplicationState;
	private WmsUser wmsUserByApplicationAcceptor;
	private WmsWarehouse wmsWarehouse;
	private Timestamp applicationTime;
	private Timestamp applicationAcceptTime;
	private String applicationDescription;
	private Set wmsOutApplicationProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsOutApplication() {
	}

	/** minimal constructor */
	public WmsOutApplication(String applicationId) {
		this.applicationId = applicationId;
	}

	/** full constructor */
	public WmsOutApplication(String applicationId, WmsUser wmsUserByApplicationCreator,
			WmsApplicationState wmsApplicationState, WmsUser wmsUserByApplicationAcceptor, WmsWarehouse wmsWarehouse,
			Timestamp applicationTime, Timestamp applicationAcceptTime, String applicationDescription,
			Set wmsOutApplicationProducts) {
		this.applicationId = applicationId;
		this.wmsUserByApplicationCreator = wmsUserByApplicationCreator;
		this.wmsApplicationState = wmsApplicationState;
		this.wmsUserByApplicationAcceptor = wmsUserByApplicationAcceptor;
		this.wmsWarehouse = wmsWarehouse;
		this.applicationTime = applicationTime;
		this.applicationAcceptTime = applicationAcceptTime;
		this.applicationDescription = applicationDescription;
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
	}

	// Property accessors

	public String getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public WmsUser getWmsUserByApplicationCreator() {
		return this.wmsUserByApplicationCreator;
	}

	public void setWmsUserByApplicationCreator(WmsUser wmsUserByApplicationCreator) {
		this.wmsUserByApplicationCreator = wmsUserByApplicationCreator;
	}

	public WmsApplicationState getWmsApplicationState() {
		return this.wmsApplicationState;
	}

	public void setWmsApplicationState(WmsApplicationState wmsApplicationState) {
		this.wmsApplicationState = wmsApplicationState;
	}

	public WmsUser getWmsUserByApplicationAcceptor() {
		return this.wmsUserByApplicationAcceptor;
	}

	public void setWmsUserByApplicationAcceptor(WmsUser wmsUserByApplicationAcceptor) {
		this.wmsUserByApplicationAcceptor = wmsUserByApplicationAcceptor;
	}

	public WmsWarehouse getWmsWarehouse() {
		return this.wmsWarehouse;
	}

	public void setWmsWarehouse(WmsWarehouse wmsWarehouse) {
		this.wmsWarehouse = wmsWarehouse;
	}

	public Timestamp getApplicationTime() {
		return this.applicationTime;
	}

	public void setApplicationTime(Timestamp applicationTime) {
		this.applicationTime = applicationTime;
	}

	public Timestamp getApplicationAcceptTime() {
		return this.applicationAcceptTime;
	}

	public void setApplicationAcceptTime(Timestamp applicationAcceptTime) {
		this.applicationAcceptTime = applicationAcceptTime;
	}

	public String getApplicationDescription() {
		return this.applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public Set getWmsOutApplicationProducts() {
		return this.wmsOutApplicationProducts;
	}

	public void setWmsOutApplicationProducts(Set wmsOutApplicationProducts) {
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
	}

}
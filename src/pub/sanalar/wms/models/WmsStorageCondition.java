package pub.sanalar.wms.models;

/**
 * WmsStorageCondition entity. @author MyEclipse Persistence Tools
 */

public class WmsStorageCondition implements java.io.Serializable {

	// Fields

	private Integer scId;
	private WmsCondition wmsCondition;
	private WmsStorage wmsStorage;

	// Constructors

	/** default constructor */
	public WmsStorageCondition() {
	}

	/** minimal constructor */
	public WmsStorageCondition(Integer scId) {
		this.scId = scId;
	}

	/** full constructor */
	public WmsStorageCondition(Integer scId, WmsCondition wmsCondition, WmsStorage wmsStorage) {
		this.scId = scId;
		this.wmsCondition = wmsCondition;
		this.wmsStorage = wmsStorage;
	}

	// Property accessors

	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public WmsCondition getWmsCondition() {
		return this.wmsCondition;
	}

	public void setWmsCondition(WmsCondition wmsCondition) {
		this.wmsCondition = wmsCondition;
	}

	public WmsStorage getWmsStorage() {
		return this.wmsStorage;
	}

	public void setWmsStorage(WmsStorage wmsStorage) {
		this.wmsStorage = wmsStorage;
	}

}
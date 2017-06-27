package pub.sanalar.wms.models;

/**
 * WmsProductCondition entity. @author MyEclipse Persistence Tools
 */

public class WmsProductCondition implements java.io.Serializable {

	// Fields

	private Integer pcId;
	private WmsProduct wmsProduct;
	private WmsCondition wmsCondition;

	// Constructors

	/** default constructor */
	public WmsProductCondition() {
	}

	/** minimal constructor */
	public WmsProductCondition(Integer pcId) {
		this.pcId = pcId;
	}

	/** full constructor */
	public WmsProductCondition(Integer pcId, WmsProduct wmsProduct, WmsCondition wmsCondition) {
		this.pcId = pcId;
		this.wmsProduct = wmsProduct;
		this.wmsCondition = wmsCondition;
	}

	// Property accessors

	public Integer getPcId() {
		return this.pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public WmsProduct getWmsProduct() {
		return this.wmsProduct;
	}

	public void setWmsProduct(WmsProduct wmsProduct) {
		this.wmsProduct = wmsProduct;
	}

	public WmsCondition getWmsCondition() {
		return this.wmsCondition;
	}

	public void setWmsCondition(WmsCondition wmsCondition) {
		this.wmsCondition = wmsCondition;
	}

}
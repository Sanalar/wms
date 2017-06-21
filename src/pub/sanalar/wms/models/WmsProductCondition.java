package pub.sanalar.wms.models;

/**
 * WmsProductCondition entity. @author MyEclipse Persistence Tools
 */

public class WmsProductCondition implements java.io.Serializable {

	// Fields

	private Integer productConditionId;
	private WmsProduct wmsProduct;
	private WmsCondition wmsCondition;

	// Constructors

	/** default constructor */
	public WmsProductCondition() {
	}

	/** full constructor */
	public WmsProductCondition(WmsProduct wmsProduct, WmsCondition wmsCondition) {
		this.wmsProduct = wmsProduct;
		this.wmsCondition = wmsCondition;
	}

	// Property accessors

	public Integer getProductConditionId() {
		return this.productConditionId;
	}

	public void setProductConditionId(Integer productConditionId) {
		this.productConditionId = productConditionId;
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
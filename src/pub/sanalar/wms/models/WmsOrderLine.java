package pub.sanalar.wms.models;

/**
 * WmsOrderLine entity. @author MyEclipse Persistence Tools
 */

public class WmsOrderLine implements java.io.Serializable {

	// Fields

	private Integer lineId;
	private WmsOrder wmsOrder;
	private WmsProduct wmsProduct;
	private WmsSupplier wmsSupplier;
	private Integer lineCount;

	// Constructors

	/** default constructor */
	public WmsOrderLine() {
	}

	/** minimal constructor */
	public WmsOrderLine(Integer lineId) {
		this.lineId = lineId;
	}

	/** full constructor */
	public WmsOrderLine(Integer lineId, WmsOrder wmsOrder, WmsProduct wmsProduct, WmsSupplier wmsSupplier,
			Integer lineCount) {
		this.lineId = lineId;
		this.wmsOrder = wmsOrder;
		this.wmsProduct = wmsProduct;
		this.wmsSupplier = wmsSupplier;
		this.lineCount = lineCount;
	}

	// Property accessors

	public Integer getLineId() {
		return this.lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public WmsOrder getWmsOrder() {
		return this.wmsOrder;
	}

	public void setWmsOrder(WmsOrder wmsOrder) {
		this.wmsOrder = wmsOrder;
	}

	public WmsProduct getWmsProduct() {
		return this.wmsProduct;
	}

	public void setWmsProduct(WmsProduct wmsProduct) {
		this.wmsProduct = wmsProduct;
	}

	public WmsSupplier getWmsSupplier() {
		return this.wmsSupplier;
	}

	public void setWmsSupplier(WmsSupplier wmsSupplier) {
		this.wmsSupplier = wmsSupplier;
	}

	public Integer getLineCount() {
		return this.lineCount;
	}

	public void setLineCount(Integer lineCount) {
		this.lineCount = lineCount;
	}

}
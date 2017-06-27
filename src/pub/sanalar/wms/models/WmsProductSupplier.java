package pub.sanalar.wms.models;

/**
 * WmsProductSupplier entity. @author MyEclipse Persistence Tools
 */

public class WmsProductSupplier implements java.io.Serializable {

	// Fields

	private Integer psId;
	private WmsProduct wmsProduct;
	private WmsSupplier wmsSupplier;
	private Double psInPrice;

	// Constructors

	/** default constructor */
	public WmsProductSupplier() {
	}

	/** minimal constructor */
	public WmsProductSupplier(Integer psId, WmsProduct wmsProduct, WmsSupplier wmsSupplier) {
		this.psId = psId;
		this.wmsProduct = wmsProduct;
		this.wmsSupplier = wmsSupplier;
	}

	/** full constructor */
	public WmsProductSupplier(Integer psId, WmsProduct wmsProduct, WmsSupplier wmsSupplier, Double psInPrice) {
		this.psId = psId;
		this.wmsProduct = wmsProduct;
		this.wmsSupplier = wmsSupplier;
		this.psInPrice = psInPrice;
	}

	// Property accessors

	public Integer getPsId() {
		return this.psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
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

	public Double getPsInPrice() {
		return this.psInPrice;
	}

	public void setPsInPrice(Double psInPrice) {
		this.psInPrice = psInPrice;
	}

}
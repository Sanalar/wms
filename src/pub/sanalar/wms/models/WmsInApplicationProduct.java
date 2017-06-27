package pub.sanalar.wms.models;

/**
 * WmsInApplicationProduct entity. @author MyEclipse Persistence Tools
 */

public class WmsInApplicationProduct implements java.io.Serializable {

	// Fields

	private Integer apId;
	private WmsShelf wmsShelf;
	private WmsInApplication wmsInApplication;
	private WmsProduct wmsProduct;
	private Integer apNumber;

	// Constructors

	/** default constructor */
	public WmsInApplicationProduct() {
	}

	/** minimal constructor */
	public WmsInApplicationProduct(Integer apId) {
		this.apId = apId;
	}

	/** full constructor */
	public WmsInApplicationProduct(Integer apId, WmsShelf wmsShelf, WmsInApplication wmsInApplication,
			WmsProduct wmsProduct, Integer apNumber) {
		this.apId = apId;
		this.wmsShelf = wmsShelf;
		this.wmsInApplication = wmsInApplication;
		this.wmsProduct = wmsProduct;
		this.apNumber = apNumber;
	}

	// Property accessors

	public Integer getApId() {
		return this.apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	public WmsShelf getWmsShelf() {
		return this.wmsShelf;
	}

	public void setWmsShelf(WmsShelf wmsShelf) {
		this.wmsShelf = wmsShelf;
	}

	public WmsInApplication getWmsInApplication() {
		return this.wmsInApplication;
	}

	public void setWmsInApplication(WmsInApplication wmsInApplication) {
		this.wmsInApplication = wmsInApplication;
	}

	public WmsProduct getWmsProduct() {
		return this.wmsProduct;
	}

	public void setWmsProduct(WmsProduct wmsProduct) {
		this.wmsProduct = wmsProduct;
	}

	public Integer getApNumber() {
		return this.apNumber;
	}

	public void setApNumber(Integer apNumber) {
		this.apNumber = apNumber;
	}

}
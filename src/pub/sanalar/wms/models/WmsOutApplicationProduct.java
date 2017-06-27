package pub.sanalar.wms.models;

/**
 * WmsOutApplicationProduct entity. @author MyEclipse Persistence Tools
 */

public class WmsOutApplicationProduct implements java.io.Serializable {

	// Fields

	private Integer apId;
	private WmsShelf wmsShelf;
	private WmsOutApplication wmsOutApplication;
	private WmsProduct wmsProduct;
	private Integer apNumber;

	// Constructors

	/** default constructor */
	public WmsOutApplicationProduct() {
	}

	/** minimal constructor */
	public WmsOutApplicationProduct(Integer apId) {
		this.apId = apId;
	}

	/** full constructor */
	public WmsOutApplicationProduct(Integer apId, WmsShelf wmsShelf, WmsOutApplication wmsOutApplication,
			WmsProduct wmsProduct, Integer apNumber) {
		this.apId = apId;
		this.wmsShelf = wmsShelf;
		this.wmsOutApplication = wmsOutApplication;
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

	public WmsOutApplication getWmsOutApplication() {
		return this.wmsOutApplication;
	}

	public void setWmsOutApplication(WmsOutApplication wmsOutApplication) {
		this.wmsOutApplication = wmsOutApplication;
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
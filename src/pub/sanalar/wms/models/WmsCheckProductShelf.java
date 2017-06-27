package pub.sanalar.wms.models;

/**
 * WmsCheckProductShelf entity. @author MyEclipse Persistence Tools
 */

public class WmsCheckProductShelf implements java.io.Serializable {

	// Fields

	private Integer cpsId;
	private WmsCheck wmsCheck;
	private WmsShelf wmsShelf;
	private WmsProduct wmsProduct;
	private Integer cpsNumber;

	// Constructors

	/** default constructor */
	public WmsCheckProductShelf() {
	}

	/** minimal constructor */
	public WmsCheckProductShelf(Integer cpsId) {
		this.cpsId = cpsId;
	}

	/** full constructor */
	public WmsCheckProductShelf(Integer cpsId, WmsCheck wmsCheck, WmsShelf wmsShelf, WmsProduct wmsProduct,
			Integer cpsNumber) {
		this.cpsId = cpsId;
		this.wmsCheck = wmsCheck;
		this.wmsShelf = wmsShelf;
		this.wmsProduct = wmsProduct;
		this.cpsNumber = cpsNumber;
	}

	// Property accessors

	public Integer getCpsId() {
		return this.cpsId;
	}

	public void setCpsId(Integer cpsId) {
		this.cpsId = cpsId;
	}

	public WmsCheck getWmsCheck() {
		return this.wmsCheck;
	}

	public void setWmsCheck(WmsCheck wmsCheck) {
		this.wmsCheck = wmsCheck;
	}

	public WmsShelf getWmsShelf() {
		return this.wmsShelf;
	}

	public void setWmsShelf(WmsShelf wmsShelf) {
		this.wmsShelf = wmsShelf;
	}

	public WmsProduct getWmsProduct() {
		return this.wmsProduct;
	}

	public void setWmsProduct(WmsProduct wmsProduct) {
		this.wmsProduct = wmsProduct;
	}

	public Integer getCpsNumber() {
		return this.cpsNumber;
	}

	public void setCpsNumber(Integer cpsNumber) {
		this.cpsNumber = cpsNumber;
	}

}
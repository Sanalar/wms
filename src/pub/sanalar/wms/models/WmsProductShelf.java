package pub.sanalar.wms.models;

/**
 * WmsProductShelf entity. @author MyEclipse Persistence Tools
 */

public class WmsProductShelf implements java.io.Serializable {

	// Fields

	private Integer psId;
	private WmsShelf wmsShelf;
	private WmsProduct wmsProduct;
	private Integer psNumber;

	// Constructors

	/** default constructor */
	public WmsProductShelf() {
	}

	/** minimal constructor */
	public WmsProductShelf(Integer psId) {
		this.psId = psId;
	}

	/** full constructor */
	public WmsProductShelf(Integer psId, WmsShelf wmsShelf, WmsProduct wmsProduct, Integer psNumber) {
		this.psId = psId;
		this.wmsShelf = wmsShelf;
		this.wmsProduct = wmsProduct;
		this.psNumber = psNumber;
	}

	// Property accessors

	public Integer getPsId() {
		return this.psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
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

	public Integer getPsNumber() {
		return this.psNumber;
	}

	public void setPsNumber(Integer psNumber) {
		this.psNumber = psNumber;
	}

}
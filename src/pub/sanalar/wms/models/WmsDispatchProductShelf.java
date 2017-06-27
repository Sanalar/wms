package pub.sanalar.wms.models;

/**
 * WmsDispatchProductShelf entity. @author MyEclipse Persistence Tools
 */

public class WmsDispatchProductShelf implements java.io.Serializable {

	// Fields

	private Integer dpsId;
	private WmsShelf wmsShelf;
	private WmsDispatch wmsDispatch;
	private WmsProduct wmsProduct;
	private Integer dpsNumber;
	private Double dpsCost;

	// Constructors

	/** default constructor */
	public WmsDispatchProductShelf() {
	}

	/** minimal constructor */
	public WmsDispatchProductShelf(Integer dpsId) {
		this.dpsId = dpsId;
	}

	/** full constructor */
	public WmsDispatchProductShelf(Integer dpsId, WmsShelf wmsShelf, WmsDispatch wmsDispatch, WmsProduct wmsProduct,
			Integer dpsNumber, Double dpsCost) {
		this.dpsId = dpsId;
		this.wmsShelf = wmsShelf;
		this.wmsDispatch = wmsDispatch;
		this.wmsProduct = wmsProduct;
		this.dpsNumber = dpsNumber;
		this.dpsCost = dpsCost;
	}

	// Property accessors

	public Integer getDpsId() {
		return this.dpsId;
	}

	public void setDpsId(Integer dpsId) {
		this.dpsId = dpsId;
	}

	public WmsShelf getWmsShelf() {
		return this.wmsShelf;
	}

	public void setWmsShelf(WmsShelf wmsShelf) {
		this.wmsShelf = wmsShelf;
	}

	public WmsDispatch getWmsDispatch() {
		return this.wmsDispatch;
	}

	public void setWmsDispatch(WmsDispatch wmsDispatch) {
		this.wmsDispatch = wmsDispatch;
	}

	public WmsProduct getWmsProduct() {
		return this.wmsProduct;
	}

	public void setWmsProduct(WmsProduct wmsProduct) {
		this.wmsProduct = wmsProduct;
	}

	public Integer getDpsNumber() {
		return this.dpsNumber;
	}

	public void setDpsNumber(Integer dpsNumber) {
		this.dpsNumber = dpsNumber;
	}

	public Double getDpsCost() {
		return this.dpsCost;
	}

	public void setDpsCost(Double dpsCost) {
		this.dpsCost = dpsCost;
	}

}
package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsProduct entity. @author MyEclipse Persistence Tools
 */

public class WmsProduct implements java.io.Serializable {

	// Fields

	private Integer productId;
	private WmsCategory wmsCategory;
	private String productName;
	private String productCode;
	private String productDescription;
	private String productImage;
	private String productStandard;
	private String productUnit;
	private Set wmsDispatchProductShelfs = new HashSet(0);
	private Set wmsInApplicationProducts = new HashSet(0);
	private Set wmsOrderLines = new HashSet(0);
	private Set wmsProductShelfs = new HashSet(0);
	private Set wmsProductSuppliers = new HashSet(0);
	private Set wmsOutApplicationProducts = new HashSet(0);
	private Set wmsCheckProductShelfs = new HashSet(0);
	private Set wmsProductConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsProduct() {
	}

	/** minimal constructor */
	public WmsProduct(Integer productId) {
		this.productId = productId;
	}

	/** full constructor */
	public WmsProduct(Integer productId, WmsCategory wmsCategory, String productName, String productCode,
			String productDescription, String productImage, String productStandard, String productUnit,
			Set wmsDispatchProductShelfs, Set wmsInApplicationProducts, Set wmsOrderLines, Set wmsProductShelfs,
			Set wmsProductSuppliers, Set wmsOutApplicationProducts, Set wmsCheckProductShelfs,
			Set wmsProductConditions) {
		this.productId = productId;
		this.wmsCategory = wmsCategory;
		this.productName = productName;
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productStandard = productStandard;
		this.productUnit = productUnit;
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
		this.wmsInApplicationProducts = wmsInApplicationProducts;
		this.wmsOrderLines = wmsOrderLines;
		this.wmsProductShelfs = wmsProductShelfs;
		this.wmsProductSuppliers = wmsProductSuppliers;
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
		this.wmsProductConditions = wmsProductConditions;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public WmsCategory getWmsCategory() {
		return this.wmsCategory;
	}

	public void setWmsCategory(WmsCategory wmsCategory) {
		this.wmsCategory = wmsCategory;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductStandard() {
		return this.productStandard;
	}

	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}

	public String getProductUnit() {
		return this.productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public Set getWmsDispatchProductShelfs() {
		return this.wmsDispatchProductShelfs;
	}

	public void setWmsDispatchProductShelfs(Set wmsDispatchProductShelfs) {
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
	}

	public Set getWmsInApplicationProducts() {
		return this.wmsInApplicationProducts;
	}

	public void setWmsInApplicationProducts(Set wmsInApplicationProducts) {
		this.wmsInApplicationProducts = wmsInApplicationProducts;
	}

	public Set getWmsOrderLines() {
		return this.wmsOrderLines;
	}

	public void setWmsOrderLines(Set wmsOrderLines) {
		this.wmsOrderLines = wmsOrderLines;
	}

	public Set getWmsProductShelfs() {
		return this.wmsProductShelfs;
	}

	public void setWmsProductShelfs(Set wmsProductShelfs) {
		this.wmsProductShelfs = wmsProductShelfs;
	}

	public Set getWmsProductSuppliers() {
		return this.wmsProductSuppliers;
	}

	public void setWmsProductSuppliers(Set wmsProductSuppliers) {
		this.wmsProductSuppliers = wmsProductSuppliers;
	}

	public Set getWmsOutApplicationProducts() {
		return this.wmsOutApplicationProducts;
	}

	public void setWmsOutApplicationProducts(Set wmsOutApplicationProducts) {
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
	}

	public Set getWmsCheckProductShelfs() {
		return this.wmsCheckProductShelfs;
	}

	public void setWmsCheckProductShelfs(Set wmsCheckProductShelfs) {
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
	}

	public Set getWmsProductConditions() {
		return this.wmsProductConditions;
	}

	public void setWmsProductConditions(Set wmsProductConditions) {
		this.wmsProductConditions = wmsProductConditions;
	}

}
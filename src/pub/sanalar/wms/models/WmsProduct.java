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
	private String productSupplier;
	private String productStandard;
	private String productUint;
	private Double productInPrice;
	private Double productOutPrice;
	private String productDescription;
	private String productImage;
	private Set wmsProductConditions = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsProduct() {
	}

	/** minimal constructor */
	public WmsProduct(WmsCategory wmsCategory, String productName, String productCode, Double productInPrice,
			Double productOutPrice, String productImage) {
		this.wmsCategory = wmsCategory;
		this.productName = productName;
		this.productCode = productCode;
		this.productInPrice = productInPrice;
		this.productOutPrice = productOutPrice;
		this.productImage = productImage;
	}

	/** full constructor */
	public WmsProduct(WmsCategory wmsCategory, String productName, String productCode, String productSupplier,
			String productStandard, String productUint, Double productInPrice, Double productOutPrice,
			String productDescription, String productImage, Set wmsProductConditions) {
		this.wmsCategory = wmsCategory;
		this.productName = productName;
		this.productCode = productCode;
		this.productSupplier = productSupplier;
		this.productStandard = productStandard;
		this.productUint = productUint;
		this.productInPrice = productInPrice;
		this.productOutPrice = productOutPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
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

	public String getProductSupplier() {
		return this.productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}

	public String getProductStandard() {
		return this.productStandard;
	}

	public void setProductStandard(String productStandard) {
		this.productStandard = productStandard;
	}

	public String getProductUint() {
		return this.productUint;
	}

	public void setProductUint(String productUint) {
		this.productUint = productUint;
	}

	public Double getProductInPrice() {
		return this.productInPrice;
	}

	public void setProductInPrice(Double productInPrice) {
		this.productInPrice = productInPrice;
	}

	public Double getProductOutPrice() {
		return this.productOutPrice;
	}

	public void setProductOutPrice(Double productOutPrice) {
		this.productOutPrice = productOutPrice;
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

	public Set getWmsProductConditions() {
		return this.wmsProductConditions;
	}

	public void setWmsProductConditions(Set wmsProductConditions) {
		this.wmsProductConditions = wmsProductConditions;
	}

}
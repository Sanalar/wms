package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsCategory entity. @author MyEclipse Persistence Tools
 */

public class WmsCategory implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private WmsCategory wmsCategory;
	private String categoryName;
	private Set wmsProducts = new HashSet(0);
	private Set wmsCategories = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsCategory() {
	}

	/** minimal constructor */
	public WmsCategory(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/** full constructor */
	public WmsCategory(Integer categoryId, WmsCategory wmsCategory, String categoryName, Set wmsProducts,
			Set wmsCategories) {
		this.categoryId = categoryId;
		this.wmsCategory = wmsCategory;
		this.categoryName = categoryName;
		this.wmsProducts = wmsProducts;
		this.wmsCategories = wmsCategories;
	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public WmsCategory getWmsCategory() {
		return this.wmsCategory;
	}

	public void setWmsCategory(WmsCategory wmsCategory) {
		this.wmsCategory = wmsCategory;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set getWmsProducts() {
		return this.wmsProducts;
	}

	public void setWmsProducts(Set wmsProducts) {
		this.wmsProducts = wmsProducts;
	}

	public Set getWmsCategories() {
		return this.wmsCategories;
	}

	public void setWmsCategories(Set wmsCategories) {
		this.wmsCategories = wmsCategories;
	}

}
package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsShelf entity. @author MyEclipse Persistence Tools
 */

public class WmsShelf implements java.io.Serializable {

	// Fields

	private Integer shelfId;
	private WmsStorage wmsStorage;
	private String shelfName;
	private Integer shelfCapacity;
	private Set wmsCheckProductShelfs = new HashSet(0);
	private Set wmsDispatchProductShelfs = new HashSet(0);
	private Set wmsOutApplicationProducts = new HashSet(0);
	private Set wmsInApplicationProducts = new HashSet(0);
	private Set wmsProductShelfs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsShelf() {
	}

	/** minimal constructor */
	public WmsShelf(Integer shelfId) {
		this.shelfId = shelfId;
	}

	/** full constructor */
	public WmsShelf(Integer shelfId, WmsStorage wmsStorage, String shelfName, Integer shelfCapacity,
			Set wmsCheckProductShelfs, Set wmsDispatchProductShelfs, Set wmsOutApplicationProducts,
			Set wmsInApplicationProducts, Set wmsProductShelfs) {
		this.shelfId = shelfId;
		this.wmsStorage = wmsStorage;
		this.shelfName = shelfName;
		this.shelfCapacity = shelfCapacity;
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
		this.wmsInApplicationProducts = wmsInApplicationProducts;
		this.wmsProductShelfs = wmsProductShelfs;
	}

	// Property accessors

	public Integer getShelfId() {
		return this.shelfId;
	}

	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}

	public WmsStorage getWmsStorage() {
		return this.wmsStorage;
	}

	public void setWmsStorage(WmsStorage wmsStorage) {
		this.wmsStorage = wmsStorage;
	}

	public String getShelfName() {
		return this.shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public Integer getShelfCapacity() {
		return this.shelfCapacity;
	}

	public void setShelfCapacity(Integer shelfCapacity) {
		this.shelfCapacity = shelfCapacity;
	}

	public Set getWmsCheckProductShelfs() {
		return this.wmsCheckProductShelfs;
	}

	public void setWmsCheckProductShelfs(Set wmsCheckProductShelfs) {
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
	}

	public Set getWmsDispatchProductShelfs() {
		return this.wmsDispatchProductShelfs;
	}

	public void setWmsDispatchProductShelfs(Set wmsDispatchProductShelfs) {
		this.wmsDispatchProductShelfs = wmsDispatchProductShelfs;
	}

	public Set getWmsOutApplicationProducts() {
		return this.wmsOutApplicationProducts;
	}

	public void setWmsOutApplicationProducts(Set wmsOutApplicationProducts) {
		this.wmsOutApplicationProducts = wmsOutApplicationProducts;
	}

	public Set getWmsInApplicationProducts() {
		return this.wmsInApplicationProducts;
	}

	public void setWmsInApplicationProducts(Set wmsInApplicationProducts) {
		this.wmsInApplicationProducts = wmsInApplicationProducts;
	}

	public Set getWmsProductShelfs() {
		return this.wmsProductShelfs;
	}

	public void setWmsProductShelfs(Set wmsProductShelfs) {
		this.wmsProductShelfs = wmsProductShelfs;
	}

}
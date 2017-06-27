package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsSupplier entity. @author MyEclipse Persistence Tools
 */

public class WmsSupplier implements java.io.Serializable {

	// Fields

	private Integer supplierId;
	private String supplierName;
	private String supplierContactPerson;
	private String supplierAddress;
	private String supplierPhone;
	private Set wmsProductSuppliers = new HashSet(0);
	private Set wmsOrderLines = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsSupplier() {
	}

	/** minimal constructor */
	public WmsSupplier(Integer supplierId) {
		this.supplierId = supplierId;
	}

	/** full constructor */
	public WmsSupplier(Integer supplierId, String supplierName, String supplierContactPerson, String supplierAddress,
			String supplierPhone, Set wmsProductSuppliers, Set wmsOrderLines) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierContactPerson = supplierContactPerson;
		this.supplierAddress = supplierAddress;
		this.supplierPhone = supplierPhone;
		this.wmsProductSuppliers = wmsProductSuppliers;
		this.wmsOrderLines = wmsOrderLines;
	}

	// Property accessors

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierContactPerson() {
		return this.supplierContactPerson;
	}

	public void setSupplierContactPerson(String supplierContactPerson) {
		this.supplierContactPerson = supplierContactPerson;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhone() {
		return this.supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public Set getWmsProductSuppliers() {
		return this.wmsProductSuppliers;
	}

	public void setWmsProductSuppliers(Set wmsProductSuppliers) {
		this.wmsProductSuppliers = wmsProductSuppliers;
	}

	public Set getWmsOrderLines() {
		return this.wmsOrderLines;
	}

	public void setWmsOrderLines(Set wmsOrderLines) {
		this.wmsOrderLines = wmsOrderLines;
	}

}
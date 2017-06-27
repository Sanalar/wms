package pub.sanalar.wms.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * WmsCheck entity. @author MyEclipse Persistence Tools
 */

public class WmsCheck implements java.io.Serializable {

	// Fields

	private String checkId;
	private WmsUser wmsUserByCheckAcceptor;
	private WmsUser wmsUserByCheckCreator;
	private WmsWarehouse wmsWarehouse;
	private WmsCheckState wmsCheckState;
	private Timestamp checkCreateTime;
	private Timestamp checkAcceptTime;
	private String checkDescription;
	private Set wmsCheckProductShelfs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsCheck() {
	}

	/** minimal constructor */
	public WmsCheck(String checkId) {
		this.checkId = checkId;
	}

	/** full constructor */
	public WmsCheck(String checkId, WmsUser wmsUserByCheckAcceptor, WmsUser wmsUserByCheckCreator,
			WmsWarehouse wmsWarehouse, WmsCheckState wmsCheckState, Timestamp checkCreateTime,
			Timestamp checkAcceptTime, String checkDescription, Set wmsCheckProductShelfs) {
		this.checkId = checkId;
		this.wmsUserByCheckAcceptor = wmsUserByCheckAcceptor;
		this.wmsUserByCheckCreator = wmsUserByCheckCreator;
		this.wmsWarehouse = wmsWarehouse;
		this.wmsCheckState = wmsCheckState;
		this.checkCreateTime = checkCreateTime;
		this.checkAcceptTime = checkAcceptTime;
		this.checkDescription = checkDescription;
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
	}

	// Property accessors

	public String getCheckId() {
		return this.checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public WmsUser getWmsUserByCheckAcceptor() {
		return this.wmsUserByCheckAcceptor;
	}

	public void setWmsUserByCheckAcceptor(WmsUser wmsUserByCheckAcceptor) {
		this.wmsUserByCheckAcceptor = wmsUserByCheckAcceptor;
	}

	public WmsUser getWmsUserByCheckCreator() {
		return this.wmsUserByCheckCreator;
	}

	public void setWmsUserByCheckCreator(WmsUser wmsUserByCheckCreator) {
		this.wmsUserByCheckCreator = wmsUserByCheckCreator;
	}

	public WmsWarehouse getWmsWarehouse() {
		return this.wmsWarehouse;
	}

	public void setWmsWarehouse(WmsWarehouse wmsWarehouse) {
		this.wmsWarehouse = wmsWarehouse;
	}

	public WmsCheckState getWmsCheckState() {
		return this.wmsCheckState;
	}

	public void setWmsCheckState(WmsCheckState wmsCheckState) {
		this.wmsCheckState = wmsCheckState;
	}

	public Timestamp getCheckCreateTime() {
		return this.checkCreateTime;
	}

	public void setCheckCreateTime(Timestamp checkCreateTime) {
		this.checkCreateTime = checkCreateTime;
	}

	public Timestamp getCheckAcceptTime() {
		return this.checkAcceptTime;
	}

	public void setCheckAcceptTime(Timestamp checkAcceptTime) {
		this.checkAcceptTime = checkAcceptTime;
	}

	public String getCheckDescription() {
		return this.checkDescription;
	}

	public void setCheckDescription(String checkDescription) {
		this.checkDescription = checkDescription;
	}

	public Set getWmsCheckProductShelfs() {
		return this.wmsCheckProductShelfs;
	}

	public void setWmsCheckProductShelfs(Set wmsCheckProductShelfs) {
		this.wmsCheckProductShelfs = wmsCheckProductShelfs;
	}

}
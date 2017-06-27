package pub.sanalar.wms.models;

import java.util.HashSet;
import java.util.Set;

/**
 * WmsUser entity. @author MyEclipse Persistence Tools
 */

public class WmsUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private WmsUserType wmsUserType;
	private String userName;
	private String userPswd;
	private String userEmail;
	private String userCellphone;
	private String userAddress;
	private String userRealName;
	private Set wmsDispatchsForDispatchAccpetor = new HashSet(0);
	private Set wmsInApplicationsForApplicationCreator = new HashSet(0);
	private Set wmsOrders = new HashSet(0);
	private Set wmsWarehouses = new HashSet(0);
	private Set wmsDispatchsForDispatchFinisher = new HashSet(0);
	private Set wmsOutApplicationsForApplicationCreator = new HashSet(0);
	private Set wmsDispatchsForDispatchCreator = new HashSet(0);
	private Set wmsInApplicationsForApplicationAcceptor = new HashSet(0);
	private Set wmsChecksForCheckAcceptor = new HashSet(0);
	private Set wmsChecksForCheckCreator = new HashSet(0);
	private Set wmsOutApplicationsForApplicationAcceptor = new HashSet(0);
	private Set wmsStorages = new HashSet(0);

	// Constructors

	/** default constructor */
	public WmsUser() {
	}

	/** minimal constructor */
	public WmsUser(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public WmsUser(Integer userId, WmsUserType wmsUserType, String userName, String userPswd, String userEmail,
			String userCellphone, String userAddress, String userRealName, Set wmsDispatchsForDispatchAccpetor,
			Set wmsInApplicationsForApplicationCreator, Set wmsOrders, Set wmsWarehouses,
			Set wmsDispatchsForDispatchFinisher, Set wmsOutApplicationsForApplicationCreator,
			Set wmsDispatchsForDispatchCreator, Set wmsInApplicationsForApplicationAcceptor,
			Set wmsChecksForCheckAcceptor, Set wmsChecksForCheckCreator, Set wmsOutApplicationsForApplicationAcceptor,
			Set wmsStorages) {
		this.userId = userId;
		this.wmsUserType = wmsUserType;
		this.userName = userName;
		this.userPswd = userPswd;
		this.userEmail = userEmail;
		this.userCellphone = userCellphone;
		this.userAddress = userAddress;
		this.userRealName = userRealName;
		this.wmsDispatchsForDispatchAccpetor = wmsDispatchsForDispatchAccpetor;
		this.wmsInApplicationsForApplicationCreator = wmsInApplicationsForApplicationCreator;
		this.wmsOrders = wmsOrders;
		this.wmsWarehouses = wmsWarehouses;
		this.wmsDispatchsForDispatchFinisher = wmsDispatchsForDispatchFinisher;
		this.wmsOutApplicationsForApplicationCreator = wmsOutApplicationsForApplicationCreator;
		this.wmsDispatchsForDispatchCreator = wmsDispatchsForDispatchCreator;
		this.wmsInApplicationsForApplicationAcceptor = wmsInApplicationsForApplicationAcceptor;
		this.wmsChecksForCheckAcceptor = wmsChecksForCheckAcceptor;
		this.wmsChecksForCheckCreator = wmsChecksForCheckCreator;
		this.wmsOutApplicationsForApplicationAcceptor = wmsOutApplicationsForApplicationAcceptor;
		this.wmsStorages = wmsStorages;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public WmsUserType getWmsUserType() {
		return this.wmsUserType;
	}

	public void setWmsUserType(WmsUserType wmsUserType) {
		this.wmsUserType = wmsUserType;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPswd() {
		return this.userPswd;
	}

	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCellphone() {
		return this.userCellphone;
	}

	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public Set getWmsDispatchsForDispatchAccpetor() {
		return this.wmsDispatchsForDispatchAccpetor;
	}

	public void setWmsDispatchsForDispatchAccpetor(Set wmsDispatchsForDispatchAccpetor) {
		this.wmsDispatchsForDispatchAccpetor = wmsDispatchsForDispatchAccpetor;
	}

	public Set getWmsInApplicationsForApplicationCreator() {
		return this.wmsInApplicationsForApplicationCreator;
	}

	public void setWmsInApplicationsForApplicationCreator(Set wmsInApplicationsForApplicationCreator) {
		this.wmsInApplicationsForApplicationCreator = wmsInApplicationsForApplicationCreator;
	}

	public Set getWmsOrders() {
		return this.wmsOrders;
	}

	public void setWmsOrders(Set wmsOrders) {
		this.wmsOrders = wmsOrders;
	}

	public Set getWmsWarehouses() {
		return this.wmsWarehouses;
	}

	public void setWmsWarehouses(Set wmsWarehouses) {
		this.wmsWarehouses = wmsWarehouses;
	}

	public Set getWmsDispatchsForDispatchFinisher() {
		return this.wmsDispatchsForDispatchFinisher;
	}

	public void setWmsDispatchsForDispatchFinisher(Set wmsDispatchsForDispatchFinisher) {
		this.wmsDispatchsForDispatchFinisher = wmsDispatchsForDispatchFinisher;
	}

	public Set getWmsOutApplicationsForApplicationCreator() {
		return this.wmsOutApplicationsForApplicationCreator;
	}

	public void setWmsOutApplicationsForApplicationCreator(Set wmsOutApplicationsForApplicationCreator) {
		this.wmsOutApplicationsForApplicationCreator = wmsOutApplicationsForApplicationCreator;
	}

	public Set getWmsDispatchsForDispatchCreator() {
		return this.wmsDispatchsForDispatchCreator;
	}

	public void setWmsDispatchsForDispatchCreator(Set wmsDispatchsForDispatchCreator) {
		this.wmsDispatchsForDispatchCreator = wmsDispatchsForDispatchCreator;
	}

	public Set getWmsInApplicationsForApplicationAcceptor() {
		return this.wmsInApplicationsForApplicationAcceptor;
	}

	public void setWmsInApplicationsForApplicationAcceptor(Set wmsInApplicationsForApplicationAcceptor) {
		this.wmsInApplicationsForApplicationAcceptor = wmsInApplicationsForApplicationAcceptor;
	}

	public Set getWmsChecksForCheckAcceptor() {
		return this.wmsChecksForCheckAcceptor;
	}

	public void setWmsChecksForCheckAcceptor(Set wmsChecksForCheckAcceptor) {
		this.wmsChecksForCheckAcceptor = wmsChecksForCheckAcceptor;
	}

	public Set getWmsChecksForCheckCreator() {
		return this.wmsChecksForCheckCreator;
	}

	public void setWmsChecksForCheckCreator(Set wmsChecksForCheckCreator) {
		this.wmsChecksForCheckCreator = wmsChecksForCheckCreator;
	}

	public Set getWmsOutApplicationsForApplicationAcceptor() {
		return this.wmsOutApplicationsForApplicationAcceptor;
	}

	public void setWmsOutApplicationsForApplicationAcceptor(Set wmsOutApplicationsForApplicationAcceptor) {
		this.wmsOutApplicationsForApplicationAcceptor = wmsOutApplicationsForApplicationAcceptor;
	}

	public Set getWmsStorages() {
		return this.wmsStorages;
	}

	public void setWmsStorages(Set wmsStorages) {
		this.wmsStorages = wmsStorages;
	}

}
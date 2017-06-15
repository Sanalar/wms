package pub.sanalar.wms.models;

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

	// Constructors

	/** default constructor */
	public WmsUser() {
	}

	/** minimal constructor */
	public WmsUser(WmsUserType wmsUserType, String userName, String userPswd) {
		this.wmsUserType = wmsUserType;
		this.userName = userName;
		this.userPswd = userPswd;
	}

	/** full constructor */
	public WmsUser(WmsUserType wmsUserType, String userName, String userPswd, String userEmail, String userCellphone,
			String userAddress) {
		this.wmsUserType = wmsUserType;
		this.userName = userName;
		this.userPswd = userPswd;
		this.userEmail = userEmail;
		this.userCellphone = userCellphone;
		this.userAddress = userAddress;
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

}
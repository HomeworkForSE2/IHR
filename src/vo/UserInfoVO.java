package vo;

import po.UserPO;

/* 用户ID
 * 账号
 * 密码
 * 联系方式	
 * 信用值
 */

public class UserInfoVO {
	private int userID;
	
	private String userName;
	
	private String password;
	
	private String phoneNumber;
	
	private int credit;

	//
	public UserInfoVO(int userID,String userName, String password, String phoneNumber,int credit) {
		super();
		this.userID=userID;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.credit=credit;
	}
	
	public UserInfoVO(UserPO user){
		this.userID=user.getUserID();
		this.userName=user.getUserName();
		this.phoneNumber=user.getPhoneNumber();
		this.credit=user.getCredit();
		
	}

	//

	public String getUserName() {
		return userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	

}

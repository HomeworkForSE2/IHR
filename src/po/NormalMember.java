package po;
/*
 * 普通用户
 * 生日
 */
public class NormalMember extends MemberPO{
	
	private int userID;
	 
	private String birthday;

	//
	public NormalMember(int userID, String birthday) {
		super();
		this.userID = userID;
		this.birthday = birthday;
	}
	

	//
	

	public String getBirthday() {
		return birthday;
	}

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	 
}

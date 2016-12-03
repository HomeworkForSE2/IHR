package po;

public class MemberPO {
	
	private int userID;
	
	private String birthday;
	
	private String enterpriseName;

	public MemberPO(int iD, String birthday, String enterpriseName) {
		super();
		userID = iD;
		this.birthday = birthday;
		this.enterpriseName = enterpriseName;
	}

	
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	
	
	

}

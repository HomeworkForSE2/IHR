package po;
/*
 * 企业用户
 * 企业名
 */

public class EnterpriseMember extends MemberPO {
	
	private int userID;
	
	private String enterpriseName;

	//
	


	public EnterpriseMember(int userID, String enterpriseName) {
		super();
		this.userID = userID;
		this.enterpriseName = enterpriseName;
	}
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	

}

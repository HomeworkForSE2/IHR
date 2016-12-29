package vo;

import po.MemberPO;

public class MemberVO implements java.io.Serializable{
	
	private String birthday;
	
	private String enterpriseName;
	
	public MemberVO(String birthday,String enterpriseName) {
		// TODO Auto-generated constructor stub
		this.birthday=birthday;
		this.enterpriseName=enterpriseName;
	}
	
	public MemberVO(MemberPO member){
		this.birthday=member.getBirthday();
		this.enterpriseName=member.getEnterpriseName();	
		
	}

	public String getBirthday() {
		//19970418
		String result=null;
		if(birthday==null||birthday.equals("null")){
			
		}else{
			result=birthday.substring(0,4)+"-"+birthday.substring(4,6)+"-"+birthday.substring(6,8);
		}
		return result;
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

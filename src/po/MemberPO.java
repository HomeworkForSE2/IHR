package po;

public class MemberPO {
	
	private int ID;
	
	private String string;
	
	public MemberPO(int iD, String string) {
		super();
		ID = iD;
		this.string = string;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	

}

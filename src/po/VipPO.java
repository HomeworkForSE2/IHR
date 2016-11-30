package po;
/*
 * vip等级
 * 对应所需信用值
 */

public class VipPO {
	
	private int vipGrade;

	private int vipGradeCredit;

	//
	public VipPO(int vipGrade, int vipGradeCredit) {
		super();
		this.vipGrade = vipGrade;
		this.vipGradeCredit = vipGradeCredit;
	}

	//
	public int getVipGrade() {
		return vipGrade;
	}

	public void setVipGrade(int vipGrade) {
		this.vipGrade = vipGrade;
	}

	public int getVipGradeCredit() {
		return vipGradeCredit;
	}

	public void setVipGradeCredit(int vipGradeCredit) {
		this.vipGradeCredit = vipGradeCredit;
	}
	
}

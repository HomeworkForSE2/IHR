package vo;

import po.VipPO;

public class VipVO {

	private int vipGrade;

	private int vipGradeCredit;

	public VipVO(VipPO vip){
		this.vipGrade=vip.getVipGrade();
		this.vipGradeCredit=vip.getVipGradeCredit();
		
	}
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

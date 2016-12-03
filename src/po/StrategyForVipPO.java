package po;
//特定商圈特定会员等级，策略类型为4
public class StrategyForVipPO extends StrategyPO{
	
	private String BD;
	
	private int vipGrade;
	
	public StrategyForVipPO(int ownerID, int strategyType, String strategyName, double discount, String startTime,
			String endTime,String BD,int vipGrade) {
		super(ownerID, 4, "VIP"+vipGrade+""+BD+"商圈优惠策略", discount, startTime, endTime);
		this.BD=BD;
		this.vipGrade=vipGrade;
		// TODO Auto-generated constructor stub
	}

	public String getBD() {
		return BD;
	}

	public void setBD(String bD) {
		BD = bD;
	}

	public int getVipGrade() {
		return vipGrade;
	}

	public void setVipGrade(int vipGrade) {
		this.vipGrade = vipGrade;
	}
	
	
	
	
	
	

}

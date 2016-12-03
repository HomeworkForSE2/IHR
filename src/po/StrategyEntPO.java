package po;
//合作企业类型为3
public class StrategyEntPO extends StrategyPO{

	private String enterpriseName;
	
	public StrategyEntPO(int ownerID, int strategyType, String strategyName, double discount, String startTime,
			String endTime,String enterpriseName) {
		super(ownerID, 3, "合作企业优惠策略", discount, startTime, endTime);
		this.enterpriseName=enterpriseName;
		// TODO Auto-generated constructor stub
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	
	

	
}

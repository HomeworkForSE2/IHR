package po;
/*
 * 拥有者
 * 策略类型0特殊时期1生日2房间3合作企业4vip
 * 名称
 * 折扣率
 * 起始时间
 * 结束时间
 */

public class StrategyPO {
	
	private int ownerID;

	private int strategyType;
	
	private String strategyName;
	
	private double discount;
	
	private String startTime;
	
	private String endTime;


	public StrategyPO(int ownerID, int strategyType, String strategyName, double discount, String startTime,
			String endTime) {
		super();
		this.ownerID = ownerID;
		this.strategyType = strategyType;
		this.strategyName = strategyName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getOwner() {
		return ownerID;
	}
	
	public void setOwner(int owner) {
		this.ownerID = owner;
	}
	public int getStrategyType() {
		return strategyType;
	}

	public void setStrategyType(int strategyType) {
		this.strategyType = strategyType;
	}
	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}

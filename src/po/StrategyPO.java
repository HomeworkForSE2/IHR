package po;
/*
 * 拥有者
 * 名称
 * 折扣率
 * 起始时间
 * 结束时间
 */

public class StrategyPO {
	
	private int ownerID;
	
	private String strategyName;
	
	private double discount;
	
	private String startTime;
	
	private String endTime;

	//
	public StrategyPO(int owner, String strategyName, double discount, String startTime, String endTime) {
		super();
		this.ownerID = owner;
		this.strategyName = strategyName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	//
	public int getOwner() {
		return ownerID;
	}

	public void setOwner(int owner) {
		this.ownerID = owner;
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

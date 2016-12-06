package vo;

import po.StrategyPO;

/*
 * 拥有者
 * 名称
 * 折扣率
 * 起始时间
 * 结束时间
 */
public class StrategyVO {
	private int ownerId;
	
	private String strategyName;
	
	private double discount;
	
	private String startTime;
	
	private String endTime;

	//
	public StrategyVO(int ownerId,String strategyName, double discount, String startTime, String endTime) {
		super();
		this.ownerId=ownerId;
		this.strategyName = strategyName;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	//
	public StrategyVO(StrategyPO strategy){
		this.strategyName=strategy.getStrategyName();
		this.discount=strategy.getDiscount();
		this.startTime=strategy.getStartTime();
		this.endTime=strategy.getEndTime();
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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

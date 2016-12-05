package vo;

import po.CreditChangePO;

/*
 * 时间
 * 订单号
 * 用户Id
 * 初始信用值
 * 剩余信用值
 * 动作（执行、异常、撤销、充值、恢复）
 */
public class CreditChangeVO {
	
	private String time;
	
	private int orderID;
		
	private int startCredit;
	
	private int endCredit;
	
	private int action;
	
	public CreditChangeVO(CreditChangePO creditChange){
		this.time=creditChange.getTime();
		this.orderID=creditChange.getOrderID();
		this.startCredit=creditChange.getStartCredit();
		this.endCredit=creditChange.getEndCredit();
		this.action=creditChange.getAction();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getStartCredit() {
		return startCredit;
	}

	public void setStartCredit(int startCredit) {
		this.startCredit = startCredit;
	}

	public int getEndCredit() {
		return endCredit;
	}

	public void setEndCredit(int endCredit) {
		this.endCredit = endCredit;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	

}

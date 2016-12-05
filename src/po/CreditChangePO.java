package po;

/*
 * 时间
 * 订单号
 * 用户Id
 * 初始信用值
 * 剩余信用值
<<<<<<< Updated upstream
 * 动作（执行0、异常1、撤销2、充值3 恢复4）
=======
 * 动作（执行0、异常1、撤销2、充值3、恢复4）
>>>>>>> Stashed changes
 */
public class CreditChangePO {
	
	private String time;
	
	private int orderID;
	
	private int userID;
		
	private int startCredit;
	
	private int endCredit;
	
	private int action;

	

	public CreditChangePO(String time, int orderID, int userID, int startCredit, int endCredit, int action) {
		super();
		this.time = time;
		this.orderID = orderID;
		this.userID = userID;
		this.startCredit = startCredit;
		this.endCredit = endCredit;
		this.action = action;
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


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
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

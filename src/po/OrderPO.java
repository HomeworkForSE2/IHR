package po;
/*
 * 用户Id
 * 酒店Id
 * 状态（已执行、未执行正常、已撤销、异常）
 * 价值（信用值）
 * 价格
 * 开始时间
 * 最晚订单执行时间
 * 退房时间
 * 房间类型
 * 数量
 * 入住人数
 * 有无儿童
 */

public class OrderPO {
	private int orderID=0;
	
	private int userID;
	
	private int hotelID;
	
	private int state;
	
	private int credit;
	
	private int price;
	
	private String startTime;
	
	private String endTime;
	
	private String finishTime;
	
	private int roomType;
	
	private int roomNum;
	
	private boolean hasChildren;

	//
	public OrderPO(int userID,int hotelID,int state, int credit, int price,String startTime, String endTime, String finishTime, int roomType,
			int roomNum,boolean hasChildren,int orderID) {
		super();
		this.userID=userID;
		this.hotelID=hotelID;
		this.state = state;
		this.credit = credit;
		this.price=price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finishTime = finishTime;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.hasChildren=hasChildren;
		this.orderID=orderID;
	}

	//
	
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public int getOrderID() {
		// TODO Auto-generated method stub
		return orderID;
	}
	public void setOrderID(){
		this.orderID=orderID+1;
	}
	
	
	

}

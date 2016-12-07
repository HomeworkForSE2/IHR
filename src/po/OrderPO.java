package po;
/* 订单ID
 * 用户ID
 * 酒店ID
 * 状态（1未执行、2已执行、3异常、4撤销）
 * 价格
 * 开始时间
 * 结束时间
 * 退房时间
 * 房间类型
 * 数量
 * 房间号
 * 入住人数
 * 有无儿童
 */

public class OrderPO {
	
	private int orderID;
	
	private int userID;
	
	private int hotelID;
	
	private int state;
	
	private int price;
	
	private String startTime;
	
	private String endTime;
	
	private String finishTime;
	
	private int roomType;
	
	private int roomNum;
	
	private boolean hasChildren;
	
	private String roomID;
	
	public OrderPO(int orderID, int userID, int hotelID, int state,int price, String startTime,
			String endTime, String finishTime, int roomType, int roomNum, boolean hasChildren,String roomID) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.hotelID = hotelID;
		this.state = state;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finishTime = finishTime;
		this.roomType = roomType;
		this.roomID=roomID;
		this.roomNum = roomNum;
		this.hasChildren = hasChildren;
	}
	
	
	public String getRoomID() {
		return roomID;
	}


	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


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

	
	
	

}

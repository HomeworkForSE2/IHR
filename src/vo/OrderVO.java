package vo;

import po.OrderPO;

/*
 * 用户Id
 * 酒店Id
 * 状态（已执行、未执行正常、已撤销、异常）
 * 价值（信用值）
 * 开始时间
 * 最晚订单执行时间
 * 退房时间
 * 房间类型
 * 数量
 * 入住人数
 * 有无儿童
 */
public class OrderVO {
	
	private int orderId;
	
	private int userId;
	
	private int hotelId;
	
	private int state;
	
	private int price;
	
	private String startTime;
	
	private String endTime;
	
	private String finishTime;
	
	private int roomType;
	
	private int roomNum;
	
	private boolean hasChildren;

	private String roomID;
	//
	
	
	
	//
	public OrderVO(OrderPO order){
		this.state=order.getState();
		this.startTime=order.getStartTime();
		this.endTime=order.getEndTime();
		this.finishTime=order.getFinishTime();
		this.roomType=order.getRoomType();
		this.roomNum=order.getRoomNum();
		this.hasChildren=order.isHasChildren();
		this.roomID=order.getRoomID();
		
	}

	public OrderVO(int orderId, int userId, int hotelId, int state,int price, String startTime,
			String endTime, String finishTime, int roomType, int roomNum, boolean hasChildren) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.state = state;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finishTime = finishTime;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.hasChildren = hasChildren;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getState() {
		return state;
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
		return orderId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

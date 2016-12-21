package vo;

import po.OrderPO;

/*
 * 用户Id
 * 酒店Id
 * 状态（1正常、2已执行、3异常、4已撤销）
 * 价值（信用值）
 * 开始时间
 * 最晚订单执行时间
 * 退房时间
 * 房间类型123
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
	
	private int peopleNum;
	
	private boolean hasChildren;

	private String roomID;
	//
	
	
	
	//
	public OrderVO(OrderPO order){
		this.userId=order.getUserID();
		this.orderId=order.getOrderID();
		this.hotelId=order.getHotelID();
		this.state=order.getState();
		this.startTime=order.getStartTime();
		this.endTime=order.getEndTime();
		this.finishTime=order.getFinishTime();
		this.roomType=order.getRoomType();
		this.roomNum=order.getRoomNum();
		this.hasChildren=order.isHasChildren();
		this.roomID=order.getRoomID();
		this.peopleNum=order.getPeopleNum();
		
	}

	public OrderVO(int orderId, int userId, int hotelId, int state,int price, String startTime,
			String endTime, String finishTime, int roomType, int roomNum, int peopleNum,boolean hasChildren) {
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
		this.peopleNum=peopleNum;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
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

	public String getState() {
		String result=null;
		if(this.state==1){
			result="正常";
			
		}else if(this.state==2){
			result="已执行";
			
		}else if(this.state==3){
			result="异常";
			
		}else if(this.state==4){
			result="已撤销";
			
		}
		return result;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStartTime() {
		String year=startTime.substring(0,4);
		String month=startTime.substring(4,6);
		String day=startTime.substring(6,8);
		return year+"-"+month+"-"+day;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		String year=endTime.substring(0,4);
		String month=endTime.substring(4,6);
		String day=endTime.substring(6,8);
		return year+"-"+month+"-"+day;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFinishTime() {
		String year=finishTime.substring(0,4);
		String month=finishTime.substring(4,6);
		String day=finishTime.substring(6,8);
		return year+"-"+month+"-"+day;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getRoomType() {
		String result=null;
		if(roomType==1){
			result="单人间";
		}else if(roomType==2){
			result="双人间";			
		}else if(roomType==3){
			result="三人间";		
		}
		return result;
	}
	
	public int getRoomType2(){
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

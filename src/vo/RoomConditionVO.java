package vo;

/*
 * 酒店查看的房间搜索条件
 * 房间类型
 * 价格
 * 数量
 * 起始时间
 * 结束时间
 *  
 */
public class RoomConditionVO {
	
	private int roomType;
	
	private int price;
	
	private int roomNum;
	
	private String startTime;
	
	private String endTime;
	

	public RoomConditionVO(int roomType, int price, int roomNum, String startTime, String endTime) {
		super();
		this.roomType = roomType;
		this.price = price;
		this.roomNum = roomNum;
		this.startTime = startTime;
		this.endTime = endTime;
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


	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	
	
	

}

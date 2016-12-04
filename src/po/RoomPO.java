package po;
/*
 * 酒店
 * 房间类型
 * 房间号
 * 原始价格
 * 状态
 */

public class RoomPO {
	
	private int hotelID;
	
	private int roomType;
	
	private int roomID;
	
	private double price;
	
	private boolean state;

	//
	public RoomPO(int hotelID, int roomType, int roomID, double price, boolean state) {
		super();
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.roomID = roomID;
		this.price = price;
		this.state = state;
	}

	//
	

	public int getRoomID() {
		return roomID;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setRoomID(int roomID2) {
		// TODO Auto-generated method stub
		this.roomID=roomID;
	}
	
	

}

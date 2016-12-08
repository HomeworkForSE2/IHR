package po;
/*
 * roomID
 * 酒店ID
 * 房间类型1单人房2双人房3三人房
 * 原始价格
 * 状态
 */

public class RoomPO {
	
	private int roomID;
	
	private int hotelID;
	
	private int roomType;
		
	private double price;
	
	private boolean state;//true ->已占用；false->空

	//
	public RoomPO(int roomID, int hotelID, int roomType, double price, boolean state) {
		super();
		this.roomID = roomID;
		this.hotelID = hotelID;
		this.roomType = roomType;
		this.price = price;
		this.state = state;
	}

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

	

}

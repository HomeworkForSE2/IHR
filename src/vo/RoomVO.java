package vo;
/*
 * roomID
 * 酒店ID
 * 房间类型1单人房2双人房3三人房
 * 价格
 * 状态
 */

import po.RoomPO;

public class RoomVO {
	private int roomID;
	
	private int hotelID;
	
	private int roomType;
		
	private double price;
	
	private boolean state;//true ->已占用；false->空
	
	public RoomVO(RoomPO room){
		this.roomID=room.getRoomID();
		this.hotelID=room.getHotelID();
		this.roomType=room.getRoomType();
		this.price=room.getPrice();
		this.state=room.isState();		
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
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

package vo;

import po.HotelPO;

/*
 *酒店id
 *酒店名称
 *是否有酒店工作人员
 *地址 
 *商圈 
 *星级 
 *简介 
 *设施服务
 *评分
 */
public class HotelInfoVO {
	private int hotelID;
	
	private String hotelName;
	
	private String location;
	
	private String BD;
	
	private int starNum;
	
	private String introduction;
	
	private String device;
	
	private int score;

	//
	public HotelInfoVO(int hotelID,String hotelName, String location, String bD, int starNum, String introduction, String device) {
		super();
		this.hotelID=hotelID;
		this.hotelName = hotelName;
		this.location = location;
		BD = bD;
		this.starNum = starNum;
		this.introduction = introduction;
		this.device = device;
	}
	
	//
	public HotelInfoVO(HotelPO hotel){
		this.hotelID=hotel.getHotelID();
		this.hotelName=hotel.getHotelName();
		this.location=hotel.getLocation();
		this.BD=hotel.getBD();
		this.starNum=hotel.getStarNum();
		this.introduction=hotel.getIntroduction();
		this.device=hotel.getDevice();
		this.score=hotel.getScore();
		
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBD() {
		return BD;
	}

	public void setBD(String bD) {
		BD = bD;
	}

	public int getStarNum() {
		return starNum;
	}

	public void setStarNum(int starNum) {
		this.starNum = starNum;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}

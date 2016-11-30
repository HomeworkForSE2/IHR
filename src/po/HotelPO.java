package po;

/*
 *酒店id
 *酒店名称
 *酒店工作人员
 *地址 
 *商圈 
 *星级 
 *简介 
 *设施服务
 *评分
 */

public class HotelPO {
	
	private int hotelID;
	
	private String hotelName;
	
	private UserPO hotelWorker;
	
	private String location;
	
	private String BD;
	
	private int starNum;
	
	private String introduction;
	
	private String device;
	
	private int score;
	
	//
	public HotelPO(int hotelID,String hotelName,UserPO hotelWorker,String location,String BD,int starNum,String introduction,String device,int score){
		super();
		this.hotelID=hotelID;
		this.hotelName=hotelName;
		this.hotelWorker=hotelWorker;
		this.location=location;
		this.BD=BD;
		this.starNum=starNum;
		this.introduction=introduction;
		this.device=device;
		this.score=score;
	}

	//

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

	public UserPO getHotelWorker() {
		return hotelWorker;
	}

	public void setHotelWorker(UserPO hotelWorker) {
		this.hotelWorker = hotelWorker;
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



	
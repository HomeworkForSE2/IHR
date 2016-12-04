package service;

import java.rmi.Remote;
import java.util.List;
import vo.HotelInfoVO;
import vo.RoomConditionVO;

public interface HotelBrowseService extends Remote{
	
	/**
	 * 
	 * @param hotelName
	 * @return 查找酒店信息
	 */
	public HotelInfoVO searchHotel(String hotelName);
	

	/**
	 * 
	 * @param location
	 * @param BD
	 * @param roomType
	 * @param star
	 * @param judgeScore
	 * @return 酒店排序列表
	 */
	public List<HotelInfoVO> viewHotelList(String location,String BD,RoomConditionVO condition,int star,int judgeScore);
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经预订酒店列表
	 */
	public List<HotelInfoVO> showReservedHotel(int userID);
}

package service;

import java.rmi.Remote;
import java.util.List;

import vo.HotelInfoVO;

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
	public List<HotelInfoVO> viewHotelList(String location,String BD,int roomType,int star,int judgeScore);
	
	
}

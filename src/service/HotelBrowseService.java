package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import vo.HotelInfoVO;
import vo.RoomConditionVO;

public interface HotelBrowseService extends Remote{
	
	/**
	 * 
	 * @param hotelName
	 * @return 查找酒店信息
	 */
	public HotelInfoVO searchHotel(String hotelName) throws RemoteException;
	

	/**
	 * 
	 * @param location
	 * @param BD
	 * @param RoomConditionVO
	 * @param star
	 * @param judgeScore
	 * @return 酒店符合列表
	 */
	public List<HotelInfoVO> viewHotelList(String location,String BD,RoomConditionVO condition,int star,int judgeScore) throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经预订酒店列表
	 */
	public List<HotelInfoVO> showReservedHotel(int userID) throws RemoteException;
}

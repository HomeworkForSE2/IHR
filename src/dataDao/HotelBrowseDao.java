package dataDao;

import java.util.List;

import po.HotelPO;

public interface HotelBrowseDao {
	
	/**
	 * 
	 * @param hotelName
	 * @return 酒店信息
	 */
	public HotelPO searchHotel(String hotelName);
	
	/**
	 * 
	 * @param location
	 * @param BD
	 * @return 符合条件酒店列表
	 */
	public List<HotelPO> searchHotelList(String location,String BD);
	
	/**
	 * 
	 * @param userID
	 * @return 用户未评价酒店列表
	 */
	public List<HotelPO> findNotJudgedHotel(int userID);//先去订单里找到预订过的所有酒店，再与评价里已经评价过的酒店对比
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经预订过的酒店列表
	 */
	public List<HotelPO> findResHotel(int userID);

}

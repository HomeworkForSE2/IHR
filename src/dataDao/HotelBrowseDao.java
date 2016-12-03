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

}

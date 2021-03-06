package dataDao;

import po.HotelPO;

public interface HotelDao {
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelPO findHotel(int hotelID);
	
	/**
	 * 
	 * @param hotel
	 * @return 是否更新酒店信息成功
	 */
	public boolean updateHotel(HotelPO hotel);
	
	

}

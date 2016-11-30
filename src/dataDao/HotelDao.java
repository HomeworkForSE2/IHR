package dataDao;

import po.HotelPO;

public interface HotelDao {
	
	/**
	 * 
	 * @param hotel
	 * @return 是否更新酒店信息成功
	 */
	public boolean update(HotelPO hotel);

}

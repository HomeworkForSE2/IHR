package dataDao;

import po.HotelPO;
import po.HotelWorkerPO;

public interface HotelManageDao {
	
	/**
	 * 
	 * @param hotel
	 * @return 是否添加酒店成功
	 */
	public boolean addHotel(HotelPO hotel);
	
	/**
	 * 
	 * @param hotelID
	 * @param hotelWorker
	 * @return 是否添加酒店工作人员成功
	 */
	public boolean addHotelWorker(HotelWorkerPO hotelWorker);
	
	/**
	 * 
	 * @return
	 */
	public int getHotelNum();

}

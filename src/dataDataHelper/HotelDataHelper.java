package dataDataHelper;

import java.util.Map;

import po.HotelPO;


public interface HotelDataHelper {

	/**
	 * @return	从数据文件中读取酒店数据
	 */
	public Map<Integer, HotelPO> getHotelData();
	
	/**
	 * 向数据文件中写入酒店数据
	 * @param map
	 */
	public void updateHotelData(Map<Integer, HotelPO> map);
}

package service;

import vo.HotelInfoVO;

public interface HotelInfoService {
	
	/**
	 * 
	 * @param hotel
	 * @return 是否维护酒店信息成功
	 */
	public boolean maintainHotelInfo(HotelInfoVO hotel);

}

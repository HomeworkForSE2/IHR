package service;

import java.rmi.Remote;

import vo.HotelInfoVO;

public interface HotelInfoService extends Remote{
	
	/**
	 * 
	 * @param hotel
	 * @return 是否维护酒店信息成功
	 */
	public boolean maintainHotelInfo(HotelInfoVO hotel);

}

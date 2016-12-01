package service;

import java.rmi.Remote;

import vo.HotelInfoVO;
import vo.UserInfoVO;

public interface HotelManageService extends Remote{
	
	/**
	 * 
	 * @param hotel
	 * @return 是否添加酒店成功
	 */
	public boolean addHotel(HotelInfoVO hotel);
	
	/**
	 * 
	 * @param vo
	 * @return 是否添加酒店工作人员成功
	 */
	public boolean addHotelworker(UserInfoVO vo);

}

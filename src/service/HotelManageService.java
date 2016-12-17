package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelInfoVO;
import vo.UserInfoVO;

public interface HotelManageService extends Remote{
	
	/**
	 * 
	 * @param hotel
	 * @return 是否添加酒店成功
	 */
	public boolean addHotel(HotelInfoVO hotel)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 是否添加酒店工作人员成功
	 */
	public boolean addHotelworker(UserInfoVO vo)throws RemoteException;

}

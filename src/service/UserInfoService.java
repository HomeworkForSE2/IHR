package service;

import java.rmi.Remote;
import java.util.List;

import dataDao.UserDao;
import vo.HotelInfoVO;
import vo.UserInfoVO;

public interface UserInfoService extends Remote{

	/**
	 * 
	 * @param userID
	 * @return 用户基本信息
	 */
	public UserInfoVO showUserInfo(int userID);
		
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经预订酒店列表
	 */
	public List<HotelInfoVO> showReservedHotel(int userID);
	
	/**
	 * 
	 * @param userInfo
	 * @return 是否修改用户信息成功
	 */
	public boolean modifyUserInfo(UserInfoVO userInfo);
	

}

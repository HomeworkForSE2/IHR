package serviceImpl;

import java.util.List;

import dataDao.HotelBrowseDao;
import dataDao.UserDao;
import dataDaoImpl.HotelDaoImpl;
import dataDaoImpl.UserDaoImpl;
import po.UserPO;
import service.UserInfoService;
import vo.HotelInfoVO;
import vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService{

	private UserDao userDao;
	
	private HotelBrowseDao hotelBrowseDao;
	
	public UserInfoServiceImpl(){
		userDao=UserDaoImpl.getInstance();
		hotelBrowseDao=HotelDaoImpl.getInstance();
	}
	
	@Override
	public UserInfoVO showUserInfo(int userID) {
		// TODO Auto-generated method stub
		UserPO user=userDao.findUser(userID);
		return new UserInfoVO(user);
	}

	@Override
	public List<HotelInfoVO> showReservedHotel(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyUserInfo(UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		int userID=userInfo.getUserID();
		UserPO user=userDao.findUser(userID);
		user.setUserName(userInfo.getUserName());
		user.setPassword(userInfo.getPassword());
		user.setPhoneNumber(userInfo.getPhoneNumber());	
		return userDao.updateUser(user);
	}

}

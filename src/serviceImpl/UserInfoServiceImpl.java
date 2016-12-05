package serviceImpl;

import dataDao.UserDao;
import dataDaoImpl.UserDaoImpl;
import po.UserPO;
import service.UserInfoService;
import vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService{

	private UserDao userDao;
	
	public UserInfoServiceImpl(){
		userDao=UserDaoImpl.getInstance();
	}
	
	@Override
	public UserInfoVO showUserInfo(int userID) {
		// TODO Auto-generated method stub
		UserPO user=userDao.findUser(userID);
		return new UserInfoVO(user);
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

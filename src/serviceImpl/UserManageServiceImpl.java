package serviceImpl;

import dataDao.UserDao;
import dataDao.UserManageDao;
import dataDaoImpl.UserDaoImpl;
import po.UserPO;
import po.WebsiteWorkerPO;
import service.UserManageService;
import vo.UserInfoVO;

public class UserManageServiceImpl implements UserManageService{

	private UserManageDao userManageDao;
	
	private int websiteWorkerNum;
	
	public UserManageServiceImpl(){
		userManageDao=UserDaoImpl.getInstance();
		websiteWorkerNum=userManageDao.getWebsiteWorkerNum()+1;
	}
	
	@Override
	public UserInfoVO showUserInfo(String userName) {
		// TODO Auto-generated method stub
		UserPO user=userManageDao.searchAllUser(userName);
		return new UserInfoVO(user);
	}

	@Override
	public boolean modifyUserInfo(UserInfoVO vo) {
		// TODO Auto-generated method stub
		String userName=vo.getUserName();
		UserPO user=userManageDao.searchAllUser(userName);
		user.setUserName(vo.getUserName());
		user.setPassword(vo.getPassword());
		user.setPhoneNumber(vo.getPhoneNumber());
		user.setCredit(vo.getCredit());
		return userManageDao.updateAllUser(user);
	}

	@Override
	public boolean addWebsiteWorker(UserInfoVO vo) {
		// TODO Auto-generated method stub
		WebsiteWorkerPO websiteWorker=new WebsiteWorkerPO(websiteWorkerNum, vo.getUserName(), vo.getPassword(), vo.getPassword(), 0);	
		return userManageDao.addWebsiteWorker(websiteWorker);
	}

}

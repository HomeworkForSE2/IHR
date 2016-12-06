package serviceImpl;

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
	
	//dao层查找返回的null值，service层要对其进行处理
	@Override
	public UserInfoVO showUserInfo(String userName) {
		// TODO Auto-generated method stub
		UserPO user=userManageDao.searchAllUser(userName);
		if(user==null){
			return null;
		}
		return new UserInfoVO(user);
	}
	//不能把null传给dao层，管理员不能修改用户名，否则用户无法登陆
	@Override
	public boolean modifyUserInfo(UserInfoVO vo) {
		// TODO Auto-generated method stub
		String userName=vo.getUserName();
		UserPO user=userManageDao.searchAllUser(userName);
		if(user==null){
			return false;
		}
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
		boolean result=userManageDao.addWebsiteWorker(websiteWorker);
		if(result){
			websiteWorkerNum++;
		}
		return result;
	}

}

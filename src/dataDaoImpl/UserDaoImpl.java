package dataDaoImpl;

import java.util.Map;

import dataDao.LoginDao;
import dataDao.UserDao;
import dataDao.UserManageDao;
import dataDataHelper.DataFactory;
import dataDataHelper.UserDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.UserPO;
import po.WebsiteWorkerPO;

public class UserDaoImpl implements UserDao ,LoginDao,UserManageDao{

	private Map<Integer,UserPO> map;
	
	private UserDataHelper userDataHelper;
	
	private DataFactory dataFactory;

	private static UserDaoImpl userDataServiceImpl;
	
	private static UserDaoImpl getInstance(){
		if(userDataServiceImpl==null){
			userDataServiceImpl=new UserDaoImpl();
		}
		return userDataServiceImpl;
	}
	
	public UserDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			userDataHelper=dataFactory.getUserDataHelper();
			map=userDataHelper.getUserData();
		}
	}
	
	@Override
	public UserPO find(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserPO searchUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWebsiteWorker(WebsiteWorkerPO websiteWorker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

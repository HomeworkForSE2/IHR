package dataDaoImpl;

import java.util.Iterator;
import java.util.Map;

import dataDao.LoginDao;
import dataDao.UserDao;
import dataDao.UserManageDao;
import dataDataHelper.DataFactory;
import dataDataHelper.UserDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.HotelWorkerPO;
import po.UserPO;
import po.WebsiteAdminPO;
import po.WebsiteWorkerPO;

public class UserDaoImpl implements UserDao ,LoginDao,UserManageDao{

	private Map<Integer,UserPO> map;
	
	private WebsiteAdminPO admin;
	
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
			admin=userDataHelper.getWebsiteAdminData();
		}
	}
	
	/*
	 * 按ID查找方法是根据与ID相同的key获得map中的value
	 */
	@Override
	public UserPO findUser(int userID) {
		// TODO Auto-generated method stub
		return map.get(userID);
	}

	/*
	 *更新方法也是先用ID去查，找到的话再put更新，map的put方法会把有相同key的键值对覆盖
	 */
	@Override
	public boolean updateUser(UserPO user) {
		// TODO Auto-generated method stub
		int userID=user.getUserID();
		if(map.get(userID)!=null){
			map.put(userID, user);
			userDataHelper.updateUserData(map);
			return true;
		}
		
		return false;
	}

	/*
	 * 按名字查是对map的entryset进行遍历，方法同txtHelper写入
	 */
	@Override
	public UserPO searchAllUser(String userName) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,UserPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,UserPO> entry=it.next();
			UserPO user=entry.getValue();
			if(user.getUserName().equals(userName)){
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean addWebsiteWorker(WebsiteWorkerPO websiteWorker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String userName, String password) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,UserPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,UserPO> entry=it.next();
			UserPO user=entry.getValue();
			if(user.getUserName().equals(userName)){
				if(user.getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateAllUser(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

}

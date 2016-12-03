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
	
	public static UserDaoImpl getInstance(){
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
	 * 用户查询基本信息，按ID查找方法是根据与ID相同的key获得map中的value
	 */
	@Override
	public UserPO findUser(int userID) {
		// TODO Auto-generated method stub
		return map.get(userID);
	}

	/*
	 * 用户更新，更新方法也是先用ID去查，找到的话再put更新，map的put方法会把有相同key的键值对覆盖
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
	 * 查询用户信息，按名字查是对map的entryset进行遍历，方法同txtHelper写入
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

	/*
	 * 添加网站营销人员，按名字查为空，则加入map并写入(注意所有的add方法均已查不到名字为前提条件，不是ID)
	 */
	@Override
	public boolean addWebsiteWorker(UserPO websiteWorker) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,UserPO>> it=map.entrySet().iterator();
		String userName=websiteWorker.getUserName();
		while(it.hasNext()){
			Map.Entry<Integer,UserPO> entry=it.next();
			UserPO userHelp=entry.getValue();
			if(userHelp.getUserName().equals(userName)){
				return false;
			}
		}
		map.put(websiteWorker.getUserID(), websiteWorker);
		userDataHelper.updateUserData(map);
		return true;
	}
	
	/*
	 * 更新用户信息，有区别！！（还未改）
	 */
	@Override
	public boolean updateAllUser(UserPO user) {
		// TODO Auto-generated method stub
		return updateUser(user);
	}

	/*
	 * 登陆匹配
	 */
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

	
	public static void main(String[] args) {
		UserDaoImpl go=new UserDaoImpl();
		go.test();	
	}
	
	public void test(){
		
	}
	
	

}

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
	 * 用户登陆匹配
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

	/*
	 * 管理员登陆匹配
	 */
	@Override
	public boolean checkAdmin(String password) {
		// TODO Auto-generated method stub
		if(password.equals(admin.getAdminPassword())){
			return true;
		}
		return false;
	}
	
	/*
	 * 管理员修改密码
	 */
	@Override
	public boolean updateAdmin(WebsiteAdminPO ad) {
		// TODO Auto-generated method stub
		if(ad.getAdminPassword().equals(admin.getAdminPassword())){
			return false;
		}
		admin=ad;
		userDataHelper.updateWebsiteAdmin(ad);
		return true;
	}
	
	/*
	 * 增加用户信用值
	 */
	@Override
	public boolean addUserCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		if(map.get(userID)!=null){
			map.get(userID).setCredit(map.get(userID).getCredit()+credit);
			userDataHelper.updateUserData(map);
			return true;
		}
		return false;
	}

	/*
	 *减少用户信用值 
	 */
	@Override
	public boolean reduceUserCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return addUserCredit(userID, -credit);
	}
	
	/*
	 * 
	 */
	@Override
	public int getWebsiteWorkerNum() {
		// TODO Auto-generated method stub
		int websiteWorkerNum=1000000;
		Iterator<Map.Entry<Integer, UserPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			UserPO user=it.next().getValue();
			int userID=user.getUserID();
			if(userID>=1000000&&userID>websiteWorkerNum){
				websiteWorkerNum=userID;
			}
		}
		return websiteWorkerNum;
	}

	/*
	 * 酒店ID从1开始，web为0,酒店工作人员ID从1开始保持和酒店一致，普通用户从10000开始，网站营销人员从1000000开始
	 */
	@Override
	public int getUserNum() {
		// TODO Auto-generated method stub
		int userNum=10000;
		Iterator<Map.Entry<Integer, UserPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			UserPO user=it.next().getValue();
			int userID=user.getUserID();
			if(10000<=userID&&userID<1000000&&userID>userNum){
				userNum=userID;
			}
		}
		return userNum;
	}
	
	public static void main(String[] args) {
		UserDaoImpl go=new UserDaoImpl();
		go.test4();
	}
	
	public void test1(){
		System.out.println(checkUser("宋吉哉", "aaaab"));
		System.out.println(checkUser("宋吉哉", "aaaaba"));
		System.out.println(checkUser("叶童", "wwwwww"));
		System.out.println(checkUser("叶童", "wwwwwwa"));
		System.out.println(checkUser("朱劲", "ajjjba"));
		System.out.println(checkUser("朱劲", "ajjjba1"));
		System.out.println(checkUser("单苏婉", "1111111"));
		System.out.println(checkUser("单苏婉", "1111111a"));
		
	}
	
	public void test2(){
		UserPO u1=new UserPO(1, "朱劲", "aa", "111", 4000);
		WebsiteWorkerPO w1=new WebsiteWorkerPO(900, "小王", "111", "00000", 9);
		HotelWorkerPO h1=new HotelWorkerPO(9887, "小李", "sss", "111", 30);
		System.out.println(addWebsiteWorker(u1));
		System.out.println(addWebsiteWorker(w1));
		System.out.println(addWebsiteWorker(h1));	
		System.out.println(updateUser(u1));
	}

	public void test3(){	
		System.out.println(checkAdmin(admin.getAdminPassword()));
		WebsiteAdminPO w=new WebsiteAdminPO("nswdw1ZJ...");
		System.out.println(updateAdmin(w));
		System.out.println(checkAdmin(w.getAdminPassword()));
	}
	
	public void test4(){
		addUserCredit(0,500);
		addUserCredit(0,500);
		reduceUserCredit(1, 30000);
		reduceUserCredit(0, 300);
		System.out.println(addUserCredit(7, 0));
		System.out.println(reduceUserCredit(7, 0));
	}

	

	
	
	

}

package dataDao;

import po.UserPO;
import po.WebsiteWorkerPO;

public interface UserManageDao {
	
	/**
	 * 
	 * @param userName
	 * @return 用户信息
	 */
	public UserPO searchAllUser(String userName);
	
	
	/**
	 * 
	 * @param user
	 * @return 是否更新用户信息成功
	 */
	public boolean updateAllUser(UserPO user);
	
	/**
	 * 
	 * @param websiteWorker
	 * @return 是否添加网站营销人员成功
	 */
	public boolean addWebsiteWorker(UserPO websiteWorker);

	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否添加信用成
	 */
	public boolean addUserCredit(int userID,int credit);
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否减少信用成功
	 */
	public boolean reduceUserCredit(int userID,int credit);
	
	/**
	 * 
	 * @return
	 */
	public int getWebsiteWorkerNum();
	
	/**
	 * 
	 * @return
	 */
	public int getUserNum();
}

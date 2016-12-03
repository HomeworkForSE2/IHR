package dataDao;

import po.UserPO;
import po.WebsiteAdminPO;

public interface UserDao {
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public UserPO findUser(int userID);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserPO user);
	
	/**
	 * 
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(WebsiteAdminPO admin);

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
}

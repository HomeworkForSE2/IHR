package dataDao;

import po.UserPO;
import po.WebsiteAdminPO;

public interface UserDao {
	
	/**
	 * 
	 * @param userID
	 * @return 查找用户信息
	 */
	public UserPO findUser(int userID);
	
	/**
	 * 
	 * @param user
	 * @return 更新用户信息
	 */
	public boolean updateUser(UserPO user);
	
	/**
	 * 
	 * @param admin
	 * @return 更新网站管理员信息
	 */
	public boolean updateAdmin(WebsiteAdminPO admin);

	
}

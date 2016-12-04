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

	
}

package dataDao;

import po.UserPO;

public interface UserDao {
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public UserPO find(int userID);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean update(UserPO user);

}

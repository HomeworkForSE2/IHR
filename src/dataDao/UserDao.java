package dataDao;

import po.UserPO;

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

}

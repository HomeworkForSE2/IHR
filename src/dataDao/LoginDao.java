package dataDao;

public interface LoginDao {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return 匹配
	 */
	public int checkUser(String userName,String password,int userType);
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkAdmin(String password);

}

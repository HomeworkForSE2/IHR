package dataDao;

public interface LoginDao {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return 匹配
	 */
	public boolean checkUser(String userName,String password);

}

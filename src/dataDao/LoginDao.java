package dataDao;

public interface LoginDao {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return 匹配用户名密码
	 */
	public int checkUser(String userName,String password,int userType);
	
	/**
	 * 
	 * @param password
	 * @return 网站管理员登陆是否成功
	 */
	public boolean checkAdmin(String password);

}

package service;

public interface LoginService {
	/**
	 *
	 * @param userName
	 * @param password
	 * @return 是否登陆成功
	 */
	public boolean login(String userName,String password);

}

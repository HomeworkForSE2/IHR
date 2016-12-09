package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginService extends Remote{
	/**
	 *
	 * @param userName
	 * @param password
	 * @return 是否登陆成功
	 */
	public boolean login(String userName,String password) throws RemoteException;
	
	/**
	 * 
	 * @param password
	 * @return 管理员是否登陆成功
	 */
	public boolean loginAdmin(String password) throws RemoteException;

}

package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.UserInfoVO;

public interface UserManageService extends Remote{
	
	/**
	 * 
	 * @param userName
	 * @return 用户信息
	 */
	public UserInfoVO showUserInfo(String userName)throws RemoteException;//好像和userInfo重复
	
	/**
	 * 
	 * @param vo
	 * @return 是否修改用户信息
	 */
	public boolean modifyUserInfo(UserInfoVO vo)throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 是否添加网站营销人员成功
	 */
	public boolean addWebsiteWorker(UserInfoVO vo)throws RemoteException;

}

package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import vo.UserInfoVO;

public interface UserInfoService extends Remote{

	/**
	 * 
	 * @param userID
	 * @return 用户基本信息
	 */
	public UserInfoVO showUserInfo(int userID)throws RemoteException;
		

	
	/**
	 * 
	 * @param userInfo
	 * @return 是否修改用户信息成功
	 */
	public boolean modifyUserInfo(UserInfoVO userInfo)throws RemoteException;
	

}

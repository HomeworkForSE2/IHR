package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.MemberVO;
import vo.UserInfoVO;

public interface MemberService extends Remote{
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @return 是否注册（初始化成功）
	 */
	public int initialize(UserInfoVO user,String birthday,String enterpriseName)throws RemoteException;

	/**
	 * 
	 * @param userName
	 * @param birthday
	 * @param enterpriseName
	 * @return 是否注册初始化会员成功
	 */
	public boolean member(int userID,String birthday,String enterpriseName)throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @return 返回用户对应会员信息
	 * @throws RemoteException
	 */
	public MemberVO getMember(int userID)throws RemoteException; 
	
	/**
	 * 
	 * @param userID
	 * @param birthday
	 * @param enterpriseName
	 * @return 更新会员信息 
	 */
	public boolean memberUpdate(int userID,String birthday,String enterpriseName)throws RemoteException;
	
}

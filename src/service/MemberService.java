package service;

import java.rmi.Remote;

import vo.UserInfoVO;

public interface MemberService extends Remote{
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @return 是否注册（初始化成功）
	 */
	public boolean initialize(UserInfoVO user);

	/**
	 * 
	 * @param userName
	 * @param birthday
	 * @param enterpriseName
	 * @return 是否注册初始化会员成功
	 */
	public boolean member(int userID,String birthday,String enterpriseName);
	
	/**
	 * 
	 * @param userID
	 * @param birthday
	 * @param enterpriseName
	 * @return 更新会员信息 
	 */
	public boolean memberUpdate(int userID,String birthday,String enterpriseName);
	
}

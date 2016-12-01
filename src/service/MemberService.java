package service;

import java.rmi.Remote;

public interface MemberService extends Remote{
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @return 是否注册（初始化成功）
	 */
	public boolean initialize(String userName,String password,String phoneNumber);

	/**
	 * 
	 * @param userName
	 * @param birthday
	 * @return 是否注册普通会员成功
	 */
	public boolean normalMember(String userName,String birthday);
	
	/**
	 * 
	 * @param userName
	 * @param enterpriseName
	 * @return 是否注册企业会员成功
	 */
	public boolean enterpriseMember(String userName,String enterpriseName);
}

package dataDao;

import po.MemberPO;
import po.UserPO;

public interface MemberDao {
	
	/**
	 * 
	 * @param member
	 * @return 插入会员信息
	 */
	public boolean insert(MemberPO member);
	
	/**
	 * 
	 * @param member
	 * @return 更新会员信息
	 */
	public boolean update(MemberPO member);
	
	/**
	 * 
	 * @param user
	 * @return 插入新用户信息
	 */
	public boolean insert(UserPO user);
	
	/**
	 * 
	 * @param UserID
	 * @return 企业会员企业名
	 */
	public String findEnterprise(int UserID);
	
	/**
	 * 
	 * @param UserID
	 * @return 普通会员生日
	 */
	public String findBirthday(int UserID);
}

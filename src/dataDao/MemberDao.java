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

	public String findBirthday(int UserID);
	public String findEnterprise(int UserID);
	
}

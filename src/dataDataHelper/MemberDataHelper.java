package dataDataHelper;

import java.util.Map;

import po.MemberPO;

public interface MemberDataHelper {

	/**
	 * @return	从数据文件中读取会员数据
	 */
	public Map<Integer, MemberPO> getMemberData();
	
	/**
	 * 向数据文件中写入会员数据
	 * @param map
	 */
	public void updateMemberData(Map<Integer, MemberPO> map);
}

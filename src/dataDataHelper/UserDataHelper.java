package dataDataHelper;

import java.util.Map;

import po.UserPO;

public interface UserDataHelper {
	
	/**
	 * 
	 * @return 从数据文件读入用户数据
	 */
	public Map<Integer,UserPO> getUserData();
	
	/**
	 * 向数据文件写入用户数据
	 * @param map
	 */
	public void updateUserData(Map<Integer,UserPO> map);

}

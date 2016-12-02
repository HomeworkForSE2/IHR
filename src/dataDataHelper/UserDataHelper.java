package dataDataHelper;

import java.util.Map;

import po.UserPO;
import po.WebsiteAdminPO;

public interface UserDataHelper {
	
	/**
	 * 
	 * @return 从数据文件读入用户数据
	 */
	public Map<Integer,UserPO> getUserData();
	
	
	/**
	 * 
	 * @return 从数据文件读入网站管理员数据
	 */
	public WebsiteAdminPO getWebsiteAdminData();
	
	
	/**
	 * 向数据文件写入用户数据
	 * @param map
	 */
	public void updateUserData(Map<Integer,UserPO> map);

	
	/**
	 * 向数据文件写入管理员数据
	 * @param admin
	 */
	public void updateWebsiteAdmin(WebsiteAdminPO admin);

}

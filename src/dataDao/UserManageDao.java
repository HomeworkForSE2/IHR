package dataDao;

import po.UserPO;
import po.WebsiteWorkerPO;

public interface UserManageDao {
	
	/**
	 * 
	 * @param userName
	 * @return 用户信息
	 */
	public UserPO searchAllUser(String userName);
	
	
	/**
	 * 
	 * @param user
	 * @return 是否更新用户信息成功
	 */
	public boolean updateAllUser(UserPO user);
	
	/**
	 * 
	 * @param websiteWorker
	 * @return 是否添加网站营销人员成功
	 */
	public boolean addWebsiteWorker(WebsiteWorkerPO websiteWorker);

}

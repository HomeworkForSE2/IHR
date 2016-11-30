package service;

import vo.UserInfoVO;

public interface UserManageService {
	
	/**
	 * 
	 * @param userName
	 * @return 用户信息
	 */
	public UserInfoVO showUserInfo(String userName);//好像和userInfo重复
	
	/**
	 * 
	 * @param vo
	 * @return 是否修改用户信息
	 */
	public boolean modifyUserInfo(UserInfoVO vo);
	
	/**
	 * 
	 * @param vo
	 * @return 是否添加网站营销人员成功
	 */
	public boolean addWebsiteWorker(UserInfoVO vo);

}

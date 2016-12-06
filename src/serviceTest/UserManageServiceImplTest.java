package serviceTest;

/*
 * 已经测试完成
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.UserManageServiceImpl;
import vo.UserInfoVO;

public class UserManageServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShowUserInfo() {
		UserManageServiceImpl test=new UserManageServiceImpl();
		assertEquals(test.showUserInfo("朱劲").getUserID(),10001);
		assertEquals(test.showUserInfo("叶童").getUserID(),10002);
		assertEquals(test.showUserInfo("宋吉哉").getUserID(),10003);
		assertEquals(test.showUserInfo("单苏婉").getUserID(),10004);	
		assertEquals(test.showUserInfo("刘钦"),null);
		
		
	}

	@Test
	public void testModifyUserInfo() {
		UserManageServiceImpl test=new UserManageServiceImpl();
		UserInfoVO user0=new UserInfoVO(0, "朱劲", "abc", "aaa", 11000);
		UserInfoVO user1=new UserInfoVO(0, "刘钦", "abc", "aaa", 11000);
		UserInfoVO user2=new UserInfoVO(0, "王浩然", "abc", "aaa", 11000);
		boolean a=test.modifyUserInfo(user0);
		boolean b=test.modifyUserInfo(user1);
		boolean c=test.modifyUserInfo(user2);
		assertEquals(a, true);
		assertEquals(b, true);
		assertEquals(c, false);
	}

	@Test
	public void testAddWebsiteWorker() {
		UserManageServiceImpl test=new UserManageServiceImpl();
		UserInfoVO websiteWorker0=new UserInfoVO(0, "刘钦", "aaaaa", "10086", 0);
		UserInfoVO websiteWorker1=new UserInfoVO(0, "刘钦", "aaaaa", "10086", 0);
		UserInfoVO websiteWorker2=new UserInfoVO(0, "丁二玉", "bbbbb", "10087", 0);
		UserInfoVO websiteWorker3=new UserInfoVO(0, "邵栋", "ccccc", "10088", 0);
		assertEquals(test.addWebsiteWorker(websiteWorker0), true);
		assertEquals(test.addWebsiteWorker(websiteWorker1), false);
		assertEquals(test.addWebsiteWorker(websiteWorker2), true);
		assertEquals(test.addWebsiteWorker(websiteWorker3), true);
		
	}

}

package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import serviceImpl.MemberServiceImpl;
import vo.UserInfoVO;

public class MemberServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInitialize() {
		UserInfoVO user0=new UserInfoVO(0, "朱劲", "nswdw1ZJ...", "18761056733", 1);
		UserInfoVO user1=new UserInfoVO(0, "叶童", "nswdw1YT...", "1", 1);
		UserInfoVO user2=new UserInfoVO(0, "宋吉哉", "nswdw1SJZ...", "1", 1);
		UserInfoVO user3=new UserInfoVO(0, "单苏婉", "nswdw1SSW...", "1", 1);
		MemberServiceImpl test=new MemberServiceImpl();
		test.initialize(user0);	
		test.initialize(user1);	
		test.initialize(user2);	
		test.initialize(user3);	
	}

	@Test
	public void testMember() {
		MemberServiceImpl test=new MemberServiceImpl();
		test.member(10001, "19970418", "华为");
		test.member(10002, "19970419", "百度");
		test.member(10003, "19970420", "阿里巴巴");
		test.member(10004, "19970421", "腾讯");
	}

	@Test
	public void testMemberUpdate() {
		MemberServiceImpl test=new MemberServiceImpl();
		test.memberUpdate(10001, "19970418", "华为");
		test.memberUpdate(10002, "19970418", "华为");
		test.memberUpdate(10003, "19970418", "华为");
		test.memberUpdate(10004, "19970418", "华为");
	}

}

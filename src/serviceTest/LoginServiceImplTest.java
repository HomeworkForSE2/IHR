package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.LoginServiceImpl;

/*
 * 已测试完成
 */
public class LoginServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLogin() {
		LoginServiceImpl test=new LoginServiceImpl();
		boolean a=test.login("朱劲", "nswdw1ZJ...");
		boolean b=test.login("叶童", "nswdw1YT...");
		boolean c=test.login("单苏婉", "nswdw1SSW...");
		boolean d=test.login("宋吉哉", "nswdw1SJZ...");
		boolean e=test.login("朱劲", "nswdw1SJZ...");
		boolean f=test.login("叶童", "nswdw1SJZ...");
		boolean g=test.login("单苏婉", "nswdw1SJZ...");
		boolean h=test.login("宋吉哉", "nswdw1SJ...");
//		System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h);
		assertEquals(true, a);
		assertEquals(true, b);
		assertEquals(true, c);
		assertEquals(true, d);
		assertEquals(false, e);
		assertEquals(false, f);
		assertEquals(false, g);
		assertEquals(false, h);	
	}

	@Test
	public void testLoginAdmin() {
		LoginServiceImpl test=new LoginServiceImpl();
		boolean a=test.loginAdmin("admin");
		boolean b=test.loginAdmin("zhujing");
//		System.out.println(a+" "+b);
		assertEquals(true, a);
		assertEquals(false, b);
	
	}

}

package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.OrderByUserServiceImpl;

public class OrderByUserServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl();
		test0.initUser(1);
		test1.initUser(2);
		test2.initUser(3);
		assertEquals(test0.getAllUserOrder().size(), 5);
		assertEquals(test1.getAllUserOrder().size(), 3);
		assertEquals(test2.getAllUserOrder().size(), 2);
	}

	@Test
	public void testGetNotExecuteOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl();
		test0.initUser(1);
		test1.initUser(2);
		test2.initUser(3);
		assertEquals(test0.getUserNotExecuteOrder().size(), 1);
		assertEquals(test1.getUserNotExecuteOrder().size(), 2);
		assertEquals(test2.getUserNotExecuteOrder().size(), 0);
	}

	@Test
	public void testGetExecuteOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl();
		test0.initUser(1);
		test1.initUser(2);
		test2.initUser(3);
		assertEquals(test0.getUserExecuteOrder().size(), 3);
		assertEquals(test1.getUserExecuteOrder().size(), 1);
		assertEquals(test2.getUserExecuteOrder().size(), 1);
	}

	@Test
	public void testGetUnusualOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl();
		test0.initUser(1);
		test1.initUser(2);
		test2.initUser(3);
		assertEquals(test0.getUserUnusualOrder().size(), 0);
		assertEquals(test1.getUserUnusualOrder().size(), 1);
		assertEquals(test2.getUserUnusualOrder().size(), 1);
	}

	@Test
	public void testGetCancelOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl();
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl();
		test0.initUser(1);
		test1.initUser(2);
		test2.initUser(3);
		assertEquals(test0.getUserCancelOrder().size(), 1);
		assertEquals(test1.getUserCancelOrder().size(), 0);
		assertEquals(test2.getUserCancelOrder().size(), 1);
		
	}

	//不必测，很完美
	@Test
	public void testFilter() {
		fail("Not yet implemented");
	}

	//核心未测
	@Test
	public void testCreateOrder() {
		fail("Not yet implemented");
	}

	//初测成功
	@Test
	public void testCancelOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl();
		test0.cancelOrder(1);
	}

}

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
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl(2);
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl(3);
		assertEquals(test0.getAllOrder().size(), 5);
		assertEquals(test1.getAllOrder().size(), 3);
		assertEquals(test2.getAllOrder().size(), 2);
	}

	@Test
	public void testGetNotExecuteOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl(2);
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl(3);
		assertEquals(test0.getNotExecuteOrder().size(), 1);
		assertEquals(test1.getNotExecuteOrder().size(), 2);
		assertEquals(test2.getNotExecuteOrder().size(), 0);
	}

	@Test
	public void testGetExecuteOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl(2);
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl(3);
		assertEquals(test0.getExecuteOrder().size(), 3);
		assertEquals(test1.getExecuteOrder().size(), 1);
		assertEquals(test2.getExecuteOrder().size(), 1);
	}

	@Test
	public void testGetUnusualOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl(2);
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl(3);
		assertEquals(test0.getUnusualOrder().size(), 0);
		assertEquals(test1.getUnusualOrder().size(), 1);
		assertEquals(test2.getUnusualOrder().size(), 1);
	}

	@Test
	public void testGetCancelOrder() {
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		OrderByUserServiceImpl test1=new OrderByUserServiceImpl(2);
		OrderByUserServiceImpl test2=new OrderByUserServiceImpl(3);
		assertEquals(test0.getCancelOrder().size(), 1);
		assertEquals(test1.getCancelOrder().size(), 0);
		assertEquals(test2.getCancelOrder().size(), 1);
		
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
		OrderByUserServiceImpl test0=new OrderByUserServiceImpl(1);
		test0.cancelOrder(1);
	}

}

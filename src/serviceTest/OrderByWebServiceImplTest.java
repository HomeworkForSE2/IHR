package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.OrderByWebServiceImpl;

public class OrderByWebServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		assertEquals(test.getAllWebOrder().size(),10);
		
	}

	@Test
	public void testGetNotExecuteOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		assertEquals(test.getWebNotExecuteOrder().size(), 4);
	}

	@Test
	public void testGetExecuteOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		assertEquals(test.getWebExecuteOrder().size(), 2);
	}

	@Test
	public void testGetUnusualOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		assertEquals(test.getWebUnusualOrder().size(), 1);
	}

	@Test
	public void testGetCancelOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		assertEquals(test.getWebCancelOrder().size(), 3);
	}
	
	//初测成功
	@Test
	public void testCancelUnusualOrder() {
		OrderByWebServiceImpl test=new OrderByWebServiceImpl();
		test.cancelUnusualOrder(1, 0);
		test.cancelUnusualOrder(4, 1);
		test.cancelUnusualOrder(7, 0);
	}

}

package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.OrderByHotelServiceImpl;

public class OrderByHotelServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetAllOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		assertEquals(test0.getAllOrder().size(), 3);
		assertEquals(test1.getAllOrder().size(), 2);
		assertEquals(test2.getAllOrder().size(), 1);
		assertEquals(test3.getAllOrder().size(), 2);
		assertEquals(test4.getAllOrder().size(), 2);
	}

	@Test
	public void testGetNotExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		assertEquals(test0.getNotExecuteOrder().size(), 1);
		assertEquals(test1.getNotExecuteOrder().size(), 0 );
		assertEquals(test2.getNotExecuteOrder().size(), 1);
		assertEquals(test3.getNotExecuteOrder().size(), 0);
		assertEquals(test4.getNotExecuteOrder().size(), 0);
	}

	@Test
	public void testGetExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		assertEquals(test0.getExecuteOrder().size(), 0);
		assertEquals(test1.getExecuteOrder().size(), 2);
		assertEquals(test2.getExecuteOrder().size(), 0);
		assertEquals(test3.getExecuteOrder().size(), 0);
		assertEquals(test4.getExecuteOrder().size(), 0);
	}

	@Test
	public void testGetUnusualOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		assertEquals(test0.getUnusualOrder().size(), 1);
		assertEquals(test1.getUnusualOrder().size(), 0);
		assertEquals(test2.getUnusualOrder().size(), 0);
		assertEquals(test3.getUnusualOrder().size(), 2);
		assertEquals(test4.getUnusualOrder().size(), 0);
	}

	@Test
	public void testGetCancelOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		assertEquals(test0.getCancelOrder().size(), 1);
		assertEquals(test1.getCancelOrder().size(), 0);
		assertEquals(test2.getCancelOrder().size(), 0);
		assertEquals(test3.getCancelOrder().size(), 0);
		assertEquals(test4.getCancelOrder().size(), 2);
	}


	//初测成功
	@Test
	public void testExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		test0.executeOrder(1);
		test0.executeOrder(2);
		test0.executeOrder(3);
	}

	//初测成功
	@Test
	public void testFinishOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		test0.finishOrder(1);
		test0.finishOrder(2);
		test0.finishOrder(3);
	}

	//此方法还未完全实现，未测
	@Test
	public void testSetNotExecuteToUnusual() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
	}

	//初测成功
	@Test
	public void testSetUnusualToExecute() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl(1);
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl(2);
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl(3);
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl(4);
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl(5);
		test0.setUnusualToExecute(1);
		test0.setUnusualToExecute(7);
		test1.setUnusualToExecute(2);
		test3.setUnusualToExecute(4);
		test3.setUnusualToExecute(9);
	}

}

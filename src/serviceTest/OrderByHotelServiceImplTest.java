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
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		assertEquals(test0.getAllHotelOrder().size(), 3);
		assertEquals(test1.getAllHotelOrder().size(), 2);
		assertEquals(test2.getAllHotelOrder().size(), 1);
		assertEquals(test3.getAllHotelOrder().size(), 2);
		assertEquals(test4.getAllHotelOrder().size(), 2);
	}

	@Test
	public void testGetNotExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		assertEquals(test0.getHotelNotExecuteOrder().size(), 1);
		assertEquals(test1.getHotelNotExecuteOrder().size(), 0 );
		assertEquals(test2.getHotelNotExecuteOrder().size(), 1);
		assertEquals(test3.getHotelNotExecuteOrder().size(), 0);
		assertEquals(test4.getHotelNotExecuteOrder().size(), 0);
	}

	@Test
	public void testGetExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		assertEquals(test0.getHotelExecuteOrder().size(), 0);
		assertEquals(test1.getHotelExecuteOrder().size(), 2);
		assertEquals(test2.getHotelExecuteOrder().size(), 0);
		assertEquals(test3.getHotelExecuteOrder().size(), 0);
		assertEquals(test4.getHotelExecuteOrder().size(), 0);
	}

	@Test
	public void testGetUnusualOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		assertEquals(test0.getHotelUnusualOrder().size(), 1);
		assertEquals(test1.getHotelUnusualOrder().size(), 0);
		assertEquals(test2.getHotelUnusualOrder().size(), 0);
		assertEquals(test3.getHotelUnusualOrder().size(), 2);
		assertEquals(test4.getHotelUnusualOrder().size(), 0);
	}

	@Test
	public void testGetCancelOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		assertEquals(test0.getHotelCancelOrder().size(), 1);
		assertEquals(test1.getHotelCancelOrder().size(), 0);
		assertEquals(test2.getHotelCancelOrder().size(), 0);
		assertEquals(test3.getHotelCancelOrder().size(), 0);
		assertEquals(test4.getHotelCancelOrder().size(), 2);
	}


	//初测成功
	@Test
	public void testExecuteOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test0.executeOrder(1);
		test0.executeOrder(2);
		test0.executeOrder(3);
	}

	//初测成功
	@Test
	public void testFinishOrder() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test0.finishOrder(1);
		test0.finishOrder(2);
		test0.finishOrder(3);
	}

	//此方法还未完全实现，未测
	@Test
	public void testSetNotExecuteToUnusual() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
	}

	//初测成功
	@Test
	public void testSetUnusualToExecute() {
		OrderByHotelServiceImpl test0=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test1=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test2=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test3=new OrderByHotelServiceImpl();
		OrderByHotelServiceImpl test4=new OrderByHotelServiceImpl();
		test0.initHotel(1);
		test1.initHotel(2);
		test2.initHotel(3);
		test3.initHotel(4);
		test4.initHotel(5);
		test0.setUnusualToExecute(1);
		test0.setUnusualToExecute(7);
		test1.setUnusualToExecute(2);
		test3.setUnusualToExecute(4);
		test3.setUnusualToExecute(9);
	}

}

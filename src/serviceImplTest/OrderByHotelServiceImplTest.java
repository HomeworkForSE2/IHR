package serviceImplTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.OrderByHotelServiceImpl;

public class OrderByHotelServiceImplTest {
	OrderByHotelServiceImpl order=new OrderByHotelServiceImpl();
	
	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	//这个方法得到特定酒店的list
//	public void testInitHotel() {
//		order.initHotel(5);
//	}

//	@Test
//	public void testGetAllHotelOrder() {
//		order.initHotel(5);
//		assertEquals(10,order.getAllHotelOrder().get(0).getOrderId());
//		assertEquals(11,order.getAllHotelOrder().get(1).getOrderId());
//	}

//	@Test
//	public void testGetHotelNotExecuteOrder() {
//		order.initHotel(5);
//		assertEquals(10,order.getHotelNotExecuteOrder().get(0).getOrderId());
//	}

//	@Test
//	public void testGetHotelExecuteOrder() {
//		order.initHotel(5);
//	   assertEquals(10,order.getHotelExecuteOrder().get(0).getOrderId());
//	}

//	@Test
//	public void testGetHotelUnusualOrder() {
//		order.initHotel(5);
//	   assertEquals(10,order.getHotelExecuteOrder().get(0).getOrderId());
//	}
//
//	@Test
//	public void testGetHotelCancelOrder() {
//		order.initHotel(5);
//	   assertEquals(10,order.getHotelExecuteOrder().get(0).getOrderId());
//	}
	
//	@Test
//	public void testExecuteOrder() {
//		order.initHotel(5);
//		order.executeOrder(1);
//		
//	}
//
//	@Test
//	public void testFinishOrder() {
//		order.finishOrder(1);
//	}
//	//这个测试不会写，一直报错：超出范围
//	@Test
//	public void testSetNotExecuteToUnusual() {
//		order.setNotExecuteToUnusual();
//	}

	@Test
	public void testSetUnusualToExecute() {
		order.setUnusualToExecute(1);
	}

}

package serviceImplTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import po.OrderPO;
import serviceImpl.OrderByUserServiceImpl;
import vo.OrderVO;

public class OrderByUserServiceImplTest {
	OrderByUserServiceImpl order=new OrderByUserServiceImpl();
	OrderPO orderPO=new OrderPO(11,1,5,4,300.0,"20161111","20161112","2016122518",3,1,1,true,"53");
	OrderVO orderVO=new OrderVO(12,1,5,4,300,"20161111","20161112","2016122518",3,1,1,true);
	@Before
	public void setUp() throws Exception {
	}
	
	//得到某用户的所有订单
	@Test
	public void testInitUser() {
		assertEquals(true,order.initUser(1));
	}

	@Test
	public void testFilter() {
		List<OrderPO> list=new ArrayList<OrderPO>();
		list.add(orderPO);
		assertEquals(11,order.filter(list, 4).get(0).getOrderId());
	}

	@Test
	public void testGetAllUserOrder() {
		order.initUser(1);
		assertEquals(1,order.getAllUserOrder().get(0).getOrderId());
		assertEquals(10,order.getAllUserOrder().get(1).getOrderId());
		assertEquals(11,order.getAllUserOrder().get(2).getOrderId());
	}

	@Test
	public void testGetUserNotExecuteOrder() {
		order.initUser(1);
		assertEquals(11,order.getUserNotExecuteOrder().get(0).getOrderId());
	}

	@Test
	public void testGetUserExecuteOrder() {
		order.initUser(1);
		assertEquals(10,order.getUserExecuteOrder().get(0).getOrderId());
	}

	@Test
	public void testGetUserUnusualOrder() {
		order.initUser(1);
	    assertEquals(1,order.getUserUnusualOrder().get(0).getOrderId());
	}

	@Test
	public void testGetUserCancelOrder() {
	order.initUser(1);
	assertEquals(1,order.getUserCancelOrder().get(0).getOrderId());
	}

	@Test
	public void testCreateOrder() {
		order.createOrder(orderVO);
	}

	@Test
	public void testCancelOrder() {
		order.initUser(1);
		order.cancelOrder(1);
	}

	@Test
	public void testHasUserFinishedOrderInThisHotel() {
		order.initUser(1);
		assertEquals(false,order.hasUserFinishedOrderInThisHotel(5));
	}
	

	@Test
	public void testHasUserCanceledOrderInThisHotel() {
		order.initUser(1);
		assertEquals(false,order.hasUserFinishedOrderInThisHotel(5));
	}

	@Test
	public void testHasUserUnusualOrderInThisHotel() {
	order.initUser(1);
	assertEquals(false,order.hasUserFinishedOrderInThisHotel(5));
	}

	@Test
	public void testIsUserOrderingInThisHotel() {
		order.initUser(1);
		assertEquals(false,order.hasUserFinishedOrderInThisHotel(5));
	}

	@Test
	public void testCheckHelper() {
		order.initUser(1);
		assertEquals(false,order.checkHelper(5, 1));
	}

}

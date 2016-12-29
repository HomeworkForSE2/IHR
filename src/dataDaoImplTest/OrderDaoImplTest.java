package dataDaoImplTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;

public class OrderDaoImplTest {
	OrderDaoImpl orderDao=new OrderDaoImpl();
	OrderPO orderPO=new OrderPO(9,3,4,3,300.0,"20161111","20161112","2016120817",3,1,1,false,"43");
	OrderPO orderPO2=new OrderPO(10,4,5,4,300.0,"20161111","20161112","20161113",3,1,1,false,"53");
	OrderPO orderPO3=new OrderPO(11,6,5,4,300.0,"20161111","20161112","20161113",3,1,1,false,"53");
	OrderPO orderPO4=new OrderPO(11,2,5,4,300.0,"20161111","20161112","20161113",3,1,1,true,"53");
	OrderPO orderPO5=new OrderPO(6,2,1,2,400.0,"20161111","20161112","20161113",2,2,1,false,"11,12");
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testAddOrder() {
		orderDao.addOrder(orderPO);
		orderDao.addOrder(orderPO2);
		orderDao.addOrder(orderPO3);
		orderDao.addOrder(orderPO5);
	}
	@Test
	public void testDeleteOrder() {
		orderDao.deleteOrder(6);
	}

	@Test
	public void testUpdateOrder() {
		orderDao.updateOrder(orderPO4);
	}
@Test
	public void testGetHotelOrderList() {
		List<OrderPO> temp=orderDao.getHotelOrderList(4);
		assertEquals(orderPO.getOrderID(),temp.get(0).getOrderID());
	}

	@Test
	public void testGetOrder() {
		assertEquals(orderPO2.getOrderID(),orderDao.getOrder(10).getOrderID());
	}
	
	@Test
	public void testResHotelIDList() {
		List<Integer> temp=orderDao.resHotelIDList(3);
		System.out.println(temp.get(0));
	}

	@Test
	public void testGetAllOrderList() {
		List<OrderPO> temp=orderDao.getAllOrderList();
		assertEquals(orderPO.getOrderID(),temp.get(0).getOrderID());
		assertEquals(orderPO2.getOrderID(),temp.get(1).getOrderID());
		assertEquals(orderPO4.getOrderID(),temp.get(2).getOrderID());
	}

	@Test
	public void testGetRoomIDByOrder() {
		System.out.println(orderDao.getRoomIDByOrder(11));
	}

	@Test
	public void testGetOrderNum() {
		assertEquals(3,orderDao.getOrderNum());
	}

}

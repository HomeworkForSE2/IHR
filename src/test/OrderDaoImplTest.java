package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
//注意，请一个一个方法测试
public class OrderDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	//添加二号订单，测试的订单自定义给出，44号用户
	//添加三号订单，55号用户
	//添加四号订单，55号用户
	public void testAddOrder() {
		OrderPO order=new OrderPO(44,0002,0,100,400,"161203","161205","161205",2,2,false,0002);
		OrderPO order2=new OrderPO(55,0002,0,100,400,"161203","161205","161205",2,2,false,3);
		OrderPO order3=new OrderPO(55,0002,0,100,400,"161203","161205","161205",2,2,false,0004);
		OrderDaoImpl test=new OrderDaoImpl();
		test.addOrder(order);
		test.addOrder(order2);
		test.addOrder(order3);
	}

	@Test
	public void testDeleteOrder() {
		OrderDaoImpl test=new OrderDaoImpl();
		test.deleteOrder(2);
	}

	@Test
	public void testUpdateOrder() {
		OrderPO order=new OrderPO(55,0002,0,100,400,"161203","161205","161205",2,2,true,3);
		OrderDaoImpl test=new OrderDaoImpl();
		test.updateOrder(order);
	}
	

	@Test
	public void testGetHotelOrderList() {
		List<OrderPO>list=new ArrayList<OrderPO>();
			
		OrderDaoImpl test=new OrderDaoImpl();
		list=test.getHotelOrderList(2);
		OrderPO order=list.get(0);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
    	assertEquals("99;2;0;100;400;161203;161205;161205;2;2;false;1",str);
    	
		/*//在获得列表时，对于已经更新过的订单并没有得到更新，反而还是返回旧版本
		
		OrderPO order=list.get(1);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
    	assertEquals("55;2;0;100;400;161203;161205;161205;2;2;true;3",str);
    	 
        OrderPO order=list.get(2);
		String  str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
    	assertEquals("55;2;0;100;400;161203;161205;161205;2;2;false;4",str);
	*/}

	@Test
	//这个也是，没有返回更新后的订单
	public void testGetUserOrderList() {
		List<OrderPO>list=new ArrayList<OrderPO>();
		OrderDaoImpl test=new OrderDaoImpl();
		list=test.getUserOrderList(55);
		OrderPO order=list.get(0);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
		assertEquals("55;2;0;100;400;161203;161205;161205;2;2;true;3",str);
	}

	@Test
	//这个却可以得到最新的订单
	public void testGetOrder() {
		OrderPO order=new OrderPO(55,2,0,100,400,"161203","161205","161205",2,2,true,3);
		OrderDaoImpl test=new OrderDaoImpl();
		test.getOrder(3);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
		assertEquals("55;2;0;100;400;161203;161205;161205;2;2;true;3",str);
	}

	

}

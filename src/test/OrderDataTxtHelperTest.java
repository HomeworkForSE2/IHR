package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dataDataHelperImpl.OrderDataTxtHelper;
import po.OrderPO;

public class OrderDataTxtHelperTest {

	@Before
	public void setUp() throws Exception {
	}
    @Test
    //99号客户的订单，订单号为1号
	public void testUpdateOrderData() {
    	OrderDataTxtHelper test=new OrderDataTxtHelper();
    	OrderPO order=new OrderPO(99,0002,0,100,400,"161203","161205","161205",2,2,false,0001);
    	Map<Integer,OrderPO> map=new HashMap<Integer,OrderPO>();
    	map.put(0001,order);
    	test.updateOrderData(map);
	}
	@Test
	public void testGetOrderData() {
		OrderDataTxtHelper test=new OrderDataTxtHelper();
		OrderPO order=test.getOrderData().get(0001);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
    	assertEquals("99;2;0;100;400;161203;161205;161205;2;2;false;1",str);
	}

	

}

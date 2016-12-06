package dataTest;

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
    //该测试方法没问题，但是好像第一次时由于没有更新导致str为null而失败，但是为什么第一次没有更新成功呢？？
    //故推荐注释一个测一个
	@Test
	public void testGetOrderData() {
		OrderDataTxtHelper test=new OrderDataTxtHelper();
		OrderPO order=test.getOrderData().get(1);
		String str=order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getCredit()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getOrderID();
		assertEquals("99;2;0;100;400;161203;161205;161205;2;2;false;1",str);
		}

	

}

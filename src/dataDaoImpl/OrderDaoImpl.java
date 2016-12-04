package dataDaoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import dataDao.OrderDao;
import dataDataHelper.DataFactory;
import dataDataHelper.OrderDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.OrderPO;
import po.UserPO;

public class OrderDaoImpl implements OrderDao{
	
	private Map<Integer,OrderPO> map;
	
	private OrderDataHelper orderDataHelper;
	
	private DataFactory dataFactory;

	private static OrderDaoImpl orderDataServiceImpl;
	
	public static OrderDaoImpl getInstance(){
		if(orderDataServiceImpl==null){
			orderDataServiceImpl=new OrderDaoImpl();
		}
		return orderDataServiceImpl;
	}
	
	public OrderDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			orderDataHelper=dataFactory.getOrderDataHelper();
			map=orderDataHelper.getOrderData();
		}
	}
	
	
	@Override
	public List<OrderPO> getHotelOrderList(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderPO>list=new ArrayList<OrderPO>();
		Iterator<Map.Entry<Integer,OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,OrderPO> entry=it.next();
			OrderPO order=entry.getValue();
			if(order.getHotelID()==hotelID){
				list.add(order);
			}
		}
		return list;
	}

	@Override
	public List<OrderPO> getUserOrderList(int userID) {
		// TODO Auto-generated method stub
		List<OrderPO>list=new ArrayList<OrderPO>();
		Iterator<Map.Entry<Integer,OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,OrderPO> entry=it.next();
			OrderPO order=entry.getValue();
			if(order.getUserID()==userID){
				list.add(order);
			}
		}
		return list;
	}

	@Override
	public OrderPO getOrder(int orderID) {
		// TODO Auto-generated method stub
		return map.get(orderID);
	}

	@Override
	public boolean addOrder(OrderPO order) {
		// TODO Auto-generated method stub
		
		int orderID=map.size();
		map.put(orderID,order);
		orderDataHelper.updateOrderData(map);
		return true;
	}

	@Override
	public boolean deleteOrder(int orderID) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,OrderPO> entry=it.next();
			OrderPO order=entry.getValue();
			if(order.getOrderID()==orderID){
				map.remove(orderID);
				orderDataHelper.updateOrderData(map);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateOrder(OrderPO order) {
		// TODO Auto-generated method stub
		int orderID=order.getOrderID();
		if(map.get(orderID)!=null){
			map.put(orderID, order);
			orderDataHelper.updateOrderData(map);
			return true;
		}
		
		return false;
	}

	@Override
	public List<Integer> resHotelIDList(int userID) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		Iterator<Map.Entry<Integer,OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,OrderPO> entry=it.next();
			OrderPO order=entry.getValue();
			if(order.getUserID()==userID){
				if(!list.contains(order.getHotelID())){
					list.add(order.getHotelID());
				}
			}			
		}	
		return list;
	}
	
	public static void main(String[] args) {
		OrderDaoImpl go=new OrderDaoImpl();
		go.test();
	}
	
	public void test(){
		System.out.println(resHotelIDList(0));
		System.out.println(resHotelIDList(1));
		System.out.println(resHotelIDList(2));
		System.out.println(resHotelIDList(3));
	}
	
	

}

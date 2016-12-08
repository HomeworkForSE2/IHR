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
		
		int orderID=order.getOrderID();
		map.put(orderID,order);
		orderDataHelper.updateOrderData(map);
		return true;
	}

	//删除订单操作是否有问题
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

	

	@Override
	public List<OrderPO> getAllOrderList() {
		// TODO Auto-generated method stub
		List<OrderPO>list=new ArrayList<OrderPO>();
		Iterator<Map.Entry<Integer,OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,OrderPO> entry=it.next();
			OrderPO order=entry.getValue();
			list.add(order);
			
		}
		return list;
	}

	@Override
	public List<Integer> getRoomIDByOrder(int orderID) {
		// TODO Auto-generated method stub
		String roomID=map.get(orderID).getRoomID();
		List<Integer> list=new ArrayList<>();
		String[]data=roomID.split(",");
		for(int i=0;i<data.length;i++){
			list.add(Integer.valueOf(data[i]));
		}
		return list;
	}

	@Override
	public int getOrderNum() {
		// TODO Auto-generated method stub
		return map.size();
	}
	
	public static void main(String[] args) {
		OrderDaoImpl go=new OrderDaoImpl();
//		go.addOrder(new OrderPO(orderID, userID, hotelID, state, price, startTime, endTime, finishTime, roomType, roomNum, hasChildren, roomID))
//		go.addOrder(new OrderPO(1, 1, 1, 1, 400, "20161111", "20161112", "20161111", 1, 2, false, "11,12"));//1号用户分别在1、2、3、4、5号酒店的未执行、已执行、未执行、异常、撤销订单
//		go.addOrder(new OrderPO(2, 1, 2, 2, 600, "20161111", "20161112", "20161111", 2, 2, false, "21,22"));
//		go.addOrder(new OrderPO(3, 1, 3, 1, 1000, "20161111", "20161112", "20161111", 3, 2, false, "31,32"));
//		go.addOrder(new OrderPO(4, 1, 4, 3, 400, "20161111", "20161112", "20161113", 2, 2, false, "41,42"));
//		go.addOrder(new OrderPO(5, 1, 5, 4, 400, "20161111", "20161112", "20161113", 2, 2, false, "51,52"));
//		go.addOrder(new OrderPO(6, 2, 1, 1, 400, "20161111", "20161112", "20161113", 2, 2, false, "11,12"));//2号用户在1号酒店的未执行和2号酒店已执行
//		go.addOrder(new OrderPO(7, 2, 1, 1, 600, "20161111", "20161112", "20161113", 3, 2, false, "13,14"));
//		go.addOrder(new OrderPO(8, 2, 2, 2, 300, "20161111", "20161112", "20161113", 3, 1, false, "23"));
//		go.addOrder(new OrderPO(9, 3, 4, 3, 300, "20161111", "20161112", "20161113", 3, 1, false, "43"));//3号用户在4号酒店的异常、5号的撤销
//		go.addOrder(new OrderPO(10, 3, 5, 4, 300, "20161111", "20161112", "20161113", 3, 1, false, "53"));
		
	}

}

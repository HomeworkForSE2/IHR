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

	
	//订单里记录房间号
	@Override
	public int getUFRoomID(int roomID) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer, OrderPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			OrderPO order=it.next().getValue();
			
		}
		return 0;
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

}

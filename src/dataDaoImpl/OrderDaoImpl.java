package dataDaoImpl;

import java.util.List;
import java.util.Map;


import dataDao.OrderDao;
import dataDataHelper.DataFactory;
import dataDataHelper.OrderDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao{
	
	private Map<Integer,OrderPO> map;
	
	private OrderDataHelper orderDataHelper;
	
	private DataFactory dataFactory;

	private static OrderDaoImpl orderDataServiceImpl;
	
	private static OrderDaoImpl getInstance(){
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
		return null;
	}

	@Override
	public List<OrderPO> getUserOrderList(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO getOrder(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOrder(OrderPO order) {
		// TODO Auto-generated method stub
		return false;
	}

}

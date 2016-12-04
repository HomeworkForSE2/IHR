package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataDao.OrderDao;
import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
import service.OrderService;
import vo.OrderVO;



public class OrderServiceImpl implements OrderService{

	private static final int NotExecute = 0;
	private static final int Execute = 1;
	private static final int Unusual = 2;
	private static final int Cancel = 3;
	private OrderDao orderDao;
	private List<OrderPO> hotelOrderList;
	private List<OrderPO> userOrderList;
	
	//将某某酒店的订单列表设为全局，以便后续方法的使用
	public OrderServiceImpl( int hotelID){
		orderDao=OrderDaoImpl.getInstance();
		hotelOrderList=orderDao.getHotelOrderList( hotelID);
	}
	
	@Override
	//订单价值暂定为订单价格
	public int getValue(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		int orderValue=orderPO.getPrice();
		return orderValue;
	}

	@Override
	public List<OrderVO> getUserAllOrder(int userID) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		userOrderList=orderDao.getUserOrderList(userID);
		for(OrderPO orderPO:userOrderList){
			OrderVO orderVo = new OrderVO(orderPO);
			list.add(orderVo);
		}
		return list;
	}

	@Override
	public List<OrderVO> getUserNotExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		userOrderList=orderDao.getUserOrderList(userID);
		for(OrderPO orderPO:userOrderList){
			if(orderPO.getState()==NotExecute){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getUserExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		userOrderList=orderDao.getUserOrderList(userID);
		for(OrderPO orderPO:userOrderList){
			if(orderPO.getState()==Execute){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getUserUnusualOredr(int userID) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		userOrderList=orderDao.getUserOrderList(userID);
		for(OrderPO orderPO:userOrderList){
			if(orderPO.getState()==Unusual){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getUserCancelOrder(int userID) {
		// TODO Auto-generated method stub
		List<OrderVO> list=new ArrayList<OrderVO>();
		userOrderList=orderDao.getUserOrderList(userID);
		for(OrderPO orderPO:userOrderList){
			if(orderPO.getState()==Cancel){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelAllOrder(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderPO orderPO : hotelOrderList) {
			OrderVO orderVo = new OrderVO(orderPO);
			list.add(orderVo);
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelNotExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderPO orderPO : hotelOrderList) {
			if(orderPO.getState()==NotExecute){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderPO orderPO : hotelOrderList) {
			if(orderPO.getState()==Execute){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelUnusualOredr(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderPO orderPO : hotelOrderList) {
			if(orderPO.getState()==Unusual){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public List<OrderVO> getHotelCancelOrder(int hotelID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		for (OrderPO orderPO : hotelOrderList) {
			if(orderPO.getState()==Cancel){
				OrderVO orderVO=new OrderVO(orderPO);
				list.add(orderVO);
			}
		}
		return list;
	}

	@Override
	public boolean cancelOrder(int orderID) {
		// TODO Auto-generated method stub
		if(orderDao.getOrder(orderID)==null){
			return true;
		}
		return false;
	}

	@Override
	public boolean createOrder(OrderVO order) {
		int orderID=order.getOrderID();
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setCredit(order.getCredit());
		orderPO.setEndTime(order.getEndTime());
		orderPO.setFinishTime(order.getEndTime());
		orderPO.setHotelID(order.getCredit());
		orderPO.setPrice(order.getCredit());
		orderPO.setRoomNum(order.getCredit());
		orderPO.setRoomType(order.getCredit());
		orderPO.setStartTime(order.getEndTime());
		orderPO.setState(order.getCredit());
		orderPO.setUserID(order.getCredit());
		return orderDao.updateOrder(orderPO);
		}

	@Override
	public boolean setOrderUnusual(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Unusual);
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean setOrderUnusualToCancel(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Cancel);
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean setOrderUnusualToExecute(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Execute);
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean setOrderExecute(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Execute);
		return orderDao.updateOrder(orderPO);
	}

}

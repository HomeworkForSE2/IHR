package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataDao.OrderDao;
import dataDao.RoomDao;
import dataDaoImpl.OrderDaoImpl;
import dataDaoImpl.RoomDaoImpl;
import po.OrderPO;
import po.RoomPO;
import service.OrderByHotelService;
import vo.OrderVO;

public class OrderByHotelServiceImpl implements OrderByHotelService{

	private OrderDao orderDao;
	
	private RoomDao roomDao;
	
	private List<OrderPO> list;
	
	public OrderByHotelServiceImpl() {
		// TODO Auto-generated constructor stub
		orderDao=OrderDaoImpl.getInstance();
		roomDao=RoomDaoImpl.getInstance();
	}
	
	@Override
	public boolean initHotel(int hotelID) {
		// TODO Auto-generated method stub
		list=orderDao.getHotelOrderList(hotelID);
		return true;
	}
	
	
	@Override
	public List<OrderVO> getAllHotelOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 0);
	}

	@Override
	public List<OrderVO> getHotelNotExecuteOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 1);
	}

	@Override
	public List<OrderVO> getHotelExecuteOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 2);
	}

	@Override
	public List<OrderVO> getHotelUnusualOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 3);
	}

	@Override
	public List<OrderVO> getHotelCancelOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 4);
	}
	
	//用户入住开始执行订单,修改订单信息和房间信息
	public boolean executeOrder(int orderID){
		//订单置为已执行
		OrderPO order=orderDao.getOrder(orderID);
		order.setState(2);
		orderDao.updateOrder(order);
		
		//获得对应订单的房间ID列表，将房间状态置为true
		List<Integer> roomList=orderDao.getRoomIDByOrder(orderID);
		Iterator it=roomList.iterator();
		while(it.hasNext()){
			RoomPO room=roomDao.getRoom((int)it.next());
			room.setState(true);
			roomDao.updateRoom(room);
		}
		
		//增加用户信用值
		CreditServiceImpl credit=new CreditServiceImpl();
		credit.addOrderFinishCredit(order.getUserID(),(int) order.getPrice(), orderID);
		return true;
		
	}
	
	//用户完成订单,包括更新房间信息
	public boolean finishOrder(int orderID){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		//订单完成时间
		OrderPO order=orderDao.getOrder(orderID);
		order.setFinishTime(time);
		orderDao.updateOrder(order);
		
		//将房间状态置为false
		List<Integer> roomList=orderDao.getRoomIDByOrder(orderID);
		Iterator it=roomList.iterator();
		while(it.hasNext()){
			RoomPO room=roomDao.getRoom((int)it.next());
			room.setState(false);
			roomDao.updateRoom(room);
		}
		
		return true;
		
	}
	
	//自动,每小时遍历一次,对所有的订单进行遍历(原型)，已经写了时间器来实现
	public boolean setNotExecuteToUnusual(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		Iterator it=list.iterator();
		
		CreditServiceImpl credit=new CreditServiceImpl();
		
		while(it.hasNext()){
			OrderPO order=(OrderPO)it.next();
			String startTime=order.getStartTime();
			if(order.getState()==1&&Integer.valueOf(time)>Integer.valueOf(startTime)){
				order.setState(3);
				credit.deduceCredit(order.getUserID(), (int)order.getPrice(), order.getOrderID());
			}
		}
		
		return true;
		
	}
	
	
	/* 情况（即延迟入住），将异常订单置为已执行订单，恢复用户扣除的信用
	 * 缺少对orderID的限制
	 */
	public boolean setUnusualToExecute(int orderID){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		
		OrderPO order=orderDao.getOrder(orderID);
		CreditServiceImpl credit=new CreditServiceImpl();
		credit.recoverCredit(order.getUserID(), 0, orderID);
		
		order.setFinishTime(time);
		order.setState(2);
		orderDao.updateOrder(order);
		return true;
		
	}


	

}

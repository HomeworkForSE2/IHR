package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import dataDao.OrderDao;
import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
import service.OrderService;
import vo.OrderVO;



public class OrderServiceImpl implements OrderService{
	private static final int decision=1;//1 ->recover half ;0->recover everything
	private static final int NotExecute = 0;
	private static final int Execute = 1;
	private static final int Unusual = 2;
	private static final int Cancel = 3;
	private static final int cancelTofinish=6;//距离最晚执行时间小于六小时时，用户撤销订单需要扣除信用值
	private OrderDao orderDao;
	private List<OrderPO> hotelOrderList;
	private List<OrderPO> userOrderList;
	
	//将某某酒店的订单列表设为全局，以便后续方法的使用
	public OrderServiceImpl( int hotelID){
		orderDao=OrderDaoImpl.getInstance();
		hotelOrderList=orderDao.getHotelOrderList( hotelID);
	}
	
	@Override
	//订单价值暂定为订单价格，信用值为订单价值的一半
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
	//感觉和上面cancel的方法重合了
	public boolean cancelOrder(int orderID) {
		// TODO Auto-generated method stub
		if(orderDao.getOrder(orderID)==null){
			return true;
		}
		return false;
	}

	@Override
	public boolean createOrder(OrderVO order) {
		//根据各种策略计算订单价格的方法在orderPO写吗？？
		//创建订单时需要同时创建房间
		//创建订单方法暂停
		int orderID=order.getOrderID();
		OrderPO orderPO=orderDao.getOrder(orderID);
		if(orderPO.getCredit()<0){
			return false;
		}else{
			Timer timer=new Timer();
			orderPO.setCredit(order.getCredit());
			orderPO.setEndTime(order.getEndTime());
			orderPO.setFinishTime(order.getFinishTime());
			orderPO.setHotelID(order.getHotelId());
			orderPO.setRoomNum(order.getRoomNum());
			orderPO.setRoomType(order.getRoomType());
			orderPO.setStartTime(order.getStartTime());
			orderPO.setState(order.getState());
			orderPO.setUserID(order.getUserId());
			RoomServiceImpl createRoom=new RoomServiceImpl();
			double initialPrice=order.getRoomNum()*order.getPrice();
			StrategyServiceImpl calculate=new StrategyServiceImpl();
			initialPrice=calculate.calcute(order);
			orderPO.setPrice((int)initialPrice);
			int year=Integer.parseInt(order.getStartTime().substring(0,4));
			int month=Integer.parseInt(order.getStartTime().substring(4,6));
			int day=Integer.parseInt(order.getStartTime().substring(6,8));
			int hour=Integer.parseInt(order.getStartTime().substring(8));
			Calendar calendar=Calendar.getInstance();
			calendar.set(Calendar.YEAR,year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, day);
			calendar.set(Calendar.HOUR, hour);
			Date  date=calendar.getTime();
		//	timer.schedule( createRoom.creatRoom(order.getHotelId(), order.getRoomType(), true),date);
			createRoom.creatRoom(order.getHotelId(), order.getRoomType(), true);
			return orderDao.updateOrder(orderPO);
		}
	}
	//这个方法不是由界面发起的，怎么做到系统自动更新？？
	@Override
	public boolean setOrderUnusual(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Unusual);
		CreditServiceImpl creditDeduce=new CreditServiceImpl();
		creditDeduce.deduceCredit(orderPO.getOrderID(), orderPO.getCredit(), orderID);
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean setOrderUnusualToCancel(int orderID) {
		// TODO Auto-generated method stub
		
		OrderPO orderPO=orderDao.getOrder(orderID);
		//营销人员撤销异常订单
		if(orderPO.getState()==Unusual){
			orderPO.setState(Cancel);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("YYYYMMDDHH");//时间格式2016120609
			String cancelTime=format.format(date);
			orderPO.setCancelTime(cancelTime);
			CreditServiceImpl creditRecover=new CreditServiceImpl();
			creditRecover.recoverCredit(orderPO.getUserID(), decision, orderID);
			return orderDao.updateOrder(orderPO);
		}
		//用户撤销未执行订单
		if(orderPO.getState()==NotExecute){
			orderPO.setState(Cancel);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("YYYYMMDDHH");//时间格式2016120609
			String cancelTime=format.format(date);
			orderPO.setCancelTime(cancelTime);
			int cancel=Integer.parseInt(cancelTime);
			int finish=Integer.parseInt(orderPO.getFinishTime());
			//时间太短要扣除信用值
			if(finish-cancel<cancelTofinish){
				CreditServiceImpl creditDeduce=new CreditServiceImpl();
				creditDeduce.deduceCredit(orderPO.getOrderID(), orderPO.getCredit(), orderID);
			}
			return orderDao.updateOrder(orderPO);
		}
		return false;
	}

	@Override
	//延迟入住，订单状态变为已执行，恢复扣除的信用值
	public boolean setOrderUnusualToExecute(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Execute);
		CreditServiceImpl creditRecover=new CreditServiceImpl();
		creditRecover.recoverCredit(orderPO.getUserID(),decision, orderID);
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean setOrderExecute(int orderID) {
		// TODO Auto-generated method stub
		OrderPO orderPO=orderDao.getOrder(orderID);
		orderPO.setState(Execute);
		CreditServiceImpl creditAdd=new CreditServiceImpl();
		creditAdd.addOrderFinishCredit(orderPO.getOrderID(), orderPO.getCredit(), orderID);
		return orderDao.updateOrder(orderPO);
	}

}

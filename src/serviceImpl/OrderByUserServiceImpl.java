package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataDao.OrderDao;
import dataDao.RoomDao;
import dataDao.UserDao;
import dataDaoImpl.OrderDaoImpl;
import dataDaoImpl.UserDaoImpl;
import po.OrderPO;
import po.RoomPO;
import service.OrderByUserService;
import vo.OrderVO;

public class OrderByUserServiceImpl implements OrderByUserService{

	private OrderDao orderDao;
	
	private RoomDao roomDao;
	
	private UserDao userDao;
	
	private List<OrderPO> list;
	
	private int userID;
	
	private int orderNum;
	
	public OrderByUserServiceImpl() {
		// TODO Auto-generated constructor stub
		orderDao=OrderDaoImpl.getInstance();
		userDao=UserDaoImpl.getInstance();		
		this.orderNum=orderDao.getOrderNum()+1;
	}
	
	@Override
	public boolean initUser(int userID) {
		// TODO Auto-generated method stub
		list=orderDao.getUserOrderList(userID);
		this.userID=userID;
		return true;
	}
	
	public static List<OrderVO> filter(List<OrderPO> list,int orderType){
		List<OrderVO> l=new ArrayList<>();
		Iterator it=list.iterator();
		while(it.hasNext()){
			OrderPO order=(OrderPO)it.next();
			if(orderType==0){
				l.add(new OrderVO(order));
			}else{
				if(order.getState()==orderType){
					l.add(new OrderVO(order));
				}
			}
		}
		return l;
		
	}
	
	@Override
	public List<OrderVO> getAllUserOrder() {
		// TODO Auto-generated method stub
		return filter(list,0);
	}

	@Override
	public List<OrderVO> getUserNotExecuteOrder() {
		// TODO Auto-generated method stub
		return filter(list,1);
	}

	@Override
	public List<OrderVO> getUserExecuteOrder() {
		// TODO Auto-generated method stub
		return filter(list,2);
	}

	@Override
	public List<OrderVO> getUserUnusualOrder() {
		// TODO Auto-generated method stub
		return filter(list,3);
	}

	@Override
	public List<OrderVO> getUserCancelOrder() {
		// TODO Auto-generated method stub
		return filter(list,4);
	}
	
	/*
	 * 房间数量、类型、预订时间段是否满足
	 * 计算订单价格和填房间号
	 * num++
	 */
	public boolean createOrder(OrderVO order){
		int userID=order.getUserId();
		int hotelID=order.getHotelId();
		int roomNum=order.getRoomNum();
		int roomType=order.getRoomType();
		String startTime=order.getStartTime();
		String endTime=order.getEndTime();
		boolean hasChildren=order.isHasChildren();
		int st=Integer.valueOf(startTime);
		int et=Integer.valueOf(endTime);
		
		//小于0是在生成订单是阻止，还是阻止生成订单？
		if(userDao.findUser(userID).getCredit()<0){
			return false;
		}
		
		//得到该酒店房间列表，删除不符合房型的房间
		List<RoomPO> roomList=roomDao.getAllRoom(hotelID);
		Iterator it=roomList.iterator();
		while(it.hasNext()){
			RoomPO room=(RoomPO)it.next();
			if(room.getRoomType()!=roomType){
				roomList.remove(room);
			}
		}
		//房间数量不够
		if(roomList.size()<roomNum){
			return false;
		}
		
		//房间数量够,第二次过滤
		Iterator it2=roomList.iterator();
		Iterator it3=list.iterator();
		while(it2.hasNext()){
			RoomPO room=(RoomPO)it2.next();
			int roomID=room.getRoomID();
			//对订单进行遍历，看该房间是否存在于未执行订单上，且时间有冲突
			while(it3.hasNext()){
				OrderPO o=(OrderPO)it3.next();
				int st1=Integer.valueOf(o.getStartTime());
				int et1=Integer.valueOf(o.getEndTime());
				boolean condition1=(st<=st1)&&(et1<=et);
				boolean condition2=(st1<=st)&&(et<=et1);
				boolean condition3=(st<=st1)&&(et<=et1);
				boolean condition4=(st1<=st)&&(et1<=et);		
				if(o.getState()==1&&o.contains(roomID)&&(condition1||condition2||condition3||condition4)){
					roomList.remove(room);
				}
			}
		}
		//房间数量不够
		if(roomList.size()<roomNum){
			return false;
		}
		
		//计算总价，记录房间号，生成PO
		double price=roomNum*roomList.get(0).getPrice();
		
		//策略计算总价
		StrategyServiceImpl strategy=new StrategyServiceImpl();
		price=strategy.calcute(userID, hotelID, price, roomNum);
		
		//写房间号
		String roomID="";
		for(int i=0;i<roomNum-1;i++){
			roomID+=roomList.get(i).getRoomID()+",";
		}
		roomID+=roomList.get(roomNum-1).getRoomID();
		
		OrderPO fOrder=new OrderPO(orderNum, userID, hotelID, 1, price, startTime, endTime, "", roomType, roomNum, hasChildren, roomID);		
		orderDao.addOrder(fOrder);
		return true;	
	}
	
	//撤销自己未执行的订单，最晚执行时间不足6小时扣信用值（总价值的1/2）置为已撤销状态，记录撤销时间
	public boolean cancelOrder(int orderID){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		OrderPO order=orderDao.getOrder(orderID);
		String lastTime=order.getStartTime();
		
		if((Integer.valueOf(lastTime)-Integer.valueOf(time))<6){
			//
			CreditServiceImpl credit=new CreditServiceImpl();
			credit.deduceCredit(userID, (int)order.getPrice()/2, orderID);
		}
		
		//撤销的话，结束时间就是撤销时间
		order.setState(4);
		order.setFinishTime(time);
		orderDao.updateOrder(order);
		return true;
		
	}

	

}

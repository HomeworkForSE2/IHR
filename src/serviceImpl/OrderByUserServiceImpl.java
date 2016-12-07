package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataDao.OrderDao;
import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
import service.OrderService;
import vo.OrderVO;

public class OrderByUserServiceImpl extends OrderService{

	private OrderDao orderDao;
	
	private List<OrderPO> list;
	
	private int userID;
	
	public OrderByUserServiceImpl(int userID) {
		// TODO Auto-generated constructor stub
		orderDao=OrderDaoImpl.getInstance();
		list=orderDao.getUserOrderList(userID);
		this.userID=userID;
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
	public List<OrderVO> getAllOrder() {
		// TODO Auto-generated method stub
		return filter(list,0);
	}

	@Override
	public List<OrderVO> getNotExecuteOredr() {
		// TODO Auto-generated method stub
		return filter(list,1);
	}

	@Override
	public List<OrderVO> getExecuteOredr() {
		// TODO Auto-generated method stub
		return filter(list,2);
	}

	@Override
	public List<OrderVO> getUnusualOredr() {
		// TODO Auto-generated method stub
		return filter(list,3);
	}

	@Override
	public List<OrderVO> getCancelOrder() {
		// TODO Auto-generated method stub
		return filter(list,4);
	}
	
	//重点难点
	public boolean createOrder(OrderVO order){
		return false;	
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
			credit.deduceCredit(userID, order.getPrice()/2, orderID);
		}
		
		//撤销的话，结束时间就是撤销时间
		order.setState(4);
		order.setFinishTime(time);
		orderDao.updateOrder(order);
		return true;
		
	}

}

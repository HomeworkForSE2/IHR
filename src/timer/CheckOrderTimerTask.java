package timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dataDao.OrderDao;
import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
import serviceImpl.CreditServiceImpl;

//时间器布局在服务端的构造方法
public class CheckOrderTimerTask extends TimerTask{

	private OrderDao orderDao;
	
	private List<OrderPO> orderList;
	
	public CheckOrderTimerTask(){
		orderDao=OrderDaoImpl.getInstance();
		orderList=orderDao.getAllOrderList();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		
		Iterator<OrderPO> it=orderList.iterator();
		while(it.hasNext()){
			OrderPO order=(OrderPO)it.next();
			//未执行订单，且当前时间大于startTime，订单置为异常，且扣用户除信用值
			String startTime=order.getStartTime();
			int orderID=order.getOrderID();
			int state=order.getState();
			int userID=order.getUserID();
			
			if(Integer.valueOf(time)>Integer.valueOf(startTime)&&state==1){
				order.setState(3);
				orderDao.updateOrder(order);
				CreditServiceImpl creditHelper=new CreditServiceImpl();
				creditHelper.deduceCredit(userID, (int)order.getPrice(), orderID);		
			}
			
		}
	}
	
	public static void main(String[] args) {
		TimerTask task=new CheckOrderTimerTask();
		Calendar  calendar= Calendar.getInstance();    
        Date firstTime = calendar.getTime();
        long period = 1000 * 60* 60;   //每隔一小时遍历所有order一次
        
        Timer timer = new Timer();        
        timer.schedule(task, firstTime, period);
	}

}

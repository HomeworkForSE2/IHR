package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dataDao.OrderDao;
import dataDaoImpl.OrderDaoImpl;
import po.OrderPO;
import service.OrderByWebService;
import vo.OrderVO;

public class OrderByWebServiceImpl implements OrderByWebService{

	private OrderDao orderDao;
	
	private List<OrderPO> list;
	
	public OrderByWebServiceImpl() {
		// TODO Auto-generated constructor stub
		orderDao=OrderDaoImpl.getInstance();
		list=orderDao.getAllOrderList();
	}
	
	@Override
	public List<OrderVO> getAllWebOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 0);
	}

	@Override
	public List<OrderVO> getWebNotExecuteOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 1);
	}

	@Override
	public List<OrderVO> getWebExecuteOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 2);
	}

	@Override
	public List<OrderVO> getWebUnusualOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 3);
	}

	@Override
	public List<OrderVO> getWebCancelOrder() {
		// TODO Auto-generated method stub
		return OrderByUserServiceImpl.filter(list, 4);
	}
	
	//撤销异常订单，恢复用户被扣除信用值的全部或一半，订单置为已撤销状态，记录撤销时间
	public boolean cancelUnusualOrder(int orderID,int dec){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHH");
		String time=format.format(date);
		
		OrderPO order=orderDao.getOrder(orderID);
		
		CreditServiceImpl credit=new CreditServiceImpl();
		credit.recoverCredit(order.getUserID(), dec, orderID);//这个方法有无问题？
		
		order.setFinishTime(time);
		order.setState(4);
		orderDao.updateOrder(order);
		return false;
		
	}

	

}

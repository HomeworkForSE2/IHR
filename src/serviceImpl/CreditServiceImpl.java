package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataDao.CreditDao;
import dataDao.OrderDao;
import dataDao.UserDao;
import dataDao.UserManageDao;
import dataDaoImpl.CreditDaoImpl;
import dataDaoImpl.OrderDaoImpl;
import dataDaoImpl.UserDaoImpl;
import po.CreditChangePO;
import po.OrderPO;
import po.UserPO;
import service.CreditService;
import vo.CreditChangeVO;

public class CreditServiceImpl implements CreditService {
	
	private UserManageDao userManageDao;
	private UserDao userDao;
	private CreditDao creditDao;
	private OrderDao orderDao;
	
	public CreditServiceImpl(){
		
		userManageDao = UserDaoImpl.getInstance();
		userDao = UserDaoImpl.getInstance();
		creditDao = CreditDaoImpl.getInstance();
		orderDao = OrderDaoImpl.getInstance();
		
	}

	@Override
	public boolean addRechargeCredit(int userID, int credit,int orderID) {
		UserPO user = userDao.findUser(userID);
		int startCredit = user.getCredit();
		
		userManageDao.addUserCredit(userID, credit);
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("YYYYMMdd");
		String time=format.format(date);
		
		int action = 3;
		
		CreditChangePO change = new CreditChangePO(time, orderID, userID, startCredit, startCredit+credit, action);
		
		return creditDao.addCreditChange(change);
	}

	@Override
	public boolean recoverCredit(int userID, int dicision, int orderID) {
		UserPO user = userDao.findUser(userID);
		int startCredit = user.getCredit();
		
		OrderPO order = orderDao.getOrder(orderID);
		int credit = (int)order.getPrice(); //decision==0 -> recover everything
		
		if(dicision==1){ // dicision==1 -> recover half 
			credit = (int) (credit*0.5);
		}
		
		userManageDao.addUserCredit(userID, credit);
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("YYYYMMdd");
		String time=format.format(date);
		
		int action = 4;

		
		CreditChangePO change = new CreditChangePO(time, orderID, userID, startCredit, startCredit+credit, action);
		
		return creditDao.addCreditChange(change);
	}

	@Override
	public boolean deduceCredit(int userID, int credit, int orderID) {
		UserPO user = userDao.findUser(userID);
		int startCredit = user.getCredit();
		
		userManageDao.reduceUserCredit(userID, credit);
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("YYYYMMdd");
		String time=format.format(date);
		
		int action = 2;
		
		CreditChangePO change = new CreditChangePO(time, orderID, userID, startCredit, startCredit-credit, action);
		
		return creditDao.addCreditChange(change);
	}

	@Override
	public boolean addOrderFinishCredit(int userID, int credit, int orderID) {
		UserPO user = userDao.findUser(userID);
		int startCredit = user.getCredit();
		
		userManageDao.addUserCredit(userID, credit);
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("YYYYMMdd");
		String time=format.format(date);
		
		int action = 0;
		
		CreditChangePO change = new CreditChangePO(time, orderID, userID, startCredit, startCredit+credit, action);
		
		return creditDao.addCreditChange(change);
	}

	@Override
	public List<CreditChangeVO> showCreditRecord(int userID) {
		
		List<CreditChangePO> list = creditDao.findCreditChangeList(userID);
		List<CreditChangeVO> creditList = new ArrayList<>();
		Iterator it=list.iterator();
		while(it.hasNext()){
			CreditChangePO c=(CreditChangePO) it.next();
			CreditChangeVO credit = new CreditChangeVO(c);
			creditList.add(credit);
		}
		
		return creditList;
	}

}

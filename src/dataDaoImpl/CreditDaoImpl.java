package dataDaoImpl;

import java.util.Map;

import dataDao.CreditDao;
import dataDataHelper.DataFactory;
import dataDataHelper.CreditDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.CreditChangePO;

public class CreditDaoImpl implements CreditDao{

	private Map<Integer,CreditChangePO> map;
	
	private CreditDataHelper creditDataHelper;
	
	private DataFactory dataFactory;

	private static CreditDaoImpl creditDataServiceImpl;
	
	private static CreditDaoImpl getInstance(){
		if(creditDataServiceImpl==null){
			creditDataServiceImpl=new CreditDaoImpl();
		}
		return creditDataServiceImpl;
	}
	
	public CreditDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			creditDataHelper=dataFactory.getCreditDataHelper();
			map=creditDataHelper.getCreditData();
		}
	}
	@Override
	public boolean addCreditChange(CreditChangePO creditChange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reduceUserCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

}

package dataDaoImpl;



import java.util.List;

import dataDao.CreditDao;
import dataDataHelper.DataFactory;
import dataDataHelper.CreditDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.CreditChangePO;

public class CreditDaoImpl implements CreditDao{

	private List<CreditChangePO> list;
	
	private CreditDataHelper creditDataHelper;
	
	private DataFactory dataFactory;

	private static CreditDaoImpl creditDataServiceImpl;
	
	public static CreditDaoImpl getInstance(){
		if(creditDataServiceImpl==null){
			creditDataServiceImpl=new CreditDaoImpl();
		}
		return creditDataServiceImpl;
	}
	
	public CreditDaoImpl(){
		if(list==null){
			dataFactory=new DataFactoryImpl();
			creditDataHelper=dataFactory.getCreditDataHelper();
			list=creditDataHelper.getCreditData();
		}
	}
	@Override
	public boolean addCreditChange(CreditChangePO creditChange) {
			list.add(creditChange);
			creditDataHelper.updateCreditData(list);
			return true;
	}
	
	public static void main(String arg[]){
		CreditDaoImpl ex = new CreditDaoImpl();
		ex.test();
	}
	
	public void test(){
		CreditChangePO change = new CreditChangePO("12/05",100021,12345,120,300,3);
		addCreditChange(change);
	}

}

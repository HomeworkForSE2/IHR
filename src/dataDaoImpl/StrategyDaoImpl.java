package dataDaoImpl;

import java.util.List;
import java.util.Map;

import dataDao.StrategyDao;
import dataDataHelper.DataFactory;
import dataDataHelper.OrderDataHelper;
import dataDataHelper.StrategyDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.OrderPO;
import po.StrategyPO;
import po.VipPO;

public class StrategyDaoImpl implements StrategyDao{

	private Map<Integer,StrategyPO> map;
	
	private StrategyDataHelper strategyDataHelper;
	
	private DataFactory dataFactory;

	private static StrategyDaoImpl strategyDataServiceImpl;
	
	private static StrategyDaoImpl getInstance(){
		if(strategyDataServiceImpl==null){
			strategyDataServiceImpl=new StrategyDaoImpl();
		}
		return strategyDataServiceImpl;
	}
	
	public StrategyDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			strategyDataHelper=dataFactory.getStrategyDataHelper();
			map=strategyDataHelper.getStrategyData();
		}
	}
	@Override
	public boolean addStrategy(StrategyPO strategy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StrategyPO> findHotelStrategyList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StrategyPO> findWebstrategyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVip(VipPO vip) {
		// TODO Auto-generated method stub
		return false;
	}

}

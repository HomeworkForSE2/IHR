package dataDaoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dataDao.StrategyDao;
import dataDataHelper.DataFactory;
import dataDataHelper.StrategyDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.StrategyPO;
import po.VipPO;

public class StrategyDaoImpl implements StrategyDao{

	private List<StrategyPO> list;
	
	private Map<Integer,VipPO> map;
	
	private StrategyDataHelper strategyDataHelper;
	
	private DataFactory dataFactory;

	private static StrategyDaoImpl strategyDataServiceImpl;
	
	public static StrategyDaoImpl getInstance(){
		if(strategyDataServiceImpl==null){
			strategyDataServiceImpl=new StrategyDaoImpl();
		}
		return strategyDataServiceImpl;
	}
	
	public StrategyDaoImpl(){
		if(list==null&&map==null){
			dataFactory=new DataFactoryImpl();
			strategyDataHelper=dataFactory.getStrategyDataHelper();
			list=strategyDataHelper.getStrategyData();	
			map=strategyDataHelper.getVipData();
		}
	}
	@Override
	public boolean addStrategy(StrategyPO strategy) {
		// TODO Auto-generated method stub
		list.add(strategy);
		strategyDataHelper.updateStrategyData(list);
		return true;
	}

	@Override
	public List<StrategyPO> findHotelStrategyList(int hotelID) {
		// TODO Auto-generated method stub
		List <StrategyPO> hotelStrategyList=new ArrayList<StrategyPO>();
		Iterator it=list.iterator();
		while(it.hasNext()){	
			StrategyPO strategy=(StrategyPO)it.next();
			if(strategy.getOwner()==hotelID){
				hotelStrategyList.add(strategy);
			}
		}
		return hotelStrategyList;
	}

	@Override
	public List<StrategyPO> findWebstrategyList() {
		// TODO Auto-generated method stub
		return findHotelStrategyList(0);
	}

	@Override
	public boolean addVip(VipPO vip) {
		// TODO Auto-generated method stub
		int vipGrade=vip.getVipGrade();
		if(map.size()==0){
			VipPO vip0=new VipPO(0, 0);
			map.put(0, vip0);
		}
		
		if(map.get(vipGrade)==null){
			if(map.get(vipGrade+1)==null&&map.get(vipGrade-1)!=null&&map.get(vipGrade-1).getVipGradeCredit()<vip.getVipGradeCredit()){
				map.put(vipGrade, vip);
				strategyDataHelper.updateVipData(map);
				return true;
			}
			
			
			
		}
		return false;
	}
	
	@Override
	public int getVipGrade(int credit) {
		// TODO Auto-generated method stub
		int vipGrade=0;
		Iterator<Map.Entry<Integer,VipPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			VipPO vip=it.next().getValue();
			if(vip.getVipGradeCredit()<credit&&vipGrade<vip.getVipGrade()){
				vipGrade=vip.getVipGrade();
			}
		}
		return vipGrade;
	}
	
	public static void main(String[] args) {
		
	}
	
	public void test(){
		
	}

	

}

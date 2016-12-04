package serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataDao.StrategyDao;
import dataDaoImpl.StrategyDaoImpl;
import po.StrategyEntPO;
import po.StrategyForVipPO;
import po.StrategyPO;
import po.StrategyRoomNumPO;
import po.VipPO;
import service.StrategyService;
import vo.OrderVO;
import vo.StrategyVO;

public class StrategyServiceImpl implements StrategyService {
	
	private StrategyDao strategyDao;
	
	public StrategyServiceImpl() {
		// TODO Auto-generated constructor stub
		strategyDao=StrategyDaoImpl.getInstance();
	}

	@Override
	public boolean setSpecialTimeByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(strategy.getOwnerId(), 1, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setResRoomNumByHotel(StrategyVO strategy, int roomNum) {
		// TODO Auto-generated method stub
		StrategyRoomNumPO s=new StrategyRoomNumPO(strategy.getOwnerId(), 2, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), roomNum);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setSpecialTimeByWeb(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(0, 1, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setBirthdayByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(strategy.getOwnerId(), 0, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setEnterpriseByHotel(StrategyVO strategy, String enterpriseName) {
		// TODO Auto-generated method stub
		StrategyEntPO s=new StrategyEntPO(strategy.getOwnerId(), 3, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), enterpriseName);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setForVip(StrategyVO strategy,String BD,int vipGrade) {
		// TODO Auto-generated method stub
		StrategyForVipPO s=new StrategyForVipPO(0, 4, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), BD, vipGrade);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setVipGrade(int vipGrade, int credit) {
		// TODO Auto-generated method stub
		VipPO vip=new VipPO(vipGrade, credit);
		return strategyDao.addVip(vip);
	}

	@Override
	public List<StrategyVO> viewHotelStrategyList(int hotelID) {
		// TODO Auto-generated method stub
		List<StrategyPO> list=strategyDao.findHotelStrategyList(hotelID);
		List<StrategyVO> strategyList=new ArrayList<>();
		Iterator it=list.iterator();
		while(it.hasNext()){
			StrategyPO s=(StrategyPO)it.next();
			StrategyVO strategy=new StrategyVO(s);
			strategyList.add(strategy);
		}
		return strategyList;
	}

	@Override
	public List<StrategyVO> viewWebStrategyList() {
		// TODO Auto-generated method stub
		return viewHotelStrategyList(0);
	}

	@Override
	public int calcute(OrderVO vo) {
		// TODO Auto-generated method stub
		int hotelID=vo.getHotelId();
		return 0;
	}

}

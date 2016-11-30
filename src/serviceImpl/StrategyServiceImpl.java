package serviceImpl;

import java.util.List;

import service.StrategyService;
import vo.OrderVO;
import vo.StrategyVO;

public class StrategyServiceImpl implements StrategyService {

	@Override
	public boolean setSpecialTimeByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setResRoomNumByHotel(StrategyVO strategy, int roomNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setSpecialTimeByWeb(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBirthdayByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setEnterpriseByHotel(StrategyVO strategy, String enterpriseName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setForVip(StrategyVO strategy, int vipGrade, String BD) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setVipGrade(int vipGrade, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<StrategyVO> viewHotelStrategyList(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StrategyVO> viewWebStrategyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcute(OrderVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

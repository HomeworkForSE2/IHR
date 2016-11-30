package serviceImpl;

import java.util.List;

import service.CreditService;
import vo.CreditChangeVO;

public class CreditServiceImpl implements CreditService {

	@Override
	public boolean addRechargeCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recoverCredit(int userID, int dicision) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deduceCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOrderFinishCredit(int userID, int credit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CreditChangeVO> showCreditRecord(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}

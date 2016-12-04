package dataDao;

import java.util.List;

import po.CreditChangePO;
import po.StrategyPO;

public interface CreditDao {

	/**
	 * 
	 * @param creditChange
	 * @return 是否增加信用记录成功
	 */
	public boolean addCreditChange(CreditChangePO creditChange);
	
	
	
	public List<CreditChangePO> findCreditChangeList(int userID);
	

	
}

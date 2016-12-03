package dataDao;

import po.CreditChangePO;

public interface CreditDao {

	/**
	 * 
	 * @param creditChange
	 * @return 是否增加信用记录成功
	 */
	public boolean addCreditChange(CreditChangePO creditChange);
	

	
}

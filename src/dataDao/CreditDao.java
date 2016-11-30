package dataDao;

import po.CreditChangePO;

public interface CreditDao {

	/**
	 * 
	 * @param creditChange
	 * @return 是否增加信用记录成功
	 */
	public boolean addCreditChange(CreditChangePO creditChange);
	

	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否添加信用成
	 */
	public boolean addUserCredit(int userID,int credit);
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否减少信用成功
	 */
	public boolean reduceUserCredit(int userID,int credit);
}

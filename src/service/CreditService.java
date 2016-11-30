package service;

import java.util.List;

import vo.CreditChangeVO;

public interface CreditService {
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否增加充值信用值成功
	 */
	public boolean addRechargeCredit(int userID,int credit);

	
	/**
	 * 
	 * @param userID
	 * @param dicision
	 * @return 是否恢复信用值成功
	 */
	public boolean recoverCredit(int userID,int dicision);
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否扣除信用值成功
	 */
	public boolean deduceCredit(int userID,int credit);
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否增加完成订单信用值成功
	 */
	public boolean addOrderFinishCredit(int userID,int credit);
	
	/**
	 * 
	 * @param userID
	 * @return 用户信用记录列表
	 */
	public List<CreditChangeVO> showCreditRecord(int userID);
}

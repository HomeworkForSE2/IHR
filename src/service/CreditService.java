package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.CreditChangeVO;

public interface CreditService extends Remote{
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否增加充值信用值成功
	 */
	public boolean addRechargeCredit(int userID,int credit,int orderID) throws RemoteException;

	
	/**
	 * 
	 * @param userID
	 * @param dicision
	 * @return 是否恢复信用值成功
	 */
	public boolean recoverCredit(int userID,int dicision,int orderID) throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否扣除信用值成功
	 */
	public boolean deduceCredit(int userID,int credit,int orderID) throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @param credit
	 * @return 是否增加完成订单信用值成功
	 */
	public boolean addOrderFinishCredit(int userID,int credit,int orderID) throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @return 用户信用记录列表
	 */
	public List<CreditChangeVO> showCreditRecord(int userID) throws RemoteException;
}

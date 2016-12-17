package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface OrderByWebService extends Remote{
	
	
	/**
	 * 
	 * @param ID
	 * @return 所有订单
	 */
	public List<OrderVO> getAllWebOrder()throws RemoteException;

	/**
	 * 
	 * @param ID
	 * @return 未执行订单
	 */
	public List<OrderVO> getWebNotExecuteOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经执行订单
	 */
	public List<OrderVO> getWebExecuteOrder()throws RemoteException;
	
	
	/**
	 * 
	 * @param ID
	 * @return 异常订单
	 */
	public List<OrderVO> getWebUnusualOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经撤销订单
	 */
	public List<OrderVO> getWebCancelOrder()throws RemoteException;

	
	/**
	 * 
	 * @param orderID
	 * @param dec
	 * @return
	 */
	public boolean cancelUnusualOrder(int orderID,int dec)throws RemoteException;

}

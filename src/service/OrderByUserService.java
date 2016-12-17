package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface OrderByUserService extends Remote {
	
	/**
	 * 
	 * @param ID
	 */
	public boolean initUser(int ID)throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 所有订单
	 */
	public List<OrderVO> getAllUserOrder()throws RemoteException;

	/**
	 * 
	 * @param ID
	 * @return 未执行订单
	 */
	public List<OrderVO> getUserNotExecuteOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经执行订单
	 */
	public List<OrderVO> getUserExecuteOrder()throws RemoteException;
	
	
	/**
	 * 
	 * @param ID
	 * @return 异常订单
	 */
	public List<OrderVO> getUserUnusualOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经撤销订单
	 */
	public List<OrderVO> getUserCancelOrder()throws RemoteException;
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	public boolean createOrder(OrderVO order)throws RemoteException;
	
	
	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public boolean cancelOrder(int orderID)throws RemoteException;

}

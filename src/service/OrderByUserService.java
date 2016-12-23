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
	 * @return 生成订单是否成功
	 */
	public boolean createOrder(OrderVO order)throws RemoteException;
	
	
	/**
	 * 
	 * @param orderID
	 * @return 撤销订单是否成功
	 */
	public boolean cancelOrder(int orderID)throws RemoteException;

	/**
	 * 
	 * @param userID
	 * @param hotelID
	 * @return 用户是否在此酒店完成过订单
	 * @throws RemoteException
	 */
	public boolean hasUserFinishedOrderInThisHotel(int hotelID)throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @param hotelID
	 * @return 用户是否在此酒店撤销过订单
	 * @throws RemoteException
	 */
	public boolean hasUserCanceledOrderInThisHotel(int hotelID)throws RemoteException;
	
	/**
	 * 
	 * @param userID
	 * @param hotelID
	 * @return 用户是否在此酒店有过异常订单
	 * @throws RemoteException
	 */
	public boolean hasUserUnusualOrderInThisHotel(int hotelID)throws RemoteException;
	
	/**
	 * 
	 * @param hotelID
	 * @return 用户是否正在此酒店预订
	 * @throws RemoteException
	 */
	public boolean isUserOrderingInThisHotel(int hotelID)throws RemoteException;
}

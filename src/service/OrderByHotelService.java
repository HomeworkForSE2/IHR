package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.OrderVO;

public interface OrderByHotelService extends Remote{
	
	/**
	 * 
	 * @param ID
	 */
	public boolean initHotel(int ID)throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 所有订单
	 */
	public List<OrderVO> getAllHotelOrder()throws RemoteException;

	/**
	 * 
	 * @param ID
	 * @return 未执行订单
	 */
	public List<OrderVO> getHotelNotExecuteOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经执行订单
	 */
	public List<OrderVO> getHotelExecuteOrder()throws RemoteException;
	
	
	/**
	 * 
	 * @param ID
	 * @return 异常订单
	 */
	public List<OrderVO> getHotelUnusualOrder()throws RemoteException;
	
	/**
	 * 
	 * @param ID
	 * @return 已经撤销订单
	 */
	public List<OrderVO> getHotelCancelOrder()throws RemoteException;
	
	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public boolean executeOrder(int orderID)throws RemoteException;
	
	
	
	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public boolean finishOrder(int orderID)throws RemoteException;
	
	
	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public boolean setUnusualToExecute(int orderID)throws RemoteException;

}

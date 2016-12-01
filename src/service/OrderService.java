package service;

import java.rmi.Remote;
import java.util.List;

import vo.OrderVO;

public interface OrderService extends Remote{
	/**
	 * 
	 * @param orderID
	 * @return 订单的价值
	 */
	public int getValue(int orderID);
	
	/**
	 * 
	 * @param userID
	 * @return 用户所有订单
	 */
	public List<OrderVO> getUserAllOrder(int userID);
	
	/**
	 * 
	 * @param userID
	 * @return 用户未执行订单
	 */
	public List<OrderVO> getUserNotExecuteOredr(int userID);
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经执行订单
	 */
	public List<OrderVO> getUserExecuteOredr(int userID);
	
	/**
	 * 
	 * @param userID
	 * @return 用户异常订单
	 */
	public List<OrderVO> getUserUnusualOredr(int userID);
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经撤销订单
	 */
	public List<OrderVO> getUserCancelOrder(int userID);
	
	/**
	 * 
	 * @param HotelID
	 * @return 酒店所有订单
	 */
	public List<OrderVO> getHotelAllOrder(int hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店未执行订单
	 */
	public List<OrderVO> getHotelNotExecuteOredr(int hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店已执行订单
	 */
	public List<OrderVO> getHotelExecuteOredr(int hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店异常订单
	 */
	public List<OrderVO> getHotelUnusualOredr(int hotelID);
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店已撤销订单
	 */
	public List<OrderVO> getHotelCancelOrder(int hotelID);
	
	
	/**
	 * 
	 * @return 是否撤销订单成功
	 */
	public boolean cancelOrder(int orderID);
	
	/**
	 * 
	 * @return 是否创建订单成功
	 */
	public boolean createOrder(OrderVO order);
	
	/**
	 * 
	 * @return 是否将订单置为异常成功
	 */
	public boolean setOrderUnusual(int orderID);
	
	/**
	 * 
	 * @return 延迟入住，是否将异常订单置为撤销成功
	 */
	public boolean setOrderUnusualToCancel(int orderID);
	
	/**
	 * 
	 * @return 是否将异常订单置为已完成成功
	 */
	public boolean setOrderUnusualToExecute(int orderID);
	
	/**
	 * 
	 * @return 是否将订单置为已完成成功
	 */
	public boolean setOrderExecute(int orderID);
	

}

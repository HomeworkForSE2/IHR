package service;

import java.rmi.Remote;
import java.util.List;

import vo.OrderVO;

public abstract class OrderService implements Remote{
	
	/**
	 * 
	 * @param ID
	 * @return 所有订单
	 */
	public abstract List<OrderVO> getAllOrder();

	/**
	 * 
	 * @param ID
	 * @return 未执行订单
	 */
	public abstract List<OrderVO> getNotExecuteOredr();
	
	/**
	 * 
	 * @param ID
	 * @return 已经执行订单
	 */
	public abstract List<OrderVO> getExecuteOredr();
	
	
	/**
	 * 
	 * @param ID
	 * @return 异常订单
	 */
	public abstract List<OrderVO> getUnusualOredr();
	
	/**
	 * 
	 * @param ID
	 * @return 已经撤销订单
	 */
	public abstract List<OrderVO> getCancelOrder();
	
}

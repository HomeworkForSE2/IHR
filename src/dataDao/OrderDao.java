package dataDao;

import java.util.List;

import po.OrderPO;

public interface OrderDao {
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店订单列表
	 */
	public List<OrderPO> getHotelOrderList(int hotelID);
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public List<OrderPO> getUserOrderList(int userID);
	
	/**
	 * 
	 * @return
	 */
	public List<OrderPO> getAllOrderList();
	
	/**
	 * 
	 * @param orderID
	 * @return 订单信息
	 */
	public OrderPO getOrder(int orderID);
	
	/**
	 * 
	 * @param orderID
	 * @return
	 */
	public List<Integer> getRoomIDByOrder(int orderID);
	
	/**
	 * 
	 * @param order
	 * @return 是否添加订单成功
	 */
	public boolean addOrder(OrderPO order);
	
	/**
	 * 
	 * @param orderID
	 * @return 是否删除订单成功
	 */
	public boolean deleteOrder(int orderID);
	
	/**
	 * 
	 * @param order
	 * @return 是否更新订单信息成功
	 */
	public boolean updateOrder(OrderPO order);
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public List<Integer> resHotelIDList(int userID);

	/**
	 * 
	 * @return
	 */
	public int getOrderNum();
	
}

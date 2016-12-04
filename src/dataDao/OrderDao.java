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
	 * @return 用户订单列表
	 */
	public List<OrderPO> getUserOrderList(int userID);
	
	/**
	 * 
	 * @param orderID
	 * @return 订单信息
	 */
	public OrderPO getOrder(int orderID);
	/**
	 * 
	 * @param roomID
	 * @return 订单信息
	 */
	public OrderPO getOrderByRoomID(int roomID);
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
	
	public List<Integer> resHotelIDList(int userID);

}

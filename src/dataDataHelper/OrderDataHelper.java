package dataDataHelper;

import java.util.Map;

import po.OrderPO;

public interface OrderDataHelper {
	
	/**
	 * @return	从数据文件中读取订单数据
	 */
	public Map<Integer,OrderPO> getOrderData();
	
	/**
	 * 向数据文件中写入订单数据
	 * @param list	
	 */
	public void updateOrderData(Map<Integer,OrderPO> map);

}

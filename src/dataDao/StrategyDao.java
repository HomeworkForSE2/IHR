package dataDao;

import java.util.List;

import po.StrategyPO;
import po.VipPO;

public interface StrategyDao {
	
	/**
	 * 
	 * @param strategy
	 * @return 是否添加策略成功
	 */
	public boolean addStrategy(StrategyPO strategy);
	
	/**
	 * 
	 * @param hotelID
	 * @return 酒店策略列表
	 */
	public List<StrategyPO> findHotelStrategyList(int hotelID);
	
	/**
	 * 
	 * @return 网站策略列表
	 */
	public List<StrategyPO> findWebstrategyList();
	
	/**
	 * 
	 * @param vip
	 * @return 是否添加会员等级成功
	 */
	public boolean addVip(VipPO vip);

	public int getVipGrade(int credit);
}

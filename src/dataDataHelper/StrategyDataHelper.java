package dataDataHelper;

import java.util.List;
import java.util.Map;
import po.StrategyPO;
import po.VipPO;


public interface StrategyDataHelper {
	
	/**
	 * @return	从数据文件中读取策略数据
	 */
	public List< StrategyPO> getStrategyData();
	
	/**
	 * 向数据文件中写入策略数据
	 * @param map
	 */
	public void updateStrategyData(List<StrategyPO> list);
	
	/**
	 * 
	 * @return 从数据文件中读取vip数据
	 */
	public Map<Integer, VipPO> getVipData();
	
	/**
	 * 向数据文件中写入vip数据
	 * @param map
	 */
	public void updateVipData(Map<Integer, VipPO> map);

}

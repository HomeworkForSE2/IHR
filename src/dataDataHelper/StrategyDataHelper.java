package dataDataHelper;

import java.util.Map;
import po.StrategyPO;


public interface StrategyDataHelper {
	
	/**
	 * @return	从数据文件中读取策略数据
	 */
	public Map<Integer, StrategyPO> getStrategyData();
	
	/**
	 * 向数据文件中写入策略数据
	 * @param map
	 */
	public void updateStrategyData(Map<Integer, StrategyPO> map);

}

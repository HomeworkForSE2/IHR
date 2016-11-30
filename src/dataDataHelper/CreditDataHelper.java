package dataDataHelper;

import java.util.Map;

import po.CreditChangePO;

public interface CreditDataHelper {
	/**
	 * @return	从数据文件中读取信用记录数据
	 */
	public Map<Integer, CreditChangePO> getCreditData();
	
	/**
	 * 向数据文件中写入信用记录数据
	 * @param map
	 */
	public void updateCreditData(Map<Integer, CreditChangePO> map);

}

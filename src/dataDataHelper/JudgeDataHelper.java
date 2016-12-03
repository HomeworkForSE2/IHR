package dataDataHelper;



import java.util.List;

import po.JudgePO;


public interface JudgeDataHelper {
	/**
	 * @return	从数据文件中读取评价数据
	 */
	public List<JudgePO> getJudgeData();
	
	/**
	 * 向数据文件中写入评价数据
	 * @param map
	 */
	public void updateJudgeData(List<JudgePO> list);

}

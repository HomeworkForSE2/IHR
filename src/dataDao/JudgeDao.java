package dataDao;

import java.util.List;

import po.HotelPO;
import po.JudgePO;

public interface JudgeDao {
	
	
	/**
	 * 
	 * @param judeg
	 * @return 是否添加评价成功
	 */
	public boolean addJudge(JudgePO judeg);
	
	public List<Integer> judHotelIDList(int userID);
}

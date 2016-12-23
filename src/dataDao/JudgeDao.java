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
	
	/**
	 * 
	 * @param userID
	 * @return 用户已经评价的酒店列表
	 */
	public List<Integer> judgedHotelIDList(int userID);
}

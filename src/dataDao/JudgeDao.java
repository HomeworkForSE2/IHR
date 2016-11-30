package dataDao;

import java.util.List;

import po.HotelPO;
import po.JudgePO;

public interface JudgeDao {
	
	/**
	 * 
	 * @param userID
	 * @return 用户未评价酒店列表
	 */
	public List<HotelPO> findNotJudgedHotel(int userID);
	
	/**
	 * 
	 * @param judeg
	 * @return 是否添加评价成功
	 */
	public boolean addJudge(JudgePO judeg);
}

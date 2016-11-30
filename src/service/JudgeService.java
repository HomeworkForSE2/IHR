package service;

import java.util.List;

import vo.HotelInfoVO;

public interface JudgeService {
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public List<HotelInfoVO> viewNotJudgeHotelList(int userID);//和已经评价列表之间的关系
	
	/**
	 * 
	 * @param userId
	 * @param hotelId
	 * @param star
	 * @param evaluation
	 * @return 是否评论成功
	 */
	public boolean setJudge(int userId,int hotelId,int star,String evaluation);
	
	

}

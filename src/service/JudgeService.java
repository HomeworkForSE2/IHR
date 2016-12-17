package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.HotelInfoVO;

public interface JudgeService extends Remote{
	
	/**
	 * 
	 * @param userID
	 * @return 用户未评价酒店列表
	 */
	public List<HotelInfoVO> viewNotJudgeHotelList(int userID) throws RemoteException;//和已经评价列表之间的关系
	
	/**
	 * 
	 * @param userId
	 * @param hotelId
	 * @param star
	 * @param evaluation
	 * @return 是否评论成功
	 */
	public boolean setJudge(int userId,int hotelId,int star,String evaluation) throws RemoteException;
	
	

}

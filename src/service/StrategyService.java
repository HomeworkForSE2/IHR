package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import vo.StrategyVO;

public interface StrategyService extends Remote{
	

	/**
	 * 
	 * @param strategy
	 * @return 是否制定特殊时期策略成功
	 */
	public boolean setSpecialTimeByHotel(StrategyVO strategy)throws RemoteException;
	
	/**
	 * 
	 * @param StrategyVO
	 * @param roomNum
	 * @return 是否制定预订房间数策略成功
	 */
	public boolean setResRoomNumByHotel(StrategyVO strategy ,int roomNum)throws RemoteException;
	
	/**
	 * 
	 * @param StrategyVO	
	 * @return 是否制定特殊时期策略（网站）成功
	 */
	public boolean setSpecialTimeByWeb(StrategyVO strategy)throws RemoteException;
	
	/**
	 * 
	 * @param StrategyVO
	 * @return 是否制定生日策略成功
	 */
	public boolean setBirthdayByHotel(StrategyVO strategy)throws RemoteException;
	
	/**
	 * 
	 * @param StrategyVO
	 * @param String
	 * @return 是否制定合作企业策略成功
	 */
	public boolean setEnterpriseByHotel(StrategyVO strategy,String enterpriseName)throws RemoteException;
	
	/**
	 * 
	 * @param StrategyVO
	 * @param vipGrade
	 * @param BD
	 * @return 是否制定会员相关策略成功
	 */
	public boolean setForVip(StrategyVO strategy,String BD,int vipGrade)throws RemoteException;
	
	/**
	 * 
	 * @param vipGrade
	 * @param credit
	 * @return 是否制定会员等级成功
	 */
	public boolean setVipGrade(int vipGrade,int credit)throws RemoteException;
	
	/**
	 * 
	 * @param hotelName
	 * @return 酒店策略列表
	 */
	public List<StrategyVO> viewHotelStrategyList(int hotelID)throws RemoteException;
	
	/**
	 * 
	 * @return 网站策略列表
	 */
	public List<StrategyVO> viewWebStrategyList()throws RemoteException;
	
	/**
	 * 
	 * @param vo
	 * @return 订单最低价格
	 */
	public double calcute(int userID,int hotelID,double price,int roomNum)throws RemoteException;
	
	
	
	

}

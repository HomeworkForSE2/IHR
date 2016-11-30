package service;

import java.util.List;

import vo.OrderVO;
import vo.StrategyVO;

public interface StrategyService {
	

	/**
	 * 
	 * @param strategy
	 * @return 是否制定特殊时期策略成功
	 */
	public boolean setSpecialTimeByHotel(StrategyVO strategy);
	
	/**
	 * 
	 * @param StrategyVO
	 * @param roomNum
	 * @return 是否制定预订房间数策略成功
	 */
	public boolean setResRoomNumByHotel(StrategyVO strategy ,int roomNum);
	
	/**
	 * 
	 * @param StrategyVO	
	 * @return 是否制定特殊时期策略（网站）成功
	 */
	public boolean setSpecialTimeByWeb(StrategyVO strategy);
	
	/**
	 * 
	 * @param StrategyVO
	 * @return 是否制定生日策略成功
	 */
	public boolean setBirthdayByHotel(StrategyVO strategy);
	
	/**
	 * 
	 * @param StrategyVO
	 * @param String
	 * @return 是否制定合作企业策略成功
	 */
	public boolean setEnterpriseByHotel(StrategyVO strategy,String enterpriseName);
	
	/**
	 * 
	 * @param StrategyVO
	 * @param vipGrade
	 * @param BD
	 * @return 是否制定会员相关策略成功
	 */
	public boolean setForVip(StrategyVO strategy,int vipGrade,String BD);
	
	/**
	 * 
	 * @param vipGrade
	 * @param credit
	 * @return 是否制定会员等级成功
	 */
	public boolean setVipGrade(int vipGrade,int credit);
	
	/**
	 * 
	 * @param hotelName
	 * @return 酒店策略列表
	 */
	public List<StrategyVO> viewHotelStrategyList(String hotelName);
	
	/**
	 * 
	 * @return 网站策略列表
	 */
	public List<StrategyVO> viewWebStrategyList();
	
	/**
	 * 
	 * @param vo
	 * @return 订单最低价格
	 */
	public int calcute(OrderVO vo);
	
	
	
	

}

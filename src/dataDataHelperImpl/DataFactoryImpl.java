package dataDataHelperImpl;

import dataDataHelper.CreditDataHelper;
import dataDataHelper.DataFactory;
import dataDataHelper.HotelDataHelper;
import dataDataHelper.JudgeDataHelper;
import dataDataHelper.MemberDataHelper;
import dataDataHelper.OrderDataHelper;
import dataDataHelper.RoomDataHelper;
import dataDataHelper.StrategyDataHelper;
import dataDataHelper.UserDataHelper;

public class DataFactoryImpl implements DataFactory{

	@Override
	public UserDataHelper getUserDataHelper() {
		// TODO Auto-generated method stub
		UserDataHelper userDao=new UserDataTxtHelper();
		return userDao;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		// TODO Auto-generated method stub
		HotelDataHelper hotelDao=new HotelDataTxtHelper();
		return hotelDao;
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		// TODO Auto-generated method stub
		RoomDataHelper roomDao=new RoomDataTxtHelper();
		return roomDao;
	}

	@Override
	public CreditDataHelper getCreditDataHelper() {
		// TODO Auto-generated method stub
		CreditDataHelper creditDao=new CreditDataTxtHelper();
		return creditDao;
	}

	@Override
	public StrategyDataHelper getStrategyDataHelper() {
		// TODO Auto-generated method stub
		StrategyDataHelper strategyDao=new StrategyDataTxtHelper();
		return strategyDao;
	}

	@Override
	public MemberDataHelper getMemberDataHelper() {
		// TODO Auto-generated method stub
		MemberDataHelper memberDao=new MemberDataTxtHelper();
		return memberDao;
	}

	@Override
	public JudgeDataHelper getJudgeDataHelper() {
		// TODO Auto-generated method stub
		JudgeDataHelper judgeDao=new JudgeDataTxtHelper(); 
		return judgeDao;
	}

	@Override
	public OrderDataHelper getOrderDataHelper() {
		// TODO Auto-generated method stub
		OrderDataHelper orderDao=new OrderDataTxtHelper();
		return orderDao;
	}

}

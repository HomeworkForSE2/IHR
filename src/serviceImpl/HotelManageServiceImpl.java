package serviceImpl;

import dataDao.HotelManageDao;
import dataDaoImpl.HotelDaoImpl;
import po.HotelPO;
import po.HotelWorkerPO;
import service.HotelManageService;
import vo.HotelInfoVO;
import vo.UserInfoVO;

public class HotelManageServiceImpl implements HotelManageService{

	private HotelManageDao hotelManageDao;
	
	private int hotelNum;//酒店ID从1开始，web为0,酒店工作人员ID从1开始保持和酒店一致，普通用户从10000开始，网站营销人员从1000000开始
	 
	public HotelManageServiceImpl() {
		hotelManageDao=HotelDaoImpl.getInstance();
		hotelNum=hotelManageDao.getHotelNum()+1;
	}
	
	//界面实现的时候，通过名字等基本信息添加酒店，紧接着为其添加酒店工作人员
	@Override
	public boolean addHotel(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		HotelPO h=new HotelPO(hotelNum, hotel.getHotelName(), hotel.getLocation(), hotel.getBD(), hotel.getStarNum(), hotel.getIntroduction(), hotel.getDevice(), 0);
		return hotelManageDao.addHotel(h);
	}

	//采用不重名添加，感觉有问题
	@Override
	public boolean addHotelworker(UserInfoVO vo) {
		// TODO Auto-generated method stub
		HotelWorkerPO hw=new HotelWorkerPO(hotelNum, vo.getUserName(), vo.getPassword(), vo.getPhoneNumber(), 0);
		boolean result=hotelManageDao.addHotelWorker(hw);
		if(result){
			hotelNum++;
		}
		return result;
	}

}

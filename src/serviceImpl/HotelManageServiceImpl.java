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
	
	public HotelManageServiceImpl() {
		hotelManageDao=HotelDaoImpl.getInstance();
	}
	
	@Override
	public boolean addHotel(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		HotelPO h=new HotelPO(0, hotel.getHotelName(), hotel.getLocation(), hotel.getBD(), hotel.getStarNum(), hotel.getIntroduction(), hotel.getDevice(), 0);
		return hotelManageDao.addHotel(h);
	}

	@Override
	public boolean addHotelworker(UserInfoVO vo) {
		// TODO Auto-generated method stub
		HotelWorkerPO hw=new HotelWorkerPO(vo.getUserID(), vo.getUserName(), vo.getPassword(), vo.getPhoneNumber(), 0);
		return hotelManageDao.addHotelWorker(hw);
	}

}

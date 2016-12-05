package serviceImpl;

import dataDao.HotelDao;
import dataDaoImpl.HotelDaoImpl;
import po.HotelPO;
import service.HotelInfoService;
import vo.HotelInfoVO;

public class HotelInfoServiceImpl implements HotelInfoService{

	private HotelDao hotelDao;
	//是否应该持有酒店ID
	public HotelInfoServiceImpl(){
		hotelDao=HotelDaoImpl.getInstance();
	}
	
	
	@Override
	public boolean maintainHotelInfo(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		int hotelID=hotel.getHotelID();
		HotelPO h=hotelDao.findHotel(hotelID);
		h.setHotelName(hotel.getHotelName());
		h.setLocation(hotel.getLocation());
		h.setBD(hotel.getBD());
		h.setStarNum(hotel.getStarNum());
		h.setIntroduction(hotel.getIntroduction());
		h.setDevice(hotel.getDevice());
		return hotelDao.updateHotel(h);
	}

	@Override
	public HotelInfoVO findHotel(int hotelID) {
		// TODO Auto-generated method stub
		HotelPO hotel=hotelDao.findHotel(hotelID);
		return new HotelInfoVO(hotel);
	}

}

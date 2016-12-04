package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dataDao.HotelBrowseDao;
import dataDaoImpl.HotelDaoImpl;
import po.HotelPO;
import service.HotelBrowseService;
import vo.HotelInfoVO;

public class HotelBrowseServiceImpl implements HotelBrowseService{

	private HotelBrowseDao hotelBrowseDao;
	
	public HotelBrowseServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelBrowseDao=HotelDaoImpl.getInstance();
	}
	@Override
	public HotelInfoVO searchHotel(String hotelName) {
		// TODO Auto-generated method stub
		HotelPO hotel=hotelBrowseDao.searchHotel(hotelName);
		return new HotelInfoVO(hotel);
	}

	@Override
	public List<HotelInfoVO> viewHotelList(String location, String BD, int roomType, int star, int judgeScore) {
		// TODO Auto-generated method stub
		List<HotelInfoVO> hotelList=new ArrayList<>();
		List<HotelPO> AllHotelList=hotelBrowseDao.searchHotelList(location, BD);
		return hotelList;
	}

}

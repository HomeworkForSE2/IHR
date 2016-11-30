package dataDaoImpl;

import java.util.List;
import java.util.Map;

import dataDao.HotelBrowseDao;
import dataDao.HotelDao;
import dataDao.HotelManageDao;
import dataDataHelper.DataFactory;
import dataDataHelper.HotelDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.HotelPO;
import po.HotelWorkerPO;

public class HotelDaoImpl implements HotelDao ,HotelBrowseDao,HotelManageDao   {

	private Map<Integer,HotelPO> map;
	
	private HotelDataHelper hotelDataHelper;
	
	private DataFactory dataFactory;

	private static HotelDaoImpl hotelDataServiceImpl;
	
	private static HotelDaoImpl getInstance(){
		if(hotelDataServiceImpl==null){
			hotelDataServiceImpl=new HotelDaoImpl();
		}
		return hotelDataServiceImpl;
	}
	
	public HotelDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			hotelDataHelper=dataFactory.getHotelDataHelper();
			map=hotelDataHelper.getHotelData();
		}
	}
	@Override
	public boolean update(HotelPO hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotel(HotelPO hotel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotelWorker(int hotelID, HotelWorkerPO hotelWorker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotelPO findHotel(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelPO> findHotelList(String location, String BD, int roomType, int star, int judgeScore) {
		// TODO Auto-generated method stub
		return null;
	}

}

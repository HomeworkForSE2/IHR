package dataDaoImpl;

import java.util.Iterator;
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
	
	public static HotelDaoImpl getInstance(){
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
	public HotelPO findHotel(int hotelID) {
		// TODO Auto-generated method stub
		return map.get(hotelID);
	}
	
	@Override
	public boolean updateHotel(HotelPO hotel) {
		// TODO Auto-generated method stub
		int hotelID=hotel.getHotelID();
		if(map.get(hotelID)!=null){
			map.put(hotelID, hotel);
			hotelDataHelper.updateHotelData(map);
			return true;
		}
		return false;
	}

	@Override
	public boolean addHotel(HotelPO hotel) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,HotelPO>> it=map.entrySet().iterator();
		String hotelName=hotel.getHotelName();
		while(it.hasNext()){
			Map.Entry<Integer,HotelPO> entry=it.next();
			HotelPO hotelHelp=entry.getValue();
			if(hotelHelp.getHotelName().equals(hotelName)){
				return false;
			}
		}
		map.put(hotel.getHotelID(), hotel);
		hotelDataHelper.updateHotelData(map);		
		return true;
	}

	@Override
	public boolean addHotelWorker(HotelWorkerPO hotelWorker) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getInstance().addWebsiteWorker(hotelWorker);
	}

	@Override
	public HotelPO searchHotel(String hotelName) {
		// TODO Auto-generated method stub
		Iterator<Map.Entry<Integer,HotelPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer,HotelPO> entry=it.next();
			HotelPO hotel=entry.getValue();
			if(hotel.getHotelName().equals(hotelName)){
				return hotel;
			}
		}
		return null;
	}

	@Override
	public List<HotelPO> searchHotelList(String location, String BD, int roomType, int star, int judgeScore) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

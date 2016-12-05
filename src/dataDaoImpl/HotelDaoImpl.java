package dataDaoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthStyle;

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
	public List<HotelPO> searchHotelList(String location, String BD) {
		// TODO Auto-generated method stub
		List<HotelPO> hotelList=new ArrayList<HotelPO>();
		Iterator <Map.Entry<Integer, HotelPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, HotelPO> entry=it.next();
			HotelPO hotel=entry.getValue();
			if(hotel.getBD().equals(BD)&&hotel.getLocation().equals(location)){
				hotelList.add(hotel);
			}
		}
		return hotelList;
	}
	
	@Override
	public List<HotelPO> findNotJudgedHotel(int userID) {
		// TODO Auto-generated method stub
		List<HotelPO> l=new ArrayList<>();
		List<Integer> l1=OrderDaoImpl.getInstance().resHotelIDList(userID);
		List<Integer> l2=JudgeDaoImpl.getInstance().judgedHotelIDList(userID);
		Iterator it=l1.iterator();
		while(it.hasNext()){
			int help=(int)it.next();
			if(l2.contains(help)){
				
			}else{
				l.add(map.get(help));
			}
		}
		return l;
	}
	
	@Override
	public List<HotelPO> findResHotel(int userID) {
		// TODO Auto-generated method stub
		List<HotelPO> l=new ArrayList<>();
		List<Integer> l1=OrderDaoImpl.getInstance().resHotelIDList(userID);
		Iterator it=l1.iterator();
		while(it.hasNext()){
			int help=(int)it.next();
			l.add(map.get(help));
			
		}
		return l;
	}
	
	@Override
	public int getHotelNum() {
		// TODO Auto-generated method stub
		return map.size();
	}
	
	public static void main(String[] args) {
		HotelDaoImpl go=new HotelDaoImpl();
		go.test2();
	}
	
	public void  test1(){
		System.out.println(findHotel(100001).getBD());
		System.out.println(searchHotel("格林豪泰").getBD());
		HotelPO h=new HotelPO(4, "pipa", "1", "2", 5, "1", "2", 2);
		System.out.println(addHotel(h));
		h=new HotelPO(3, "pipa", "1", "2", 5, "1", "2", 2);
		System.out.println(addHotel(h));
		System.out.println(updateHotel(new HotelPO(4, "pipa", "1", "2", 5, "1", "3", 2)) );
		System.out.println(searchHotelList("仙林","南大和园").size());
	}

	public void test2(){
		List l1=findNotJudgedHotel(0);
		System.out.println(l1.size());
		List l2=findNotJudgedHotel(1);
		System.out.println(l2.size());	
		List l3=findNotJudgedHotel(2);
		System.out.println(l3.size());
		List l4=findNotJudgedHotel(3);
		System.out.println(l4.size());
		
	}

	

	
	
}

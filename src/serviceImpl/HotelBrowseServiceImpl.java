package serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataDao.HotelBrowseDao;
import dataDao.RoomDao;
import dataDaoImpl.HotelDaoImpl;
import dataDaoImpl.RoomDaoImpl;
import po.HotelPO;
import service.HotelBrowseService;
import vo.HotelInfoVO;
import vo.RoomConditionVO;

public class HotelBrowseServiceImpl implements HotelBrowseService{
	
	
	private HotelBrowseDao hotelBrowseDao;
	
	private RoomDao roomDao;
	
	public HotelBrowseServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelBrowseDao=HotelDaoImpl.getInstance();
		roomDao=RoomDaoImpl.getInstance();
	}
	
	@Override
	public HotelInfoVO searchHotel(String hotelName) {
		// TODO Auto-generated method stub
		HotelPO hotel=hotelBrowseDao.searchHotel(hotelName);
		if(hotel==null){
			return null;
		}
		return new HotelInfoVO(hotel);
	}

	//按条件搜索酒店，条件可以同时亦可以独立，简版（差时间逻辑）
	@Override
	public List<HotelInfoVO> viewHotelList(String location, String BD, RoomConditionVO condition, int star, int judgeScore) {
		// TODO Auto-generated method stub
		List<HotelInfoVO> hotelList=new ArrayList<>();
		List<HotelPO> AllHotelList=hotelBrowseDao.searchHotelList(location, BD);
		
		
		Iterator it=AllHotelList.iterator();
		while(it.hasNext()){
			HotelPO hotel=(HotelPO)it.next();
			if(((hotel.getStarNum()==star)||star==0)&&((hotel.getScore()==judgeScore)||judgeScore==0)){
				hotelList.add(new HotelInfoVO(hotel));
			}
		}
		
		//再用room条件去筛选一遍
		if(condition!=null){
			List<Integer> l=roomDao.suitableHotelIDList(condition.getRoomType(), condition.getPrice(), condition.getRoomNum());
			Iterator ite=hotelList.iterator();
			while(ite.hasNext()){
				HotelInfoVO hv=(HotelInfoVO)it.next();
				if(!l.contains(hv.getHotelID())){
					hotelList.remove(hv);
				}
			}
		}
		
		//时间上再根据roomID去查orderList看时间
		return hotelList;
	}
	
	@Override
	public List<HotelInfoVO> showReservedHotel(int userID) {
		// TODO Auto-generated method stub
		List<HotelPO> list=hotelBrowseDao.findResHotel(userID);
		List<HotelInfoVO> hotelList=new ArrayList<>();
		Iterator it=list.iterator();
		while(it.hasNext()){
			HotelInfoVO hotel=new HotelInfoVO((HotelPO)it.next());
			hotelList.add(hotel);
		}
		return hotelList;
	}

}

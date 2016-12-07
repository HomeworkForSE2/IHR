package dataDaoImpl;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


import dataDao.RoomDao;
import dataDataHelper.DataFactory;
import dataDataHelper.RoomDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.OrderPO;
import po.RoomPO;

public class RoomDaoImpl implements RoomDao {
	private Map<Integer,RoomPO> map;
	
	private RoomDataHelper roomDataHelper;
	
	private DataFactory dataFactory;

	private static RoomDaoImpl roomDataServiceImpl;
	
	public static RoomDaoImpl getInstance(){
		if(roomDataServiceImpl==null){
			roomDataServiceImpl=new RoomDaoImpl();
		}
		return roomDataServiceImpl;
	}
	
	public RoomDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			roomDataHelper=dataFactory.getRoomDataHelper();
			map=roomDataHelper.getRoomData();
		}
	}

	@Override
	public boolean addRoom(RoomPO room) {
		// TODO Auto-generated method stub
		int roomID=room.getRoomID();
		map.put(roomID, room);
		roomDataHelper.updateRoomData(map);
		return true;
	}
	
	@Override
	//这里的更新是指改变已有房间的属性,传参是roomPO
	public boolean updateRoom(RoomPO room) {
		// TODO Auto-generated method stub
		int roomID=room.getRoomID();
		if(map.get(roomID)!=null){
			map.put(roomID, room);
			roomDataHelper.updateRoomData(map);
			return true;
		}
		
		return false;
	}
	
	//根据roomID获得roomPO
	public  RoomPO getRoom(int roomID){
		return map.get(roomID);
	}
	
	@Override
	public List<Integer> suitableHotelIDList(int roomType,int price,int roomNum) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		List<Integer> hotelIDList=new ArrayList<Integer>();
		Iterator<Map.Entry<Integer,RoomPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			RoomPO room=(RoomPO)it.next();
			if(room.isState()==false&&room.getPrice()<=price&&room.getRoomType()==roomType){
				list.add(room.getHotelID());
			}
		}
		
		int count=0;
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if(list.get(i)==list.get(j)){
					count++;
				}
			}
			if(count>=roomNum&&!hotelIDList.contains(list.get(i))){
				hotelIDList.add(list.get(i));
			}
			count=0;
		}
		return hotelIDList;
	}

	@Override
	public int getRoomNum() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public List<RoomPO> getAllRoom(int hotelID) {
		// TODO Auto-generated method stub
		List<RoomPO> list=new ArrayList<>();
		Iterator<Map.Entry<Integer,RoomPO>> it=map.entrySet().iterator();
		while(it.hasNext()){
			RoomPO room=(RoomPO)it.next();
			list.add(room);
		}
		return list;
	}

}

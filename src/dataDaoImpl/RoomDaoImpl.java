package dataDaoImpl;

import java.util.Map;

import dataDao.RoomDao;
import dataDataHelper.DataFactory;
import dataDataHelper.RoomDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
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
		int roomID=map.size();
		map.put(roomID, room);
		roomDataHelper.updateRoomData(map);
		return true;
	}

	@Override
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

}

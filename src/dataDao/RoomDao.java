package dataDao;

import java.util.List;

import po.RoomPO;

public interface RoomDao {
	
	/**
	 * 
	 * @param room
	 * @return 是否添加房间成功
	 */
	public boolean addRoom(RoomPO room);
	
	/**
	 * 
	 * @param room
	 * @return 是否更新房间成功
	 */
	public boolean updateRoom(RoomPO room);
	/**
	 * 
	 * 
	 * @return 获得房间的ID
	 */
	public  int getRoomID();
	/**
	 * 
	 * @param roomID
	 * @return 获得roomPO
	 */
	public  RoomPO getRoomPO(int roomID);

	public List<Integer> suitableHotelIDList(int roomType, int price, int roomNum);
}
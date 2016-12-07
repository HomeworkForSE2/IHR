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
	 * @param roomID
	 * @return
	 */
	public  RoomPO getRoom(int roomID);
	
	/**
	 * 
	 * @return
	 */
	public int getRoomNum();

	/**
	 * 
	 * @param hotelID
	 * @return
	 */
	public List<RoomPO> getAllRoom(int hotelID);
	
	/**
	 * 
	 * @param roomType
	 * @param price
	 * @param roomNum
	 * @return
	 */
	public List<Integer> suitableHotelIDList(int roomType, int price, int roomNum);
}
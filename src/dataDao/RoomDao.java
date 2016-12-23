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
	 * @return 房间信息
	 */
	public  RoomPO getRoom(int roomID);
	
	/**
	 * 
	 * @return 房间总数量
	 */
	public int getRoomNum();

	/**
	 * 
	 * @param hotelID
	 * @return 酒店房间信息列表
	 */
	public List<RoomPO> getAllRoom(int hotelID);
	
	/**
	 * 
	 * @param roomType
	 * @param price
	 * @param roomNum
	 * @return 符合房间条件的酒店ID列表
	 */
	public List<Integer> suitableHotelIDList(int roomType, int price, int roomNum);
}
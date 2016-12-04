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
	 * @return
	 */
	public List<Integer> suitableHotelIDList(int roomType,int price,int roomNum);
}

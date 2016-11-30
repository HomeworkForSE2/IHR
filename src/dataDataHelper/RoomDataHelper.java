package dataDataHelper;

import java.util.Map;

import po.RoomPO;


public interface RoomDataHelper {

	/**
	 * @return	从数据文件中读取房间数据
	 */
	public Map<Integer, RoomPO> getRoomData();
	
	/**
	 * 向数据文件中写入房间数据
	 * @param map
	 */
	public void updateRoomData(Map<Integer, RoomPO> map);
}

package service;

import java.rmi.Remote;
//substian
public interface RoomService extends Remote{
	/**
	 * 
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @return 鏄惁鍒涘缓鎴块棿鎴愬姛
	 */
	public boolean creatRoom(int hotelID,int roomType,int roomNum,int price);
	
	/**
	 * 
	 * @param roomID
	 * @param startTime
	 * @param endTime
	 * @return 鏄惁鏇存柊鎴块棿淇℃伅锛堝叆浣忥級鎴愬姛
	 */
	public boolean checkInRoom(int roomID,String startTime,String endTime);
	
	/**
	 * 
	 * @param roomID
	 * @param finshTime
	 * @return 鏄惁鏇存柊鎴块棿淇℃伅锛堥��鎴匡級鎴愬姛
	 */
	public boolean checkOutRoom(int roomID,String finshTime);

}

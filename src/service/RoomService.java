package service;

import java.rmi.Remote;

public interface RoomService extends Remote{
	/**
	 * 
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @return 是否创建房间成功
	 */
	public boolean creatRoom(int hotelID,int roomType,boolean state);
	/**
	 * 
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @return 初始化房间的价格（根据房间类型）
	 */
	public boolean initialRoomPrice(int hotelID,int roomType,int roomNum,int price);
	/**
	 * 
	 * @param roomID
	 * @param startTime
	 * @param endTime
	 * @return 是否更新房间信息（入住）成功
	 */
	public boolean checkInRoom(int roomID,String startTime,String endTime);
	
	/**
	 * 
	 * @param roomID
	 * @param finshTime
	 * @return 是否更新房间信息（退房）成功
	 */
	public boolean checkOutRoom(int roomID,String finshTime);

}

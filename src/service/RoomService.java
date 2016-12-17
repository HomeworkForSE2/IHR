package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoomService extends Remote{
	/**
	 * 
	 * @param roomType
	 * @param roomNum
	 * @param price
	 * @return 是否创建房间成功
	 */
	public boolean creatRoom(int hotelID,int roomType,int roomNum,double price)throws RemoteException;
	/**
	 * 
	 * @param roomID
	 * @param startTime
	 * @param endTime
	 * @return 是否更新房间信息（入住）成功
	 */
	public boolean checkInRoom(int roomID)throws RemoteException;
	
	/**
	 * 
	 * @param roomID
	 * @param finshTime
	 * @return 是否更新房间信息（退房）成功
	 */
	public boolean checkOutRoom(int roomID)throws RemoteException;

}

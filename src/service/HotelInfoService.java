package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.HotelInfoVO;

public interface HotelInfoService extends Remote{
	
	/**
	 * 
	 * @param hotel
	 * @return 是否维护酒店信息成功
	 */
	public boolean maintainHotelInfo(HotelInfoVO hotel) throws RemoteException;

	/**
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelInfoVO findHotel(int hotelID) throws RemoteException;
}

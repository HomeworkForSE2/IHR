package serviceImpl;

import java.awt.List;

import dataDao.OrderDao;
import dataDao.RoomDao;
import dataDaoImpl.OrderDaoImpl;
import dataDaoImpl.RoomDaoImpl;
import po.OrderPO;
import po.RoomPO;
import service.RoomService;

public class RoomServiceImpl implements RoomService{
		private RoomDao roomDao;
		
		
		public RoomServiceImpl(){
			roomDao=RoomDaoImpl.getInstance();
			
		}
	@Override
	public boolean creatRoom(int hotelID, int roomType, boolean state, int price) {
		// TODO Auto-generated method stub
		int roomID=roomDao.getRoomID();
		RoomPO roomPO=new RoomPO(hotelID, roomType, roomID,  price,  state);
		return roomDao.addRoom(roomPO);
	}

	@Override
	public boolean checkInRoom(int roomID, String startTime, String endTime) {
		// TODO Auto-generated method stub
		RoomPO room=roomDao.getRoomPO(roomID);
		room.setState(true);
		OrderDao orderDao=OrderDaoImpl.getInstance();
		OrderPO order=orderDao.getOrderByRoomID(roomID);
		order.setStartTime(startTime);
		order.setEndTime(endTime);
		return orderDao.updateOrder(order);
	}

	@Override
	public boolean checkOutRoom(int roomID, String finshTime) {
		// TODO Auto-generated method stub
		RoomPO room=roomDao.getRoomPO(roomID);
		room.setState(false);
		OrderDao orderDao=OrderDaoImpl.getInstance();
		OrderPO order=orderDao.getOrderByRoomID(roomID);
		order.setFinishTime(finshTime);
		return orderDao.updateOrder(order);
	}

}

package serviceImpl;

import dataDao.OrderDao;
import dataDao.RoomDao;
import dataDaoImpl.OrderDaoImpl;
import dataDaoImpl.RoomDaoImpl;
import po.OrderPO;
import po.RoomPO;
import service.RoomService;

public class RoomServiceImpl implements RoomService{
	
	private RoomDao roomDao;
		
	private OrderDao orderDao;
		
	private int roomNum;//这个在初始化时，通过调用dao层来获得
		
	public RoomServiceImpl(){
		roomDao=RoomDaoImpl.getInstance();
		orderDao=OrderDaoImpl.getInstance();
		roomNum=roomDao.getRoomNum()+1;
	}
	
	/*
	 * 这个方法为创建房间方法，可以用来初始化，也可以后来添加房间
	 * 具体实现为已roomNum循环创建，对应酒店ID、房间类型和价格的roomPO，并调用dao层的add方法	
	 */
	@Override
	public boolean creatRoom(int hotelID, int roomType, int roomNum,double price) {
		// TODO Auto-generated method stub
		for(int i=0;i<roomNum;i++){
			RoomPO room=new RoomPO(this.roomNum, hotelID,roomType, price, false);
			roomDao.addRoom(room);
			this.roomNum++;
		}
		return true;
	}
	
	/*
	 * 更新入住
	 */
	@Override
	public boolean checkInRoom(int roomID) {
		// TODO Auto-generated method stub
		RoomPO room=roomDao.getRoom(roomID);
		room.setState(true);
		return roomDao.updateRoom(room);
	}

	/*
	 * 更新退房
	 */
	@Override
	public boolean checkOutRoom(int roomID) {
		// TODO Auto-generated method stub
		RoomPO room=roomDao.getRoom(roomID);
		room.setState(false);
		return roomDao.updateRoom(room);
	}

}

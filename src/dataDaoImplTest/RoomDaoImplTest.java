package dataDaoImplTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dataDaoImpl.RoomDaoImpl;
import po.RoomPO;

public class RoomDaoImplTest {
	public static RoomDaoImpl roomDao=new RoomDaoImpl();
	public static RoomPO roomPO=new RoomPO(19,2,2,200,true);
	public static RoomPO roomPO2=new RoomPO(19,2,2,200,false);
	public static RoomPO roomPO3=new RoomPO(20,3,2,200,false);
	public static RoomPO roomPO4=new RoomPO(21,3,2,200,true);
	
	public static RoomPO roomPO5=new RoomPO(10,5,1,350,false);
	public static RoomPO roomPO6=new RoomPO(11,5,2,700,true);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddRoom() {
		roomDao.addRoom(roomPO);
		roomDao.addRoom(roomPO3);
		roomDao.addRoom(roomPO4);
		
	}

	@Test
	public void testUpdateRoom() {
		roomDao.updateRoom(roomPO2);
	}

	@Test
	public void testGetRoom() {
		assertEquals(roomPO2,roomDao.getRoom(19));
	}

	@Test
	public void testSuitableHotelIDList() {
		List<Integer> temp=new ArrayList<Integer>();
		temp.add(2);
		temp.add(3);
		assertEquals(temp,roomDao.suitableHotelIDList(2, 200, 1));
	}

	@Test
	public void testGetRoomNum() {
		assertEquals(21,roomDao.getRoomNum());
	}
	@Test
	public void testGetAllRoom() {
		List<RoomPO> temp=roomDao.getAllRoom(5);
		assertEquals(10,temp.get(0).getRoomID());
		}

}

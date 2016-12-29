package serviceImplTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.RoomServiceImpl;

public class RoomServiceImplTest {
	RoomServiceImpl room=new RoomServiceImpl();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreatRoom() {
		room.creatRoom(7, 2, 2, 200);
	}

	@Test
	public void testCheckInRoom() {
		room.checkInRoom(21);
	}

	@Test
	public void testCheckOutRoom() {
		room.checkOutRoom(21);
	}

	@Test
	public void testGetRoomListInThisHotel() {
		assertEquals(10,room.getRoomListInThisHotel(5).get(0).getRoomID());
		assertEquals(11,room.getRoomListInThisHotel(5).get(1).getRoomID());
	}

}

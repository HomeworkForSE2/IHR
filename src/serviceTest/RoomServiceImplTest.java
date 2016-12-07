package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.RoomServiceImpl;

public class RoomServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreatRoom() {
		RoomServiceImpl test=new RoomServiceImpl();
		test.creatRoom(1, 1, 3, 300);
		test.creatRoom(1, 2, 4, 400);
		test.creatRoom(1, 3, 2, 600);
		test.creatRoom(2, 1, 2, 350);
		
	}

	@Test
	public void testCheckInRoom() {
		RoomServiceImpl test=new RoomServiceImpl();
		test.checkInRoom(1);
		test.checkInRoom(2);
		test.checkInRoom(3);
		test.checkInRoom(6);
		test.checkInRoom(7);
		test.checkInRoom(8);
	}

	@Test
	public void testCheckOutRoom() {
		RoomServiceImpl test=new RoomServiceImpl();
		test.checkOutRoom(1);
		test.checkOutRoom(2);
		test.checkOutRoom(3);
		test.checkOutRoom(6);
		test.checkOutRoom(7);
		test.checkOutRoom(8);
		
	}

}

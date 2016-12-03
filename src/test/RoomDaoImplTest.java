package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataDaoImpl.RoomDaoImpl;
import po.RoomPO;

public class RoomDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testAddRoom() {
		RoomPO room=new RoomPO(1,2,79,100,false);
		RoomDaoImpl test=new RoomDaoImpl();
		test.addRoom(room);
	}

	@Test
	public void testUpdateRoom() {
		RoomPO room=new RoomPO(1,2,79,100,true);
		RoomDaoImpl test=new RoomDaoImpl();
		test.addRoom(room);
	}

}

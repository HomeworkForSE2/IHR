package dataTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataDaoImpl.RoomDaoImpl;
import po.RoomPO;
//没问题
public class RoomDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}
	@Test
	//79、80号房间,都是一号酒店
	public void testAddRoom() {
		RoomPO room=new RoomPO(1,2,79,100,false);
		RoomPO room2=new RoomPO(1,2,80,100,false);
		RoomDaoImpl test=new RoomDaoImpl();
		test.addRoom(room);
		test.addRoom(room2);
	}

	@Test
	//更新79号房间为已使用,
	public void testUpdateRoom() {
		RoomPO room=new RoomPO(1,2,79,100,true);
		RoomDaoImpl test=new RoomDaoImpl();
		test.updateRoom(room);
	}

}

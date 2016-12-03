package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dataDataHelperImpl.RoomDataTxtHelper;
import po.OrderPO;
import po.RoomPO;

public class RoomDataTxtHelperTest {

	@Before
	public void setUp() throws Exception {
	}
   @Test
	public void testUpdateRoomData() {
	    RoomDataTxtHelper test=new RoomDataTxtHelper();
	    RoomPO room=new RoomPO(0003,2,0001,100,false);
   		Map<Integer,RoomPO> map=new HashMap<Integer,RoomPO>();
   		map.put(0001,room);
   		test.updateRoomData(map);
	}
	@Test
	public void testGetRoomData() {
		RoomDataTxtHelper test=new RoomDataTxtHelper();
		RoomPO room=test.getRoomData().get(0001);
		String str=room.getHotelID()+";"+room.getRoomType()+";"+room.getRoomID()+";"+room.getPrice()+";"+room.isState();
		assertEquals("3;2;1;100.0;false",str);
	}

	

}

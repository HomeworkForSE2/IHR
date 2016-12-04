package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import dataDataHelperImpl.RoomDataTxtHelper;
import po.OrderPO;
import po.RoomPO;
//测试没问题
public class RoomDataTxtHelperTest {

	@Before
	public void setUp() throws Exception {
	}
   @Test
   //更新33，23号房间，三号酒店
	public void testUpdateRoomData() {
	    RoomDataTxtHelper test=new RoomDataTxtHelper();
	    
	    RoomPO room2=new RoomPO(0003,2,23,100,false);
	    RoomPO room=new RoomPO(0003,2,33,100,false);
   		Map<Integer,RoomPO> map=new HashMap<Integer,RoomPO>();
   		map.put(23, room2);
   		map.put(33,room);
   		
   		test.updateRoomData(map);
	}
	@Test
	//
	public void testGetRoomData() {
		RoomDataTxtHelper test=new RoomDataTxtHelper();
		RoomPO room=test.getRoomData().get(33);
		String str=room.getHotelID()+";"+room.getRoomType()+";"+room.getRoomID()+";"+room.getPrice()+";"+room.isState();
		assertEquals("3;2;33;100.0;false",str);
	}

	

}

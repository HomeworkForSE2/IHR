package serviceTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.HotelBrowseServiceImpl;
import vo.HotelInfoVO;

/*
 * 还未写完
 */
public class HotelBrowseServiceImplTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSearchHotel() {
		HotelBrowseServiceImpl test=new HotelBrowseServiceImpl();
		assertEquals(1,test.searchHotel("格林豪泰").getHotelID());
		assertEquals(2,test.searchHotel("南大3栋").getHotelID());
		assertEquals(3,test.searchHotel("南大2栋").getHotelID());
		assertEquals(null,test.searchHotel("南大4栋"));
	}

	//初测
	@Test
	public void testViewHotelList() {
		HotelBrowseServiceImpl test=new HotelBrowseServiceImpl();
		List list=test.viewHotelList("南大鼓楼", "秦淮区", null, 0, 0);
		assertEquals(list.size(), 3);
//		System.out.println(((HotelInfoVO)list.get(0)).getHotelName());
//		System.out.println(((HotelInfoVO)list.get(1)).getHotelName());
//		System.out.println(((HotelInfoVO)list.get(2)).getHotelName());
	}

	//初测
	@Test
	public void testShowReservedHotel() {
		fail("Not yet implemented");
	}

}

package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.HotelBrowseServiceImpl;

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

	@Test
	public void testViewHotelList() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowReservedHotel() {
		fail("Not yet implemented");
	}

}

package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.HotelInfoServiceImpl;
import vo.HotelInfoVO;

/*
 * 已经测试完成
 */
public class HotelInfoServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaintainHotelInfo() {
		HotelInfoServiceImpl test=new HotelInfoServiceImpl();
		HotelInfoVO hotel0=new HotelInfoVO(1, "", "南大鼓楼", "秦淮区", 2, "", "");
		HotelInfoVO hotel1=new HotelInfoVO(2, "", "南大鼓楼", "秦淮区", 0, "", "");
		HotelInfoVO hotel2=new HotelInfoVO(3, "", "南大鼓楼", "秦淮区", 0, "", "");
		boolean a=test.maintainHotelInfo(hotel0);
		boolean b=test.maintainHotelInfo(hotel1);
		boolean c=test.maintainHotelInfo(hotel2);
		assertEquals(a, true);
		assertEquals(b, true);
		assertEquals(c, true);
	}

	@Test
	public void testFindHotel() {
		HotelInfoServiceImpl test=new HotelInfoServiceImpl();
		assertEquals(test.findHotel(1).getHotelName(), "格林豪泰");
		assertEquals(test.findHotel(2).getHotelName(), "南大3栋");
		assertEquals(test.findHotel(3).getHotelName(), "南大2栋");
	}

}

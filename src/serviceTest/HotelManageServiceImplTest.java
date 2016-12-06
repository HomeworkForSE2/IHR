package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.HotelManageServiceImpl;
import vo.HotelInfoVO;
import vo.UserInfoVO;

/*
 * 已经测试完成
 */
public class HotelManageServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddHotel() {
		HotelManageServiceImpl test=new HotelManageServiceImpl();
		HotelInfoVO hotel0=new HotelInfoVO(0, "格林豪泰", "南大和园", "仙林", 2, "一家连锁酒店", "24小时热水和wifi全覆盖");
		boolean a=test.addHotel(hotel0);
		UserInfoVO hotelWorker0=new UserInfoVO(0, "伏晓", "aaaa", "bbbb", 0);
		boolean b=test.addHotelworker(hotelWorker0);
		assertEquals(a, true);
		assertEquals(b, true);
		
		HotelInfoVO hotel1=new HotelInfoVO(0, "南大3栋", "南大仙林", "仙林", 0, "男生宿舍", "东哥");
		boolean c=test.addHotel(hotel1);
		UserInfoVO hotelWorker1=new UserInfoVO(0, "汤恩义", "aaaa", "bbbb", 0);
		boolean d=test.addHotelworker(hotelWorker1);
		assertEquals(c, true);
		assertEquals(d, true);
		
		HotelInfoVO hotel2=new HotelInfoVO(0, "南大2栋", "南大仙林", "仙林", 0, "女生宿舍", "宿管阿姨");
		boolean e=test.addHotel(hotel2);
		UserInfoVO hotelWorker2=new UserInfoVO(0, "王浩然", "aaaa", "bbbb", 0);
		boolean f=test.addHotelworker(hotelWorker2);
		assertEquals(e, true);
		assertEquals(f, true);
	}

	@Test
	public void testAddHotelworker() {
		HotelManageServiceImpl test=new HotelManageServiceImpl();
		HotelInfoVO hotel0=new HotelInfoVO(0, "格林豪泰", "南大和园", "仙林", 2, "一家连锁酒店", "24小时热水和wifi全覆盖");
		boolean a=test.addHotel(hotel0);
		assertEquals(a, false);
		
		UserInfoVO hotelWorker2=new UserInfoVO(0, "王浩然", "aaaa", "bbbb", 0);
		boolean f=test.addHotelworker(hotelWorker2);
		assertEquals(f, false);
		
	}

}

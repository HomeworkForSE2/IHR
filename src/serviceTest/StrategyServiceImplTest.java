package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.StrategyServiceImpl;
import vo.StrategyVO;


/*
 * 未完成
 */
public class StrategyServiceImplTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetSpecialTimeByHotel() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		StrategyVO strategy0=new StrategyVO(1, "双11", 0.8, "20161110", "20161112");
		StrategyVO strategy1=new StrategyVO(1, "双12", 0.87, "20161211", "20161213");
		StrategyVO strategy2=new StrategyVO(0, "双11", 0.7, "20161110", "20161112");
		StrategyVO strategy3=new StrategyVO(2, "黑色星期五", 0.78, "20161208", "20161210");
		
		boolean a=test.setSpecialTimeByHotel(strategy0);
		boolean b=test.setSpecialTimeByHotel(strategy1);
		boolean c=test.setSpecialTimeByHotel(strategy2);
		boolean d=test.setSpecialTimeByHotel(strategy3);
		assertEquals(true, a);
		assertEquals(true, b);
		assertEquals(true, c);
		assertEquals(true, d);
		
	}

	@Test
	public void testSetResRoomNumByHotel() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		StrategyVO strategy0=new StrategyVO(2, "", 0.88, "20161001", "20161211");
		StrategyVO strategy1=new StrategyVO(2, "", 0.78, "20161001", "20161211");
		StrategyVO strategy2=new StrategyVO(2, "", 0.68, "20161001", "20161211");
		boolean a=test.setResRoomNumByHotel(strategy0, 2);
		boolean b=test.setResRoomNumByHotel(strategy1, 3);
		boolean c=test.setResRoomNumByHotel(strategy2, 4);
		assertEquals(a, true);
		assertEquals(b, true);
		assertEquals(c, true);
		
	}

	@Test
	public void testSetSpecialTimeByWeb() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBirthdayByHotel() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		StrategyVO strategy0=new StrategyVO(1, "", 0.5, "20161001", "20161211");
		StrategyVO strategy1=new StrategyVO(2, "", 0.5, "20161001", "20161211");
		boolean a=test.setBirthdayByHotel(strategy0);
		boolean b=test.setBirthdayByHotel(strategy1);
		assertEquals(a, true);
		assertEquals(b, true);
	}

	@Test
	public void testSetEnterpriseByHotel() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		StrategyVO strategy0=new StrategyVO(1, "", 0.9, "20161001", "20161211");
		StrategyVO strategy1=new StrategyVO(2, "", 0.91, "20161001", "20161211");
		boolean a=test.setEnterpriseByHotel(strategy0, "华为");
		boolean b=test.setEnterpriseByHotel(strategy0, "小米");
		assertEquals(a, true);
		assertEquals(b, true);
	}

	@Test
	public void testSetForVip() {
		
	}

	@Test
	public void testSetVipGrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewHotelStrategyList() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewWebStrategyList() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcute() {
		fail("Not yet implemented");
	}

}

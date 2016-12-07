package serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import serviceImpl.StrategyServiceImpl;
import vo.OrderVO;
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
		boolean b=test.setEnterpriseByHotel(strategy1, "小米");
		assertEquals(a, true);
		assertEquals(b, true);
	}

	@Test
	public void testSetForVip() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		StrategyVO strategy0=new StrategyVO(1, "", 0.9, "20161001", "20161211");
		StrategyVO strategy1=new StrategyVO(1, "", 0.8, "20161001", "20161211");
		StrategyVO strategy2=new StrategyVO(1, "", 0.7, "20161001", "20161211");
		StrategyVO strategy3=new StrategyVO(1, "", 0.6, "20161001", "20161211");
		boolean a=test.setForVip(strategy0, "栖霞区", 2);
		boolean b=test.setForVip(strategy1, "栖霞区", 3);
		boolean c=test.setForVip(strategy2, "秦淮区", 4);
		boolean d=test.setForVip(strategy3, "秦淮区", 5);
		assertEquals(a,true);
		assertEquals(b,true);
		assertEquals(c,true);
		assertEquals(d,true);
	}

	@Test
	public void testSetVipGrade() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		boolean a=test.setVipGrade(1, 500);
		boolean b=test.setVipGrade(2, 800);
		boolean c=test.setVipGrade(3, 1200);
		boolean d=test.setVipGrade(4, 2400);
		boolean e=test.setVipGrade(5, 5600);
		boolean f=test.setVipGrade(5, 600);
		boolean g=test.setVipGrade(6, 600);
		boolean h=test.setVipGrade(7, 600);
		assertEquals(a,true);
		assertEquals(b,true);
		assertEquals(c,true);
		assertEquals(d,true);
		assertEquals(e,true);
		assertEquals(f,false);
		assertEquals(g,false);
		assertEquals(h,false);
		
	}

	@Test
	public void testViewHotelStrategyList() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		int a=test.viewHotelStrategyList(1).size();
		int b=test.viewHotelStrategyList(2).size();
		int c=test.viewHotelStrategyList(3).size();
		int d=test.viewHotelStrategyList(0).size();
		assertEquals(a, 4);
		assertEquals(b, 6);
		assertEquals(c, 0);
		assertEquals(d, 5);
	}

	@Test
	public void testViewWebStrategyList() {
		fail("Not yet implemented");
	}

	//核心方法，初测成功
	@Test
	public void testCalcute() {
		StrategyServiceImpl test=new StrategyServiceImpl();
		System.out.println(test.calcute(1, 2, 1000, 4));
		System.out.println(test.calcute(1, 1, 1000, 4));
		System.out.println(test.calcute(1, 1, 1000, 2));
	}

}

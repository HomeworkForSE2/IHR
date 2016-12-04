	package serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataDao.HotelBrowseDao;
import dataDao.HotelDao;
import dataDao.JudgeDao;
import dataDaoImpl.HotelDaoImpl;
import dataDaoImpl.JudgeDaoImpl;
import po.HotelPO;
import po.JudgePO;
import service.JudgeService;
import vo.HotelInfoVO;

public class JudgeServiceImpl implements JudgeService{
	
	private JudgeDao judgeDao;
	private HotelBrowseDao hotelBrowseDao;
	
	public JudgeServiceImpl() {
		// TODO Auto-generated constructor stub
		judgeDao = JudgeDaoImpl.getInstance();
		hotelBrowseDao = HotelDaoImpl.getInstance();
	}
	
	
	
	@Override
	public List<HotelInfoVO> viewNotJudgeHotelList(int userID) {

		List<HotelPO> list = hotelBrowseDao.findNotJudgedHotel(userID);
		List<HotelInfoVO> nonJudgeList = new ArrayList<>();
		Iterator it = list.iterator();
		while(it.hasNext()){
			HotelPO h = (HotelPO) it.next();
			HotelInfoVO hotelinfo = new HotelInfoVO(h);
			nonJudgeList.add(hotelinfo);
		}

		return nonJudgeList;
	}

	@Override
	public boolean setJudge(int userId, int hotelId, int star, String evaluation) {
		
		JudgePO judge = new JudgePO(userId, hotelId, evaluation, star);	
		return judgeDao.addJudge(judge);
	}

}

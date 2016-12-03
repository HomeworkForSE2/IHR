package dataDaoImpl;

import java.util.List;
import java.util.Map;

import dataDao.JudgeDao;
import dataDataHelper.DataFactory;
import dataDataHelper.JudgeDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.HotelPO;
import po.JudgePO;

public class JudgeDaoImpl implements JudgeDao{

	private Map<Integer,JudgePO> map;
	
	private JudgeDataHelper judgeDataHelper;
	
	private DataFactory dataFactory;

	private static JudgeDaoImpl judgeDataServiceImpl;
	
	public static JudgeDaoImpl getInstance(){
		if(judgeDataServiceImpl==null){
			judgeDataServiceImpl=new JudgeDaoImpl();
		}
		return judgeDataServiceImpl;
	}
	
	public JudgeDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			judgeDataHelper=dataFactory.getJudgeDataHelper();
			map=judgeDataHelper.getJudgeData();
		}
	}
	@Override
	public List<HotelPO> findNotJudgedHotel(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addJudge(JudgePO judeg) {
		// TODO Auto-generated method stub
		return false;
	}

}

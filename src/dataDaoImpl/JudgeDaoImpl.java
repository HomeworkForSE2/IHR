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

	private List<JudgePO> list;
	
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
		if(list==null){
			dataFactory=new DataFactoryImpl();
			judgeDataHelper=dataFactory.getJudgeDataHelper();
			list=judgeDataHelper.getJudgeData();
		}
	}
	@Override
	public List<HotelPO> findNotJudgedHotel(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addJudge(JudgePO judge) {
			list.add(judge);
			judgeDataHelper.updateJudgeData(list);
			return true;
	}
	
	public static void main(String arg[]){
		JudgeDaoImpl ex = new JudgeDaoImpl();
		ex.test();
	}
	
	public void test(){
		JudgePO judge = new JudgePO(11111, 119, "Can not find any supermarket nearby the hotel", 3);
		addJudge(judge);
		
	}


}

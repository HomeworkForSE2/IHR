package dataDaoImpl;

import java.util.Map;

import dataDao.MemberDao;
import dataDataHelper.DataFactory;
import dataDataHelper.MemberDataHelper;
import dataDataHelperImpl.DataFactoryImpl;
import po.MemberPO;
import po.UserPO;

public class MemberDaoImpl implements MemberDao{

	private Map<Integer,MemberPO> map;
	
	private MemberDataHelper memberDataHelper;
	
	private DataFactory dataFactory;

	private static MemberDaoImpl memberDataServiceImpl;
	
	private static MemberDaoImpl getInstance(){
		if(memberDataServiceImpl==null){
			memberDataServiceImpl=new MemberDaoImpl();
		}
		return memberDataServiceImpl;
	}
	
	public MemberDaoImpl(){
		if(map==null){
			dataFactory=new DataFactoryImpl();
			memberDataHelper=dataFactory.getMemberDataHelper();
			map=memberDataHelper.getMemberData();
		}
	}
	@Override
	public boolean insert(MemberPO member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

}

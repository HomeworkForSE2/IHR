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
	
	public static MemberDaoImpl getInstance(){
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
		int userID=member.getUserID();	
		if(map.get(userID)==null){
			map.put(userID, member);
			memberDataHelper.updateMemberData(map);
			return true;
		}	
		return false;
	}
	
	@Override
	public boolean update(MemberPO member) {
		// TODO Auto-generated method stub
		int userID=member.getUserID();	
		if(map.get(userID)!=null){
			map.put(userID, member);
			memberDataHelper.updateMemberData(map);
			return true;
		}
		return false;
	}

	
	@Override
	public boolean insert(UserPO user) {
		// TODO Auto-generated method stub
		return UserDaoImpl.getInstance().addWebsiteWorker(user);
	}
	
	public static void main(String[] args) {
		MemberDaoImpl go=new MemberDaoImpl();
		go.test1();
	}

	public void test1(){
		MemberPO m=new MemberPO(1, "1111", "2222");
		System.out.println(insert(m));
		m=new MemberPO(4, "1111", "2222");
		System.out.println(insert(m));
		System.out.println(update(new MemberPO(1, "1111", "2222")));
		
	}

	@Override
	public String findBirthday(int UserID) {
		// TODO Auto-generated method stub
		if(map.get(UserID)!=null){
			return map.get(UserID).getBirthday();
		}
		return null;
	}

	@Override
	public String findEnterprise(int UserID) {
		// TODO Auto-generated method stub
		if(map.get(UserID)!=null){
			return map.get(UserID).getEnterpriseName();
		}
		return null;
	}

}

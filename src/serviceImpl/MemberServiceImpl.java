package serviceImpl;

import java.rmi.RemoteException;

import dataDao.MemberDao;
import dataDao.UserManageDao;
import dataDaoImpl.MemberDaoImpl;
import dataDaoImpl.UserDaoImpl;
import po.MemberPO;
import po.UserPO;
import service.MemberService;
import vo.MemberVO;
import vo.UserInfoVO;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	
	private UserManageDao userManageDao;
	
	private int userNum;
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
		memberDao=MemberDaoImpl.getInstance();
		userManageDao=UserDaoImpl.getInstance();
		userNum=userManageDao.getUserNum()+1;
	}

	@Override
	public int initialize(UserInfoVO user,String birthday, String enterpriseName) {
		// TODO Auto-generated method stub
		//初始信用值300	
		UserPO u=new UserPO(userNum, user.getUserName(), user.getPassword(), user.getPhoneNumber(), 300);
		boolean result=memberDao.insert(u);
		if(result){
			member(userNum,birthday,enterpriseName);
			userNum++;
		}
		int help=userNum-1;
		return help;
	}

	@Override
	public boolean member(int userID, String birthday, String enterpriseName) {
		// TODO Auto-generated method stub
		MemberPO m=new MemberPO(userID, birthday, enterpriseName);		
		return memberDao.insert(m);
	}

	@Override
	public boolean memberUpdate(int userID, String birthday, String enterpriseName) {
		// TODO Auto-generated method stub
		MemberPO m=new MemberPO(userID, birthday, enterpriseName);
		return memberDao.update(m);
	}

	@Override
	public MemberVO getMember(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		MemberVO member=new MemberVO(memberDao.findBirthday(userID), memberDao.findEnterprise(userID));
		return member;
	}

}

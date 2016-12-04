package serviceImpl;

import dataDao.MemberDao;
import dataDaoImpl.MemberDaoImpl;
import po.MemberPO;
import po.UserPO;
import service.MemberService;
import vo.UserInfoVO;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
		memberDao=MemberDaoImpl.getInstance();
	}

	@Override
	public boolean initialize(UserInfoVO user) {
		// TODO Auto-generated method stub
		UserPO u=new UserPO(0, user.getUserName(), user.getPassword(), user.getPassword(), 0);
		return memberDao.insert(u);
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

}

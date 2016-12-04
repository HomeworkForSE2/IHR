package serviceImpl;

import dataDao.LoginDao;
import dataDaoImpl.UserDaoImpl;
import service.LoginService;

public class LoginServiceImpl implements LoginService{

	private LoginDao loginDao;
	
	public LoginServiceImpl() {
		loginDao=UserDaoImpl.getInstance();
	}
	
	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return loginDao.checkUser(userName, password);
	}

	@Override
	public boolean loginAdmin(String password) {
		// TODO Auto-generated method stub
		return loginDao.checkAdmin(password);
	}

}

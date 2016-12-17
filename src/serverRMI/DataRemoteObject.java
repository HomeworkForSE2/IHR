package serverRMI;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import service.CreditService;
import service.HotelBrowseService;
import service.HotelInfoService;
import service.HotelManageService;
import service.JudgeService;
import service.LoginService;
import service.MemberService;
import service.OrderByHotelService;
import service.OrderByUserService;
import service.OrderByWebService;
import service.RoomService;
import service.StrategyService;
import service.UserInfoService;
import service.UserManageService;
import serviceImpl.CreditServiceImpl;
import serviceImpl.HotelBrowseServiceImpl;
import serviceImpl.HotelInfoServiceImpl;
import serviceImpl.HotelManageServiceImpl;
import serviceImpl.JudgeServiceImpl;
import serviceImpl.LoginServiceImpl;
import serviceImpl.MemberServiceImpl;
import serviceImpl.OrderByHotelServiceImpl;
import serviceImpl.OrderByUserServiceImpl;
import serviceImpl.OrderByWebServiceImpl;
import serviceImpl.RoomServiceImpl;
import serviceImpl.StrategyServiceImpl;
import serviceImpl.UserInfoServiceImpl;
import serviceImpl.UserManageServiceImpl;
import vo.CreditChangeVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomConditionVO;
import vo.StrategyVO;
import vo.UserInfoVO;

public class DataRemoteObject extends UnicastRemoteObject implements CreditService,HotelBrowseService,HotelInfoService,HotelManageService,JudgeService,LoginService,MemberService,RoomService,StrategyService,UserInfoService,UserManageService,OrderByUserService,OrderByHotelService,OrderByWebService{
	private static final long serialVersionUID = 4029039744279087114L;
	
	private CreditService creditService;
	private HotelBrowseService hotelBrowseService;
	private HotelInfoService hotelInfoService;
	private HotelManageService hotelManageService;
	private JudgeService judgeService;
	private LoginService loginService;
	private MemberService memberService;
	private OrderByHotelService orderByHotelService;
	private OrderByUserService orderByUserService;
	private OrderByWebService orderByWebService;
	private RoomService roomService;
	private StrategyService strategyService;
	private UserInfoService userInfoService;
	private UserManageService userManageService;
	
	protected DataRemoteObject() throws RemoteException, FileNotFoundException {
		creditService=new CreditServiceImpl();
		hotelBrowseService=new HotelBrowseServiceImpl();
		hotelInfoService=new HotelInfoServiceImpl();
		hotelManageService=new HotelManageServiceImpl();
		judgeService=new JudgeServiceImpl();
		loginService=new LoginServiceImpl();
		memberService=new MemberServiceImpl();
		orderByHotelService=new OrderByHotelServiceImpl();
		orderByUserService=new OrderByUserServiceImpl();
		orderByWebService=new OrderByWebServiceImpl();
		roomService=new RoomServiceImpl();
		strategyService=new StrategyServiceImpl();
		userInfoService=new UserInfoServiceImpl();
		userManageService=new UserManageServiceImpl();
	}
	@Override
	public UserInfoVO showUserInfo(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return userManageService.showUserInfo(userName);
	}
	@Override
	public boolean addWebsiteWorker(UserInfoVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return userManageService.addWebsiteWorker(vo);
	}
	@Override
	public UserInfoVO showUserInfo(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return userInfoService.showUserInfo(userID);
	}
	@Override
	public List<HotelInfoVO> showReservedHotel(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelBrowseService.showReservedHotel(userID);
	}
	@Override
	public boolean modifyUserInfo(UserInfoVO userInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return userInfoService.modifyUserInfo(userInfo);
	}
	@Override
	public boolean setSpecialTimeByHotel(StrategyVO strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setSpecialTimeByHotel(strategy);
	}
	@Override
	public boolean setResRoomNumByHotel(StrategyVO strategy, int roomNum) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setResRoomNumByHotel(strategy, roomNum);
	}
	@Override
	public boolean setSpecialTimeByWeb(StrategyVO strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setSpecialTimeByWeb(strategy);
	}
	@Override
	public boolean setBirthdayByHotel(StrategyVO strategy) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setBirthdayByHotel(strategy);
	}
	@Override
	public boolean setEnterpriseByHotel(StrategyVO strategy, String enterpriseName) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setEnterpriseByHotel(strategy, enterpriseName);
	}
	@Override
	public boolean setForVip(StrategyVO strategy, String BD,int vipGrade) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setForVip(strategy, BD,vipGrade);
	}
	@Override
	public boolean setVipGrade(int vipGrade, int credit) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.setVipGrade(vipGrade, credit);
	}
	@Override
	public List<StrategyVO> viewHotelStrategyList(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.viewHotelStrategyList(hotelID);
	}
	@Override
	public List<StrategyVO> viewWebStrategyList() throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.viewWebStrategyList();
	}

	@Override
	public boolean initialize(UserInfoVO user) throws RemoteException {
		// TODO Auto-generated method stub
		return memberService.initialize(user);
	}
	@Override
	public boolean member(int userID,String birthday,String enterpriseName) throws RemoteException {
		// TODO Auto-generated method stub
		return memberService.member(userID,birthday,enterpriseName);
	}
	
	@Override
	public boolean login(String userName, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return loginService.login(userName, password);
	}
	@Override
	public List<HotelInfoVO> viewNotJudgeHotelList(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return judgeService.viewNotJudgeHotelList(userID);
	}
	@Override
	public boolean setJudge(int userId, int hotelId, int star, String evaluation) throws RemoteException {
		// TODO Auto-generated method stub
		return judgeService.setJudge(userId, hotelId, star, evaluation);
	}
	@Override
	public boolean addHotel(HotelInfoVO hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelManageService.addHotel(hotel);
	}
	@Override
	public boolean addHotelworker(UserInfoVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelManageService.addHotelworker(vo);
	}
	@Override
	public boolean maintainHotelInfo(HotelInfoVO hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelInfoService.maintainHotelInfo(hotel);
	}
	@Override
	public HotelInfoVO searchHotel(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelBrowseService.searchHotel(hotelName);
	}
	@Override
	public List<HotelInfoVO> viewHotelList(String location, String BD, RoomConditionVO room, int star, int judgeScore) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelBrowseService.viewHotelList(location, BD, room, star, judgeScore);
	}
	@Override
	public boolean addRechargeCredit(int userID, int credit, int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return creditService.addRechargeCredit(userID, credit, orderID);
	}
	@Override
	public boolean recoverCredit(int userID, int dicision, int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return creditService.recoverCredit(userID, dicision, orderID);
	}
	@Override
	public boolean deduceCredit(int userID, int credit, int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return creditService.deduceCredit(userID, credit, orderID);
	}
	@Override
	public boolean addOrderFinishCredit(int userID, int credit, int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return creditService.addOrderFinishCredit(userID, credit, orderID);
	}
	@Override
	public List<CreditChangeVO> showCreditRecord(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return creditService.showCreditRecord(userID);
	}
	
	@Override
	public boolean loginAdmin(String password) throws RemoteException {
		// TODO Auto-generated method stub
		return loginService.loginAdmin(password);
	}
	@Override
	public HotelInfoVO findHotel(int hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelInfoService.findHotel(hotelID);
	}
	@Override
	public boolean memberUpdate(int userID, String birthday, String enterpriseName) throws RemoteException {
		// TODO Auto-generated method stub
		return memberService.memberUpdate(userID, birthday, enterpriseName);
	}
	@Override
	public double calcute(int userID, int hotelID, double price, int roomNum) throws RemoteException {
		// TODO Auto-generated method stub
		return strategyService.calcute(userID, hotelID, price, roomNum);
	}
	@Override
	public boolean creatRoom(int hotelID, int roomType, int roomNum, double price) throws RemoteException {
		// TODO Auto-generated method stub
		return roomService.creatRoom(hotelID, roomType, roomNum, price);
	}
	@Override
	public boolean checkInRoom(int roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return roomService.checkInRoom(roomID);
	}
	@Override
	public boolean checkOutRoom(int roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return roomService.checkOutRoom(roomID);
	}
	@Override
	public List<OrderVO> getAllWebOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.getAllWebOrder();
	}
	@Override
	public List<OrderVO> getWebNotExecuteOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.getWebNotExecuteOrder();
	}
	@Override
	public List<OrderVO> getWebExecuteOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.getWebExecuteOrder();
	}
	@Override
	public List<OrderVO> getWebUnusualOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.getWebUnusualOrder();
	}
	@Override
	public List<OrderVO> getWebCancelOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.getWebCancelOrder();
	}
	@Override
	public boolean cancelUnusualOrder(int orderID, int dec) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByWebService.cancelUnusualOrder(orderID, dec);
	}
	@Override
	public boolean initHotel(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.initHotel(ID);
		
	}
	@Override
	public List<OrderVO> getAllHotelOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.getAllHotelOrder();
	}
	@Override
	public List<OrderVO> getHotelNotExecuteOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.getHotelNotExecuteOrder();
	}
	@Override
	public List<OrderVO> getHotelExecuteOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.getHotelExecuteOrder();
	}
	@Override
	public List<OrderVO> getHotelUnusualOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.getHotelUnusualOrder();
	}
	@Override
	public List<OrderVO> getHotelCancelOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.getHotelCancelOrder();
	}
	@Override
	public boolean executeOrder(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.executeOrder(orderID);
	}
	@Override
	public boolean finishOrder(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.finishOrder(orderID);
	}
	@Override
	public boolean setUnusualToExecute(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByHotelService.setUnusualToExecute(orderID);
	}
	@Override
	public boolean initUser(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return orderByUserService.initUser(ID);
	}
	@Override
	public List<OrderVO> getAllUserOrder()throws RemoteException {
		// TODO Auto-generated method stub
		return orderByUserService.getAllUserOrder();
	}
	@Override
	public List<OrderVO> getUserNotExecuteOrder() throws RemoteException{
		// TODO Auto-generated method stub
		return orderByUserService.getUserNotExecuteOrder();
	}
	@Override
	public List<OrderVO> getUserExecuteOrder()throws RemoteException {
		// TODO Auto-generated method stub
		return orderByUserService.getUserExecuteOrder();
	}
	@Override
	public List<OrderVO> getUserUnusualOrder() throws RemoteException{
		// TODO Auto-generated method stub
		return orderByUserService.getUserUnusualOrder();
	}
	@Override
	public List<OrderVO> getUserCancelOrder() throws RemoteException{
		// TODO Auto-generated method stub
		return orderByUserService.getUserCancelOrder();
	}
	@Override
	public boolean createOrder(OrderVO order) throws RemoteException{
		// TODO Auto-generated method stub
		return orderByUserService.createOrder(order);
	}
	@Override
	public boolean cancelOrder(int orderID) throws RemoteException{
		// TODO Auto-generated method stub
		return orderByUserService.cancelOrder(orderID);
	}
	
}

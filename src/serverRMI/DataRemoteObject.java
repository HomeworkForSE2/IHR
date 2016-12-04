package serverRMI;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.MemberPO;
import service.CreditService;
import service.HotelBrowseService;
import service.HotelInfoService;
import service.HotelManageService;
import service.JudgeService;
import service.LoginService;
import service.MemberService;
import service.OrderService;
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
import serviceImpl.OrderServiceImpl;
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

public class DataRemoteObject extends UnicastRemoteObject implements CreditService,HotelBrowseService,HotelInfoService,HotelManageService,JudgeService,LoginService,MemberService,OrderService,RoomService,StrategyService,UserInfoService,UserManageService{
	private static final long serialVersionUID = 4029039744279087114L;
	
	private CreditService creditService;
	private HotelBrowseService hotelBrowseService;
	private HotelInfoService hotelInfoService;
	private HotelManageService hotelManageService;
	private JudgeService judgeService;
	private LoginService loginService;
	private MemberService memberService;
	private OrderService orderService;
	private RoomService roomService;
	private StrategyService strategyService;
	private UserInfoService userInfoService;
	private UserManageService userManageService;
	
	protected DataRemoteObject(int hotelID) throws RemoteException, FileNotFoundException {
		creditService=new CreditServiceImpl();
		hotelBrowseService=new HotelBrowseServiceImpl();
		hotelInfoService=new HotelInfoServiceImpl();
		hotelManageService=new HotelManageServiceImpl();
		judgeService=new JudgeServiceImpl();
		loginService=new LoginServiceImpl();
		memberService=new MemberServiceImpl();
		orderService=new OrderServiceImpl(hotelID);
		roomService=new RoomServiceImpl();
		strategyService=new StrategyServiceImpl();
		userInfoService=new UserInfoServiceImpl();
		userManageService=new UserManageServiceImpl();
	}
	@Override
	public UserInfoVO showUserInfo(String userName) {
		// TODO Auto-generated method stub
		return userManageService.showUserInfo(userName);
	}
	@Override
	public boolean addWebsiteWorker(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return userManageService.addWebsiteWorker(vo);
	}
	@Override
	public UserInfoVO showUserInfo(int userID) {
		// TODO Auto-generated method stub
		return userInfoService.showUserInfo(userID);
	}
	@Override
	public List<HotelInfoVO> showReservedHotel(int userID) {
		// TODO Auto-generated method stub
		return hotelBrowseService.showReservedHotel(userID);
	}
	@Override
	public boolean modifyUserInfo(UserInfoVO userInfo) {
		// TODO Auto-generated method stub
		return userInfoService.modifyUserInfo(userInfo);
	}
	@Override
	public boolean setSpecialTimeByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return strategyService.setSpecialTimeByHotel(strategy);
	}
	@Override
	public boolean setResRoomNumByHotel(StrategyVO strategy, int roomNum) {
		// TODO Auto-generated method stub
		return strategyService.setResRoomNumByHotel(strategy, roomNum);
	}
	@Override
	public boolean setSpecialTimeByWeb(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return strategyService.setSpecialTimeByWeb(strategy);
	}
	@Override
	public boolean setBirthdayByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		return strategyService.setBirthdayByHotel(strategy);
	}
	@Override
	public boolean setEnterpriseByHotel(StrategyVO strategy, String enterpriseName) {
		// TODO Auto-generated method stub
		return strategyService.setEnterpriseByHotel(strategy, enterpriseName);
	}
	@Override
	public boolean setForVip(StrategyVO strategy, String BD,int vipGrade) {
		// TODO Auto-generated method stub
		return strategyService.setForVip(strategy, BD,vipGrade);
	}
	@Override
	public boolean setVipGrade(int vipGrade, int credit) {
		// TODO Auto-generated method stub
		return strategyService.setVipGrade(vipGrade, credit);
	}
	@Override
	public List<StrategyVO> viewHotelStrategyList(int hotelID) {
		// TODO Auto-generated method stub
		return strategyService.viewHotelStrategyList(hotelID);
	}
	@Override
	public List<StrategyVO> viewWebStrategyList() {
		// TODO Auto-generated method stub
		return strategyService.viewWebStrategyList();
	}
	@Override
	public double calcute(OrderVO vo) {
		// TODO Auto-generated method stub
		return strategyService.calcute(vo);
	}
	@Override
	public boolean creatRoom(int hotelID, int roomType, boolean state, int price) {
		// TODO Auto-generated method stub
		return roomService.creatRoom(hotelID, roomType, state, price);
	}
	@Override
	public boolean checkInRoom(int roomID, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return roomService.checkInRoom(roomID, startTime, endTime);
	}
	@Override
	public boolean checkOutRoom(int roomID, String finshTime) {
		// TODO Auto-generated method stub
		return roomService.checkOutRoom(roomID, finshTime);
	}
	@Override
	public int getValue(int orderID) {
		// TODO Auto-generated method stub
		return orderService.getValue(orderID);
	}
	@Override
	public List<OrderVO> getUserAllOrder(int userID) {
		// TODO Auto-generated method stub
		return orderService.getUserAllOrder(userID);
	}
	@Override
	public List<OrderVO> getUserNotExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		return orderService.getUserNotExecuteOredr(userID);
	}
	@Override
	public List<OrderVO> getUserExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		return orderService.getUserExecuteOredr(userID);
	}
	@Override
	public List<OrderVO> getUserUnusualOredr(int userID) {
		// TODO Auto-generated method stub
		return orderService.getUserUnusualOredr(userID);
	}
	@Override
	public List<OrderVO> getUserCancelOrder(int userID) {
		// TODO Auto-generated method stub
		return orderService.getUserCancelOrder(userID);
	}
	@Override
	public List<OrderVO> getHotelAllOrder(int hotelID) {
		// TODO Auto-generated method stub
		return orderService.getHotelAllOrder(hotelID);
	}
	@Override
	public List<OrderVO> getHotelNotExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		return orderService.getHotelNotExecuteOredr(hotelID);
	}
	@Override
	public List<OrderVO> getHotelExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		return orderService.getHotelExecuteOredr(hotelID);
	}
	@Override
	public List<OrderVO> getHotelUnusualOredr(int hotelID) {
		// TODO Auto-generated method stub
		return orderService.getHotelUnusualOredr(hotelID);
	}
	@Override
	public List<OrderVO> getHotelCancelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return orderService.getHotelCancelOrder(hotelID);
	}

	@Override
	public boolean initialize(UserInfoVO user) {
		// TODO Auto-generated method stub
		return memberService.initialize(user);
	}
	@Override
	public boolean member(int userID,String birthday,String enterpriseName) {
		// TODO Auto-generated method stub
		return memberService.member(userID,birthday,enterpriseName);
	}
	
	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return loginService.login(userName, password);
	}
	@Override
	public List<HotelInfoVO> viewNotJudgeHotelList(int userID) {
		// TODO Auto-generated method stub
		return judgeService.viewNotJudgeHotelList(userID);
	}
	@Override
	public boolean setJudge(int userId, int hotelId, int star, String evaluation) {
		// TODO Auto-generated method stub
		return judgeService.setJudge(userId, hotelId, star, evaluation);
	}
	@Override
	public boolean addHotel(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		return hotelManageService.addHotel(hotel);
	}
	@Override
	public boolean addHotelworker(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return hotelManageService.addHotelworker(vo);
	}
	@Override
	public boolean maintainHotelInfo(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		return hotelInfoService.maintainHotelInfo(hotel);
	}
	@Override
	public HotelInfoVO searchHotel(String hotelName) {
		// TODO Auto-generated method stub
		return hotelBrowseService.searchHotel(hotelName);
	}
	@Override
	public List<HotelInfoVO> viewHotelList(String location, String BD, RoomConditionVO room, int star, int judgeScore) {
		// TODO Auto-generated method stub
		return hotelBrowseService.viewHotelList(location, BD, room, star, judgeScore);
	}
	@Override
	public boolean addRechargeCredit(int userID, int credit, int orderID) {
		// TODO Auto-generated method stub
		return creditService.addRechargeCredit(userID, credit, orderID);
	}
	@Override
	public boolean recoverCredit(int userID, int dicision, int orderID) {
		// TODO Auto-generated method stub
		return creditService.recoverCredit(userID, dicision, orderID);
	}
	@Override
	public boolean deduceCredit(int userID, int credit, int orderID) {
		// TODO Auto-generated method stub
		return creditService.deduceCredit(userID, credit, orderID);
	}
	@Override
	public boolean addOrderFinishCredit(int userID, int credit, int orderID) {
		// TODO Auto-generated method stub
		return creditService.addOrderFinishCredit(userID, credit, orderID);
	}
	@Override
	public List<CreditChangeVO> showCreditRecord(int userID) {
		// TODO Auto-generated method stub
		return creditService.showCreditRecord(userID);
	}
	@Override
	public boolean cancelOrder(int orderID) {
		// TODO Auto-generated method stub
		return orderService.cancelOrder(orderID);
	}
	@Override
	public boolean createOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return orderService.createOrder(order);
	}
	@Override
	public boolean setOrderUnusual(int orderID) {
		// TODO Auto-generated method stub
		return orderService.setOrderUnusual(orderID);
	}
	@Override
	public boolean setOrderUnusualToCancel(int orderID) {
		// TODO Auto-generated method stub
		return orderService.setOrderUnusualToCancel(orderID);
	}
	@Override
	public boolean setOrderUnusualToExecute(int orderID) {
		// TODO Auto-generated method stub
		return orderService.setOrderUnusualToExecute(orderID);
	}
	@Override
	public boolean setOrderExecute(int orderID) {
		// TODO Auto-generated method stub
		return orderService.setOrderExecute(orderID);
	}
	@Override
	public boolean loginAdmin(String password) {
		// TODO Auto-generated method stub
		return loginService.loginAdmin(password);
	}
	@Override
	public HotelInfoVO findHotel(int hotelID) {
		// TODO Auto-generated method stub
		return hotelInfoService.findHotel(hotelID);
	}
	@Override
	public boolean memberUpdate(int userID, String birthday, String enterpriseName) {
		// TODO Auto-generated method stub
		return memberService.memberUpdate(userID, birthday, enterpriseName);
	}
}

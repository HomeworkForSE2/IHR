package clientRMI;

import java.rmi.Remote;

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

public class RemoteHelper {
	
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	
	public CreditService getCreditService(){
		return (CreditService)remote;
	}
	
	public HotelBrowseService getHotelBrowseService(){
		return (HotelBrowseService)remote;
	}
	
	public HotelInfoService getHotelInfoService(){
		return (HotelInfoService)remote;
	}
	
	public HotelManageService getHotelManageService(){
		return (HotelManageService)remote;
	}
	
	public JudgeService getJudgeService(){
		return (JudgeService)remote;
	}
	
	public LoginService getLoginService(){
		return (LoginService)remote;
	}
	
	public MemberService getMemberService(){
		return (MemberService)remote;
	}
	
	public RoomService getRoomService(){
		return (RoomService)remote;
	}
	
	public StrategyService getStrategyService(){
		return (StrategyService)remote;
	}
	
	public UserInfoService getUserInfoService(){
		return (UserInfoService)remote;
	}
	
	public UserManageService getUserManageService(){
		return (UserManageService)remote;
	}
	
	public OrderByHotelService getOrderByHotelService(){
		return (OrderByHotelService)remote;
	}
	
	public OrderByUserService getOrderByUserService(){
		return (OrderByUserService)remote;
	}
	
	public OrderByWebService getOrderByWebService(){
		return (OrderByWebService)remote;
	}

}

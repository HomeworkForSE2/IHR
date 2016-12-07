package serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dataDao.HotelDao;
import dataDao.MemberDao;
import dataDao.StrategyDao;
import dataDao.UserDao;
import dataDaoImpl.HotelDaoImpl;
import dataDaoImpl.MemberDaoImpl;
import dataDaoImpl.StrategyDaoImpl;
import dataDaoImpl.UserDaoImpl;
import po.StrategyEntPO;
import po.StrategyForVipPO;
import po.StrategyPO;
import po.StrategyRoomNumPO;
import po.VipPO;
import service.StrategyService;
import vo.OrderVO;
import vo.StrategyVO;

/*
 * 0特殊时期1生日2房间3合作企业4vip
 */
public class StrategyServiceImpl implements StrategyService {
	
	private StrategyDao strategyDao;
	private MemberDao memberDao;
	private HotelDao hotelDao;
	private UserDao userDao;
	public StrategyServiceImpl() {
		// TODO Auto-generated constructor stub
		strategyDao=StrategyDaoImpl.getInstance();
		memberDao=MemberDaoImpl.getInstance();
		hotelDao=HotelDaoImpl.getInstance();
		userDao=UserDaoImpl.getInstance();
	}

	@Override
	public boolean setSpecialTimeByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(strategy.getOwnerId(), 0, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setResRoomNumByHotel(StrategyVO strategy, int roomNum) {
		// TODO Auto-generated method stub
		StrategyRoomNumPO s=new StrategyRoomNumPO(strategy.getOwnerId(), 2, "", strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), roomNum);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setSpecialTimeByWeb(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(0, 0, strategy.getStrategyName(), strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setBirthdayByHotel(StrategyVO strategy) {
		// TODO Auto-generated method stub
		StrategyPO s=new StrategyPO(strategy.getOwnerId(), 1, "生日优惠策略", strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime());
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setEnterpriseByHotel(StrategyVO strategy, String enterpriseName) {
		// TODO Auto-generated method stub
		StrategyEntPO s=new StrategyEntPO(strategy.getOwnerId(), 3, "", strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), enterpriseName);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setForVip(StrategyVO strategy,String BD,int vipGrade) {
		// TODO Auto-generated method stub
		StrategyForVipPO s=new StrategyForVipPO(0, 4, "", strategy.getDiscount(), strategy.getStartTime(), strategy.getEndTime(), BD, vipGrade);
		return strategyDao.addStrategy(s);
	}

	@Override
	public boolean setVipGrade(int vipGrade, int credit) {
		// TODO Auto-generated method stub
		VipPO vip=new VipPO(vipGrade, credit);
		return strategyDao.addVip(vip);
	}

	//文件里要初始化vip00
	@Override
	public List<StrategyVO> viewHotelStrategyList(int hotelID) {
		// TODO Auto-generated method stub
		List<StrategyPO> list=strategyDao.findHotelStrategyList(hotelID);
		List<StrategyVO> strategyList=new ArrayList<>();
		Iterator it=list.iterator();
		while(it.hasNext()){
			StrategyPO s=(StrategyPO)it.next();
			StrategyVO strategy=new StrategyVO(s);
			strategyList.add(strategy);
		}
		return strategyList;
	}

	@Override
	public List<StrategyVO> viewWebStrategyList() {
		// TODO Auto-generated method stub
		return viewHotelStrategyList(0);
	}

	@Override
	public double calcute(int userID,int hotelID,double price,int roomNum) {
		// TODO Auto-generated method stub
	
		List <StrategyPO> list=strategyDao.findHotelStrategyList(hotelID);
		List <StrategyPO> webList=strategyDao.findHotelStrategyList(0);
		//得到该酒店和网站的所有策略
		Iterator webIt=webList.iterator();
		while(webIt.hasNext()){
			list.add((StrategyPO)webIt.next());
		}
		
		//开始遍历
		Iterator it=list.iterator();
		double discount=1;
		while(it.hasNext()){
			StrategyPO s=(StrategyPO)it.next();
			//下单时间
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("YYYYMMdd");
//			String time=format.format(date);
			String time="20161112";
			
			if(s.getStrategyType()==0){
				//0特殊时期，看下单时间是否匹配
				if(Integer.valueOf(s.getStartTime())<=Integer.valueOf(time)&&Integer.valueOf(time)<=Integer.valueOf(s.getEndTime())){
					if(discount>s.getDiscount()){//折扣略低则赋值
						discount=s.getDiscount();
					}
				}
				
			}else if(s.getStrategyType()==1){
				//1生日，看下单时间是否匹配
				if(memberDao.findBirthday(userID).substring(4).equals(time.substring(4))){
					if(discount>s.getDiscount()){
						discount=s.getDiscount();
					}
				}
				
			}else if(s.getStrategyType()==2){
				//2房间，看房间数量是否匹配
				StrategyRoomNumPO srn=(StrategyRoomNumPO)s;
				if(srn.getRoomNum()==roomNum){
					if(discount>s.getDiscount()){
						discount=s.getDiscount();
					}
				}
				
			}else if(s.getStrategyType()==3){
				//3合作企业，看企业名
				StrategyEntPO se=(StrategyEntPO)s;
				if(memberDao.findEnterprise(userID).equals(se.getEnterpriseName())){
					if(discount>s.getDiscount()){
						discount=s.getDiscount();
					}
				}
			}else if(s.getStrategyType()==4){
				//4vip，看商圈和等级
				StrategyForVipPO sfv=(StrategyForVipPO)s;
				if(sfv.getBD().equals(hotelDao.findHotel(hotelID).getBD())&&sfv.getVipGrade()==strategyDao.getVipGrade(userDao.findUser(userID).getCredit())){
					if(discount>s.getDiscount()){
						discount=s.getDiscount();
					}
				}
			}
			
				
		}
		return price*discount;
	}
	
	public static void main(String[] args) {
		
	}

}

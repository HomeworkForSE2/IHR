package po;
//房间数量，策略类型为2
public class StrategyRoomNumPO extends StrategyPO{
	
	public StrategyRoomNumPO(int ownerID, int strategyType, String strategyName, double discount, String startTime,
			String endTime,int roomNum) {
		super(ownerID, 2, "房间优惠策略", discount, startTime, endTime);
		this.roomNum=roomNum;
		// TODO Auto-generated constructor stub
	}

	private int roomNum;

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public static void main(String[] args) {
		StrategyRoomNumPO s=new StrategyRoomNumPO(1, 3, "a", 1, "a", "b", 3);
		System.out.println(s.getStrategyType());
		System.out.println(s.getRoomNum());
		
		StrategyPO ss=new StrategyRoomNumPO(1, 3, "a", 1, "a", "b", 3);
		StrategyRoomNumPO sss=(StrategyRoomNumPO)ss;
		System.out.println(sss.getRoomNum());
	}
	

}

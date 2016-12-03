package dataDataHelperImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import dataDataHelper.StrategyDataHelper;
import po.StrategyEntPO;
import po.StrategyForVipPO;
import po.StrategyPO;
import po.StrategyRoomNumPO;
import po.VipPO;

public class StrategyDataTxtHelper implements StrategyDataHelper{

	@Override
	public List<StrategyPO> getStrategyData() {
		// TODO Auto-generated method stub
		List <StrategyPO> list=new ArrayList<>();
		File file=new File("src/txtData/Strategy");
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null){
				String []data=str.split(";");
				int ownerID=Integer.valueOf(data[0]);
				int strategyType=Integer.valueOf(data[1]);
				String strategyName=data[2];
				double discount=Double.valueOf(data[3]);
				String startTime=data[4];
				String endTime=data[5];
				if(strategyType==2){
					int roomNum=Integer.valueOf(data[6]);
					StrategyRoomNumPO s2=new StrategyRoomNumPO(ownerID, strategyType, strategyName, discount, startTime, endTime, roomNum);
					list.add(s2);
				}else if(strategyType==3){
					String enterpriseName=data[6];
					StrategyEntPO s3=new StrategyEntPO(ownerID, strategyType, strategyName, discount, startTime, endTime, enterpriseName);
					list.add(s3);
				}else if(strategyType==4){
					String BD=data[6];
					int vipGrade=Integer.valueOf(data[7]);
					StrategyForVipPO s4=new StrategyForVipPO(ownerID, strategyType, strategyName, discount, startTime, endTime, BD, vipGrade);
					list.add(s4);
				}else{
					StrategyPO s=new StrategyPO(ownerID, strategyType, strategyName, discount, startTime, endTime);
					list.add(s);
				}
				str=br.readLine();
			}
			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStrategyData(List<StrategyPO> list) {
		// TODO Auto-generated method stub
		File file=new File("src/txtData/Strategy");
		try {
			FileWriter fw= new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator it=list.iterator();
			while(it.hasNext()){
				StrategyPO s=(StrategyPO)it.next();
				int strategyType=s.getStrategyType();
				String str=s.getOwner()+";"+s.getStrategyType()+";"+s.getStrategyName()+";"+s.getDiscount()+";"+s.getStartTime()+";"+s.getEndTime();
				if(strategyType==2){
					StrategyRoomNumPO s2=(StrategyRoomNumPO)s;
					str=str+";"+s2.getRoomNum();
				}else if(strategyType==3){
					StrategyEntPO s3=(StrategyEntPO)s;
					str=str+";"+s3.getEnterpriseName();
				}else if(strategyType==4){
					StrategyForVipPO s4=(StrategyForVipPO)s;
					str=str+";"+s4.getBD()+";"+s4.getVipGrade();
				}
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<Integer, VipPO> getVipData() {
		// TODO Auto-generated method stub
		Map <Integer, VipPO>map=new HashMap<Integer, VipPO>();
		File file=new File("src/txtData/Vip");
		try {
			FileReader fr= new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			String str=br.readLine();
			while(str!=null){
				String []data=str.split(";");
				int vipGrade=Integer.valueOf(data[0]);
				int credit=Integer.valueOf(data[1]);
				VipPO vip=new VipPO(vipGrade, credit);				
				map.put(vipGrade, vip);	
				
				str=br.readLine();
				
			}
			
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateVipData(Map<Integer, VipPO> map) {
		// TODO Auto-generated method stub
		File file=new File("src/txtData/Vip");
		try {
			FileWriter fw= new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator <Map.Entry<Integer, VipPO>> it=map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<Integer, VipPO> entry=it.next();
				VipPO vip=entry.getValue();
				String str=vip.getVipGrade()+";"+vip.getVipGradeCredit();	
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StrategyDataTxtHelper go=new StrategyDataTxtHelper();
		go.test();
	}
	
	public void test(){
		Map<Integer, VipPO> map=new HashMap<Integer, VipPO>();
		VipPO v1=new VipPO(1, 400);
		VipPO v2=new VipPO(2, 700);
		VipPO v3=new VipPO(3, 1000);
		VipPO v4=new VipPO(4, 1500);
		VipPO v5=new VipPO(1, 150);
		map.put(v1.getVipGrade(), v1);
		map.put(v2.getVipGrade(), v2);
		map.put(v3.getVipGrade(), v3);
		map.put(v4.getVipGrade(), v4);
		map.put(v5.getVipGrade(), v5);
		updateVipData(map);
		
		Map<Integer, VipPO> map2=getVipData();
		Iterator<Map.Entry<Integer, VipPO>> it=map2.entrySet().iterator();
		while(it.hasNext()){
			VipPO v=it.next().getValue();
			System.out.println(v.getVipGrade()+";"+v.getVipGradeCredit());
		}
		
		List<StrategyPO> list=new ArrayList<>();
		StrategyPO s1=new StrategyPO(0, 1, "生日策略", 0.8, "19970909", "19980908");
		StrategyPO s2=new StrategyPO(0, 1, "生日策略", 0.8, "19970909", "19980908");
		StrategyRoomNumPO s3=new StrategyRoomNumPO(2, 0, "房间", 0.9, "1888", "1900", 3);
		StrategyEntPO s4=new StrategyEntPO(3, 3, "", 0.7, "10", "11", "南京大学");
		StrategyForVipPO s5=new StrategyForVipPO(3, 3, "", 0.1, "101", "111", "仙林", 4);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		updateStrategyData(list);
		
		List<StrategyPO> list1=getStrategyData();
		System.out.println(list1.size());
	}

	
}
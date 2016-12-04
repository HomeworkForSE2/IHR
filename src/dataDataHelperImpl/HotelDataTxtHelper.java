package dataDataHelperImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataDataHelper.HotelDataHelper;
import po.HotelPO;

public class HotelDataTxtHelper implements HotelDataHelper{

	public static void main(String[] args) {
		HotelDataTxtHelper go=new HotelDataTxtHelper();
		go.test();
	}
	
	@Override
	public Map<Integer, HotelPO> getHotelData() {
		// TODO Auto-generated method stub
		Map<Integer, HotelPO> map =new HashMap<Integer, HotelPO>();
		File file=new File("src/txtData/Hotel");	
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			String str;		
			str = br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				int hotelID=Integer.valueOf(data[0]);
				String hotelName=data[1];
				String location=data[2];
				String BD=data[3];
				int starNum=Integer.valueOf(data[4]);
				String introduction=data[5];
				String device=data[6];
				int score=Integer.valueOf(data[7]);
				HotelPO hotel=new HotelPO(hotelID, hotelName, location, BD, starNum, introduction, device, score);
				map.put(hotelID, hotel);
				
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
	public void updateHotelData(Map<Integer, HotelPO> map) {
		// TODO Auto-generated method stub
		
		File file=new File("src/txtData/Hotel");		 
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator <Map.Entry<Integer, HotelPO>>it=map.entrySet().iterator(); 
			while(it.hasNext()){
				Map.Entry<Integer, HotelPO> entry=it.next();
				HotelPO hotel=entry.getValue();
				String str=hotel.getHotelID()+";"+hotel.getHotelName()+";"+hotel.getLocation()+";"+hotel.getBD()+";"+hotel.getStarNum()+";"+hotel.getIntroduction()+";"+hotel.getDevice()+";"+hotel.getScore();
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

	public void test(){
		Map<Integer, HotelPO> map=new HashMap<Integer, HotelPO>();
		HotelPO h1=new HotelPO(1, "格林豪泰", "仙林", "南大和园", 5, "一家连锁酒店", "24小时热水", 5);
		HotelPO h2=new HotelPO(2, "格林", "仙林", "南大和园", 5, "一家连锁酒店", "24小时热水", 4);
		HotelPO h3=new HotelPO(3, "南大3栋", "仙林", "南大和园", 10, "一家连锁酒店", "24小时热水", 0);
		HotelPO h4=new HotelPO(4, "南大招待所", "仙林", "南大和园", 2, "一家连锁酒店", "24小时热水", 5);
		HotelPO h5=new HotelPO(5, "南大", "仙林", "南大和园", 2, "一家连锁酒店", "24小时热水", 5);
		map.put(h1.getHotelID(), h1);
		map.put(h2.getHotelID(), h2);
		map.put(h3.getHotelID(), h3);
		map.put(h4.getHotelID(), h4);
		map.put(h5.getHotelID(), h5);
		updateHotelData(map);
		
		Map<Integer, HotelPO> map2=getHotelData();
		Iterator<Map.Entry<Integer, HotelPO>> it=map2.entrySet().iterator();
		while(it.hasNext()){
			HotelPO h=it.next().getValue();
			System.out.println(h.getHotelID()+";"+h.getHotelName()+";"+h.getBD()+";"+h.getLocation()+";"+h.getStarNum()+";"+h.getIntroduction()+";"+h.getDevice()+";"+h.getScore());
		}
		
	}

}

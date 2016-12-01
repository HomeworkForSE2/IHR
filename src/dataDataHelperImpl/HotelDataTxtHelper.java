package dataDataHelperImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataDataHelper.HotelDataHelper;
import po.HotelPO;

public class HotelDataTxtHelper implements HotelDataHelper{

	
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
				boolean hasHotelWorker=Boolean.valueOf(data[2]);//待测
				String location=data[3];
				String BD=data[4];
				int starNum=Integer.valueOf(data[5]);
				String introduction=data[6];
				String device=data[7];
				int score=Integer.valueOf(data[8]);
				HotelPO hotel=new HotelPO(hotelID, hotelName, hasHotelWorker, location, BD, starNum, introduction, device, score);
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
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator <Map.Entry<Integer, HotelPO>>it=map.entrySet().iterator(); 
			while(it.hasNext()){
				Map.Entry<Integer, HotelPO> entry=it.next();
				HotelPO hotel=entry.getValue();
				//hotelWorker还没有写进去
				String str=hotel.getHotelID()+";"+hotel.getHotelName()+";"+hotel.isHasHotelWorker()+";"+hotel.getLocation()+";"+hotel.getBD()+";"+hotel.getStarNum()+";"+hotel.getIntroduction()+";"+hotel.getDevice()+";"+hotel.getScore();
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
	

}

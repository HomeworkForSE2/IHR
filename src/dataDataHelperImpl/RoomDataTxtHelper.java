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

import dataDataHelper.RoomDataHelper;
import po.RoomPO;
import po.UserPO;

public class RoomDataTxtHelper implements RoomDataHelper{

	@Override
	public Map<Integer, RoomPO> getRoomData() {
		// TODO Auto-generated method stub
		Map <Integer, RoomPO>map=new HashMap<Integer, RoomPO>();
		File file=new File("src/txtData/Room");
		
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			String str;		
			str = br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				int roomID=Integer.valueOf(data[0]);
				int hotelID=Integer.valueOf(data[1]);
				int roomType=Integer.valueOf(data[2]);
				double price=Double.valueOf(data[3]);
				boolean state=Boolean.valueOf(data[4]);
				RoomPO room=new RoomPO(roomID,hotelID,roomType,price,state);
				map.put(roomID, room);
				
				str=br.readLine();				
			}
			
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	//最底层的更新是重写一张map，传参也是map
	public void updateRoomData(Map<Integer, RoomPO> map) {
		// TODO Auto-generated method stub
				File file=new File("src/txtData/Room");
				try {
					//写入用户数据
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw=new BufferedWriter(fw);
					
					//对map的entry值进行遍历
					Iterator <Map.Entry<Integer, RoomPO>> it=map.entrySet().iterator();
					while(it.hasNext()){
						Map.Entry<Integer, RoomPO> entry=it.next();
						RoomPO room=entry.getValue();
						String str=room.getRoomID()+";"+room.getHotelID()+";"+room.getRoomType()+";"+room.getPrice()+";"+room.isState();
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

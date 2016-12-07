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

import dataDataHelper.OrderDataHelper;
import po.OrderPO;
import po.UserPO;

public class OrderDataTxtHelper implements OrderDataHelper{

	@Override
	public void updateOrderData(Map<Integer, OrderPO> map) {
		// TODO Auto-generated method stub
				File file=new File("src/txtData/Order");
				try {
					//写入用户数据
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw=new BufferedWriter(fw);
					
					//对map的entry值进行遍历
					Iterator <Map.Entry<Integer, OrderPO>> it=map.entrySet().iterator();
					while(it.hasNext()){
						Map.Entry<Integer,OrderPO> entry=it.next();
						OrderPO order=entry.getValue();
						String str=order.getOrderID()+";"+order.getUserID()+";"+order.getHotelID()+";"+order.getState()+";"+order.getPrice()+";"+order.getStartTime()+";"+order.getEndTime()+";"+order.getFinishTime()+";"+order.getRoomType()+";"+order.getRoomNum()+";"+order.isHasChildren()+";"+order.getRoomID();
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
	public Map<Integer, OrderPO> getOrderData() {
		Map <Integer, OrderPO>map=new HashMap<Integer, OrderPO>();
		File file=new File("src/txtData/Order");
		
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			String str;		
			str = br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				int orderID=Integer.valueOf(data[0]);
				int userID=Integer.valueOf(data[1]);
				int hotelID=Integer.valueOf(data[2]);
				int state=Integer.valueOf(data[3]);
				double price=Double.valueOf(data[4]);
				String startTime=data[5];
				String endTime=data[6];
				String finishTime=data[7];
				int roomType=Integer.valueOf(data[8]);
				int roomNum=Integer.valueOf(data[9]);
				boolean isHasChildren =Boolean.valueOf(data[10]);
				String roomID=data[11];
				
				OrderPO order=new OrderPO(orderID,userID, hotelID,state,price,startTime,endTime,finishTime,roomType,roomNum,isHasChildren,roomID);
				map.put(orderID,order);
				
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
}

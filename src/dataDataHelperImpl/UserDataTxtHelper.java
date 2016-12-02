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

import dataDataHelper.UserDataHelper;
import po.HotelWorkerPO;
import po.UserPO;
import po.WebsiteAdminPO;
import po.WebsiteWorkerPO;

public class UserDataTxtHelper implements UserDataHelper{
	
	public static void main(String[] args) throws IOException {
		UserDataTxtHelper go=new UserDataTxtHelper();
		go.test();
		go.test();
	}
	@Override
	public Map<Integer, UserPO> getUserData() {
		Map <Integer, UserPO>map=new HashMap<Integer, UserPO>();
		File file=new File("src/txtData/User");
		
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			
			String str;		
			str = br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				int userID=Integer.valueOf(data[0]);
				String userName=data[1];
				String password=data[2];
				String phoneNumber=data[3];
				int credit=Integer.valueOf(data[4]);
				UserPO user=new UserPO(userID, userName, password, phoneNumber, credit);
				map.put(userID, user);
				
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
	public void updateUserData(Map<Integer, UserPO> map)  {
		// TODO Auto-generated method stub
		File file=new File("src/txtData/User");
		try {
			//写入用户数据
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			
			//对map的entry值进行遍历
			Iterator <Map.Entry<Integer, UserPO>> it=map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<Integer, UserPO> entry=it.next();
				UserPO user=entry.getValue();
				String str=user.getUserID()+";"+user.getUserName()+";"+user.getPassword()+";"+user.getPhoneNumber()+";"+user.getCredit();
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
	public WebsiteAdminPO getWebsiteAdminData() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateWebsiteAdmin(WebsiteAdminPO admin) {
		// TODO Auto-generated method stub
		
	}

	public void test() throws IOException{
		File file=new File("src/txtData/User");
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Hello World!");
		bw.newLine();
		bw.close();
		fw.close();
	}
}

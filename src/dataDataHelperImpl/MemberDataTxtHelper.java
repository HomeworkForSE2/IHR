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

import dataDataHelper.MemberDataHelper;
import po.MemberPO;

public class MemberDataTxtHelper implements MemberDataHelper{

	public static void main(String[] args) {
		MemberDataTxtHelper go=new MemberDataTxtHelper();
		go.test();
	}
	
	@Override
	public Map<Integer, MemberPO> getMemberData() {
		Map <Integer, MemberPO> map=new HashMap<Integer, MemberPO>();
		File file=new File("src/txtData/Member");
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null){
				String []data=str.split(";");
				int ID=Integer.valueOf(data[0]);
				String birthday=data[1]; 
				String enterpriseName=data[2];
				MemberPO member=new MemberPO(ID, birthday,enterpriseName);
				map.put(ID, member);
				
				str=br.readLine();
			}
			
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMemberData(Map<Integer, MemberPO> map) {
		// TODO Auto-generated method stub
		File file=new File("src/txtData/Member");
		try {
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator<Map.Entry<Integer, MemberPO>> it=map.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<Integer, MemberPO> entry=it.next();
				MemberPO member=entry.getValue();
				String str=member.getUserID()+";"+member.getBirthday()+";"+member.getEnterpriseName();
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
		Map<Integer, MemberPO> map=new HashMap<Integer, MemberPO>();
		MemberPO m1=new MemberPO(1, "19970418", "华为");
		MemberPO m2=new MemberPO(2, "19920418", "小米");
		MemberPO m3=new MemberPO(2, "19930418", "google");
		MemberPO m4=new MemberPO(3, "19930418", "google");
		map.put(m1.getUserID(), m1);
		map.put(m2.getUserID(), m2);
		map.put(m3.getUserID(), m3);
		map.put(m4.getUserID(), m4);
		
		updateMemberData(map);
		
		Map<Integer, MemberPO> map2=getMemberData();
		Iterator<Map.Entry<Integer, MemberPO>> it=map2.entrySet().iterator();
		while(it.hasNext()){
			MemberPO m=it.next().getValue();
			System.out.println(m.getUserID()+";"+m.getBirthday()+";"+m.getEnterpriseName());			
		}
		
		
	}
	
}

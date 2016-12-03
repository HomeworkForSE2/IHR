package dataDataHelperImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataDataHelper.CreditDataHelper;
import po.CreditChangePO;

public class CreditDataTxtHelper implements CreditDataHelper{

	@Override
	public List<CreditChangePO> getCreditData() {
		List<CreditChangePO> list = new ArrayList<>();
		File file = new File("src/txtData/Credit");
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			str = br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				String time = data[0];
				int orderID = Integer.valueOf(data[1]);
				int userID = Integer.valueOf(data[2]);
				int startCredit = Integer.valueOf(data[3]);
				int endCredit = Integer.valueOf(data[4]);
				int action = Integer.valueOf(data[5]);
				CreditChangePO creditChange=new CreditChangePO(time, orderID, userID, startCredit, endCredit, action);
				list.add(creditChange);
				
				str=br.readLine();
			}
			
			return list;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateCreditData(List<CreditChangePO> list) {
		File file = new File("src/txtData/Credit");
		
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator it=list.iterator();
			while(it.hasNext()){
				CreditChangePO creditChange = (CreditChangePO)it.next();
				String str = creditChange.getTime()+";"+creditChange.getOrderID()+";"+creditChange.getUserID()+";"+creditChange.getStartCredit()+";"+creditChange.getEndCredit()+";"+creditChange.getAction();
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
	}

}

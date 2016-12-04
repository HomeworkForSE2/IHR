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

import dataDataHelper.JudgeDataHelper;
import po.JudgePO;
import po.StrategyPO;

public class JudgeDataTxtHelper implements JudgeDataHelper{
	
	public static void main(String arg[]){
		
		JudgeDataTxtHelper ex2 = new JudgeDataTxtHelper();
		ex2.test();
		
	}

	@Override
	public List<JudgePO> getJudgeData() {
		List<JudgePO> list = new ArrayList<>();
		File file = new File("src/txtData/Judge");
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			str=br.readLine();
			
			while(str!=null){
				String []data=str.split(";");
				int userID = Integer.valueOf(data[0]);
				int hotelID = Integer.valueOf(data[1]);
				String judgeWord = data[2];
				int judgeScore = Integer.valueOf(data[3]);
				JudgePO judge = new JudgePO(userID, hotelID, judgeWord, judgeScore);
				list.add(judge);
				
				str=br.readLine();
			}
			
			return list;
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateJudgeData(List<JudgePO> list) {
		File file = new File("src/txtData/Judge");
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Iterator it=list.iterator();
			while(it.hasNext()){
				JudgePO judge=(JudgePO)it.next();
				String str=judge.getUserID()+";"+judge.getHotelID()+";"+judge.getJudgeWord()+";"+judge.getJudgeScore();
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}
	
	public void test(){
		
		List<JudgePO> list = new ArrayList<>();
		JudgePO judge1 = new JudgePO(0, 1, "This hotel sucks", 2);
		JudgePO judge2 = new JudgePO(0, 2, "I think hotel manager is retarded!!", 1);
		JudgePO judge3 = new JudgePO(1, 1, "It was sooo much better than what i thought :) ", 4);
		JudgePO judge4 = new JudgePO(1, 2, "You must try for the room service!! so freakin tasty",5);
		JudgePO judge5 = new JudgePO(1, 3, "nahhh.. it was just a ordinary hotel", 3);
		list.add(judge1);
		list.add(judge2);
		list.add(judge3);
		list.add(judge4);
		list.add(judge5);
		updateJudgeData(list);
		
		List<JudgePO> list2 = getJudgeData();
		Iterator it = list2.iterator();
		
		while(it.hasNext()){
			JudgePO judge = (JudgePO) it.next();
			System.out.println(judge.getUserID()+";"+judge.getHotelID()+";"+judge.getJudgeWord()+";"+judge.getJudgeScore());
		}
		
	}

}

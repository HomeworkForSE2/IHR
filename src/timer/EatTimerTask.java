package timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EatTimerTask extends TimerTask{

	private static List<Integer> eatTimes;
	
	
	static{
		initEatTimes();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("mm");
			String time=format.format(date);
	        System.out.println("检查是否到了吃饭的点");
	       
	        if(eatTimes.contains(Integer.valueOf(time)))
	        {
	            System.out.println("饿了，吃饭...");
	        }
		
	}
	
	private static void initEatTimes(){
		eatTimes=new ArrayList<>();
		eatTimes.add(47);	
	}
	
	public static void main(String[] args) {
		TimerTask t=new EatTimerTask();
		Calendar  calendar= Calendar.getInstance();    
        Date firstTime = calendar.getTime();
        //间隔：1小时
        long period = 1000 * 60;    
        //测试时间每分钟一次
        //period = 1000 * 60*60;        
        
        Timer timer = new Timer();        
        timer.schedule(t, firstTime, period);
	}

}

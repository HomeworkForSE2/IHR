package vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;  
public class SortHotelListByStarNum implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		HotelInfoVO hotel1=(HotelInfoVO)o1;
		HotelInfoVO hotel2=(HotelInfoVO)o2;
		if(hotel1.getStarNum()>hotel2.getStarNum()){
			return -1;
		}
		return 1;
	}
	
//	public static void main(String[] args) {
//		List<HotelInfoVO> list=new ArrayList<>();
//		SortHotelListByStarNum s=new SortHotelListByStarNum();
//		HotelInfoVO hotel1=new HotelInfoVO(1, "1", "1", "1", 2, "1", "1");
//		HotelInfoVO hotel2=new HotelInfoVO(2, "1", "1", "1", 1, "1", "1");
//		HotelInfoVO hotel3=new HotelInfoVO(3, "1", "1", "1", 3, "1", "1");
//		list.add(hotel1);
//		list.add(hotel2);
//		list.add(hotel3);
//		Collections.sort(list, s); 
//		System.out.println(list.get(0).getStarNum());
//		System.out.println(list.get(1).getStarNum());
//		System.out.println(list.get(2).getStarNum());
//		
//	}

}

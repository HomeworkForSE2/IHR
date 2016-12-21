package vo;

import java.util.Comparator; 
public class SortHotelListByScore implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		HotelInfoVO hotel1=(HotelInfoVO)o1;
		HotelInfoVO hotel2=(HotelInfoVO)o2;
		if(hotel1.getScore()>hotel2.getScore()){
			return -1;
		}
		return 1;
	}

}

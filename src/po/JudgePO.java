package po;

/*
 * 评分
 * 评价
 */
public class JudgePO {
	private int userID;
	
	private int hotelID;
	
	private String judgeWord;
	
	private int judgeScore;

	//构造器
	
	public JudgePO(int userID, int hotelID, String judgeWord, int judgeScore) {
		super();
		this.userID = userID;
		this.hotelID = hotelID;
		this.judgeWord = judgeWord;
		this.judgeScore = judgeScore;
	}
	
	//set和get方法
	
	
	


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getJudgeWord() {
		return judgeWord;
	}
	
	public void setJudgeWord(String judgeWord) {
		this.judgeWord = judgeWord;
	}

	public int getJudgeScore() {
		return judgeScore;
	}

	public void setJudgeScore(int judgeScore) {
		this.judgeScore = judgeScore;
	}

}

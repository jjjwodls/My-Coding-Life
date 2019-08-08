package StringTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1. 스트링 -> 날짜변환 2. 변환된 날짜로 일수 구하기
 * 
 * @author JJI
 * 
 */
public class CalandarMath {

	public static void main(String[] args) throws ParseException {
		String start = "20190831";
		String end = "20191231";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date beginDate = formatter.parse(start);
		Date endDate = formatter.parse(end);

		// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
		long diff = endDate.getTime() - beginDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.println("날짜차이=" + diffDays);

	}
	
	 /**
	   * null check 공통함수
	   * @param args 체크할 string
	   * @return true or false;
	   */
	  public static boolean nullCheck(String args){
		  
		  boolean valid = false;
		  if(args == null || args.length() == 0){
			  valid = true;
		  }
		  
		  return valid;
	  }
	  
	  /**
	   * 
	   * @param date1 시작일자
	   * @param date2 종료일자
	   * @param delimeter 각 날짜의 구분자(같아야한다.)
	   * 		만약 null 또는 빈문자열이면 split 진행하지 않는다.
	   * @return 차이나는 일자 수
	   */
	  public static long diffDayFromTime(String date1, String date2, String delimiter){
		  
		  if(nullCheck(date1) ||  nullCheck(date2)){
			  throw new RuntimeException("param is null");
		  }

		  if(delimiter != null && !delimiter.isEmpty()){
			  date1 = date1.replaceAll(delimiter, date1);
			  date2 = date1.replaceAll(delimiter, date2);
		  }
		  
		  if(date1.length() != date2.length()){
			  throw new RuntimeException("split result Invalid");
		  }
		  
		  long diffDays =0;
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  
		  try {
			  Date beginDate = formatter.parse(date1);
			  Date endDate = formatter.parse(date2);

			  // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
			  long diff = endDate.getTime() - beginDate.getTime();
			  diffDays = diff / (24 * 60 * 60 * 1000);
		  } catch (ParseException e) {
			  e.printStackTrace();
		  }

		  return diffDays;
	  }
	
	
}

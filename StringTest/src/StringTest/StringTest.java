package StringTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTest {
	
	protected static final String	COLUMNS				= "doc_id, list_seq, list_kind, review_sender_id, reviewer_id, " + "status, arrived_time, read_time, is_read, is_send_delete, is_recv_delete, review_comment, " + "use_sms , kind, is_msg, reviewer_kid, review_sender_kid, user_dept_id, user_dept_name, sender_dept_id ";
	
	public static void main(String[] args) throws Exception {
		String startDate = "20181201";
		String endDate = "20181231";
		
		int temp1 = Integer.parseInt(startDate);
		int temp2 = Integer.parseInt(endDate);
		
		System.out.println(temp2 - temp1);
		int temp3 = temp2 - temp1;
		int i = 0;
	    
	    //현재 요일
	    int dayNum = getDateDay(startDate,"yyyyMMdd") ;
	    System.out.println(dayNum);
	    String curDateWeek = "";
		
		for(i = 0 ; i < temp3+1 ; i++){
			if(dayNum == 0){
				dayNum = dayNum+1;
				curDateWeek = getDateDayFromStartDate(dayNum);
			}else{
				curDateWeek = getDateDayFromStartDate(dayNum);
			}
			
			System.out.println("12." + (i+1) + "(" +curDateWeek+")"  + " /// daynum = " + dayNum);
			dayNum = (++dayNum%8);
		}
		System.out.println("i의 결과값 = " + i + " /// curMonth = " + startDate.substring(4, 6));
		
		
		int testData = Integer.parseInt(startDate.substring(6,8));
		System.out.println("startDate.substring(6,8) = " + startDate.substring(6,8));
		System.out.println(testData);
	}
	
	public static int getDateDay(String date, String dateType) throws Exception {
		 
	    String day = "" ;
	     
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateType) ;
	    Date nDate = dateFormat.parse(date) ;
	     
	    Calendar cal = Calendar.getInstance() ;
	    cal.setTime(nDate);
	     
	    int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
	    
	    return dayNum;
	}
	
	public static String getDateDayFromStartDate(int currentDay) throws Exception {
		 
		String day = "";
		
	    switch(currentDay){
	        case 1:
	            day = "일";
	            break ;
	        case 2:
	            day = "월";
	            break ;
	        case 3:
	            day = "화";
	            break ;
	        case 4:
	            day = "수";
	            break ;
	        case 5:
	            day = "목";
	            break ;
	        case 6:
	            day = "금";
	            break ;
	        case 7:
	            day = "토";
	            break ;
	             
	    }
	    
	    return day;
	}
}

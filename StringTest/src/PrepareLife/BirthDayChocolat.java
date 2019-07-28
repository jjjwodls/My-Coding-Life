package PrepareLife;
import java.util.ArrayList;
import java.util.List;

public class BirthDayChocolat {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(4);
	/*	list.add(5);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(1);
		
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(1);*/
		//d = 18 , m = 7
		System.out.println(birthday(list,4,1));
	}
	
	// Complete the birthday function below.
    public static int birthday(List<Integer> s, int d, int m) {
        int listSize = s.size();
        //m 은 초콜릿 사용할 갯수 , d는 결과값 
        int sum = 0;
        int searchCnt = 0;
        
        int loopCnt = 0;
        int loopSize = m + loopCnt;
        
        while(true) {
           for(int j = loopCnt ; j < loopSize ; j++){
                sum += s.get(j);
           }
    	   if(sum == d){
               searchCnt++;
           }
           sum = 0;
           if(loopSize == listSize) {
       		break;
           }
           loopCnt++;
           loopSize = loopCnt+m; 	
           
        }
        return searchCnt;

    }

}

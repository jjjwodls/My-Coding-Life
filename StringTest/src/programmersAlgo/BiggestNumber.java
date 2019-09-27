package programmersAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중
 * 가장 큰 수는 6210입니다.
 * 
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항
 *  numbers의 길이는 1 이상 100,000 이하입니다. 
 *  numbers의 원소는 0 이상 1,000 이하입니다. 
 *  정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다. 
 *  
 *  입출력 예 
 *  	numbers 		   	   return 
 * 	   [6, 10, 2] 				6210 
 *    [3, 30, 34, 5, 9] 	   9534330
 * 
 * @author JJI
 * 
 */

public class BiggestNumber {

	public static void main(String[] args) {
		//int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9}; 
		
		System.out.println(solution(numbers));
	}
	
	public static String solution(int[] numbers) {
		
        String answer = "";
        List<Integer> descNumbersList = new ArrayList<Integer>();

        int k = 0 ; 
        String strNumber = "";
     /*   for(int i = 0 ; i < numbers.length ; i++){
        	k = numbers[i];
        	strNumber += k; 
        	for(int j = 0; j < numbers.length ; j++){
        		if(k != numbers[j]){
        			strNumber += numbers[j];
        		}
        	}
        	descNumbersList.add( Integer.parseInt(strNumber) );
        	strNumber = "" + k;
        	for(int j = numbers.length-1; j >= 0 ; j--){
        		if(k != numbers[j]){
        			strNumber += numbers[j];
        		}
        	}
        	descNumbersList.add( Integer.parseInt(strNumber) );
        	strNumber = "";
        }*/
        
        for(int i = 0 ; i < numbers.length ; i++){
        	descNumbersList.add( numbers[i] );
        }
        
        Collections.sort(descNumbersList, new Comparator<Integer>() {
        	
			@Override
			public int compare(Integer o1, Integer o2) {
				String num1 = String.valueOf(o1);
				String num2 = String.valueOf(o2);
				int num1Len = num1.length() == 1 ? 1 :  num1.length()*10;
				int num2Len = num2.length() == 1 ? 1 :  num2.length()*10;
				
				if(o1/num1Len > o2/num2Len){
					return -1;
				}else if(o1/num1Len > o2/num2Len){
					return 1;
				}else{
					if(num1Len > num2Len){
						return -1;
					}else if(num1Len < num2Len){
						return 1;
					}else{
						if(o1 % num1Len > o2%num2Len){
							return -1;
						}else if(o1 % num1Len < o2%num2Len){
							return 1;
						}else{
							return 0;
						}
					}
				} 
			}
		});
        Integer biggestNum = descNumbersList.get(0);
        answer = String.valueOf(biggestNum);
        
        return answer;
    }

}

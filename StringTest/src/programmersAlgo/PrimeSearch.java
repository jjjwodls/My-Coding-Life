package programmersAlgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 문제 설명 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록
 * solution 함수를 완성해주세요.
 * 
 * 제한사항 numbers는 길이 1 이상 7 이하인 문자열입니다. 
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다. 
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다. 
 * 
 * 입출력 예 
 * numbers return 
 * "17" 	  3 
 * "011" 	  2 
 * 
 * 
 * 입출력 예 설명 
 * 예제 #1 [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 * 예제 #2 [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 * 11과 011은 같은 숫자로 취급합니다
 * 
 * @author jjjwodls
 * 
 * 경우의 수 , back tracking, 순열에 대한 문제
 *
 */
public class PrimeSearch {

	public static Map<Integer,Boolean> resultMap = new HashMap<Integer,Boolean>();
	
	public static void main(String[] args) {
	
		/*String test = "17";
		System.out.println(solution(test));*/
		String numbers = "011";
		//System.out.println(solution(numbers));
		Set<Integer> set = new HashSet<>();
		permutation("",numbers,set);
		
		char[] strAry = numbers.toCharArray();
		boolean[] visted = new boolean[strAry.length];
		
		List<String> list = new ArrayList<String>();
		for(int i = 1 ; i < strAry.length ; i++) {
			permutation(list,strAry,visted,strAry.length,i);
		}
		permutation(list,strAry,visted,strAry.length,strAry.length);
		
		System.out.println(resultMap.size());
	}
	
	public static int solution(String numbers) {
		
		int answer = 0;
		
		char[] strAry = numbers.toCharArray();
		
		String rst = "";
		String rst1 = "";
		int n = 1;
		
		int aryLenght = strAry.length;
		int loopCnt = aryLenght*aryLenght;
		int checkNum = 0;
		
		Map<Integer,Boolean> primeChkMap = new HashMap<Integer,Boolean>();
		
		for(int i = 0 ; i < loopCnt; i++) {
			rst = String.valueOf(strAry[i%aryLenght]);
			rst1 = rst;
			for(int j = 0 ; j < aryLenght*n ; j++) {
				if((i%aryLenght) != (j%aryLenght) && rst1.length() < n){
					rst1 += String.valueOf(strAry[j%aryLenght]);
				}
				
				if(rst1.length() == n) {
					checkNum = Integer.parseInt(rst1);
					System.out.println(checkNum);
					if(primeChkMap.get(checkNum) == null && primeCheck(checkNum)) {
						primeChkMap.put(checkNum, true);
					};
					rst1 = rst;
				}
				
				/*if(rst1.length() == n) {
					checkNum = Integer.parseInt(rst1);
					if(primeChkMap.get(checkNum) == null && primeCheck(checkNum)) {
						primeChkMap.put(checkNum, true);
					};
					rst1 = rst;
				}else if((i%aryLenght) != (j%aryLenght) ){
					rst1 += String.valueOf(strAry[j%aryLenght]);
					System.out.println(rst1);
				}*/
			}
			
			if(i%aryLenght == aryLenght-1) {
				n++;
			}
		}
		answer = primeChkMap.size();
		
		return answer;
	}
	
	public static boolean primeCheck(int checkNum) {
		boolean checkRst = true;
		int loopCnt = (checkNum/2)+1;
		
		if(checkNum == 0 || checkNum == 1) {
			return false;
		}
		
		for(int i = 2 ; i < loopCnt ; i++) {
			if(checkNum%i == 0) {
				checkRst = false;
				break;
			}
		}
		
		
		return checkRst;
	}
	
	//back tracking 백트래킹 으로 경우의 수 출력. nCr
	public static void combination(char[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        for(int i = 0 ; i < arr.length ; i++) {
	        	if(visited[i] == true) {
	        		System.out.print(arr[i] + " ");
	        	}
	        }
	        System.out.println();
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(arr, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	    }
	}
	
	//순열 nPr 중복 허용하지 않는 순수한 경우의 수
	public static void permutation(List<String> list,char[] arr, boolean[] visited, int n, int r) {
		if(list.size() == r){
			String strToNum = "";
			for(String temp : list){
				strToNum += temp;
			}
			Integer integerNum = Integer.parseInt(strToNum);
			if(primeCheck(integerNum)) {
				resultMap.put(integerNum,true);
			}
			return;
		}
		for(int i=0; i<n; i++){
			if(!visited[i]){//자기자신을 못뽑게 해야지 중복이 안됨(이미 뽑은 것은 뽑지 않도록 체크)
				visited[i] = true;//자기자신을 못뽑게 해야지 중복이 안됨
				list.add(String.valueOf(arr[i]));
				permutation(list,arr, visited, n, r);
				visited[i] = false;
				list.remove(list.size()-1);
			}
		}

	}
	
    public static void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

}

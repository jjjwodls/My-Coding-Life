package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 잘 이해되지 않았음.
 * 2로나눔,3으로나눔,-1 이 것을 이용해 1로 만드는 것이다.
 * 그 방법의 최소 갯수를 구하는 문제이다.
 * @author jjjwodls
 *
 */
public class DP_1463 {
	
	private static int N;
	private static int[] ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ary = new int[N+1];
		int result = searchCnt(N);
		System.out.println(result);
	}
	//일단 배열에 싹다 저장을 한다.
	public static int searchCnt(int x) {
		if(x == 1)
			return 0;
		if(ary[x] > 0)
			return ary[x];
		ary[x] = searchCnt(x-1) +1; // 1 뺀 값들을.
		if(x%2 == 0) {
			int temp = searchCnt(x/2) +1;
			if(ary[x] > temp) 
				ary[x] = temp;
		}
		
		if(x%3 == 0) {
			int temp = searchCnt(x/3) +1;
			if(ary[x] > temp) 
				ary[x] = temp;
		}
		
		return ary[x];
	}
	
	
	/*public static int searchCnt2(int x, int cnt) {
		System.out.println(x);
		if(x == 1)
			return cnt;
		
		if(logValue(x,3))
			return searchCnt(x/3,cnt+1);
		if(logValue(x,2)) 
			return searchCnt(x/2,cnt+1);
		
		if(x%3==0) {
			return searchCnt(x/3,cnt+1);
		}
		if(x%2==0) {
			if((x-1) % 3 == 0) {
				searchCnt(x-1,cnt+1);
			}else {
				return searchCnt(x/2,cnt+1);
			}
		}
		
		return searchCnt(x-1,cnt+1);
	}
	
	public static boolean logValue(int val, int n) {
		double result = Math.log(val)/Math.log(n);
		String checkString = String.valueOf(result);
		String floatCheck = checkString.split("\\.")[1];
		
		if(floatCheck.length() == 1 && floatCheck.equals("0")) {
			return true;
		}else {
			return false;
		}
	}*/

}

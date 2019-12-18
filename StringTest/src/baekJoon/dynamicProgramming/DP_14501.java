package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * @author jjjwodls
 * 내가 약한 유형의 문제다. 점화식 세우는거 다시 해보기.
 * DFS 로 해결했지만 점화식으로 세우는것도 해봐야된다.
 */
public class DP_14501 {
	
	private static int N;
	private static int MAX;
	private static int[] day;
	private static int[] cost;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		day = new int[N+1];
		cost= new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			day[i] = sc.nextInt(); //일할 날짜 
			cost[i] = sc.nextInt(); //비용
		}
		searchMax(1,0);
		System.out.println(MAX);
	}
	
	public static void searchMax(int idx, int money) {
		if(idx >= N+1) {
			MAX = Math.max(MAX, money);
			return;
		}
		
		if(idx + day[idx] <= N+1) {
			searchMax(idx + day[idx],money + cost[idx]);
		}
		
		searchMax(idx+1,money);
	}
	


}

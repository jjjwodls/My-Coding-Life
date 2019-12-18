package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * @author jjjwodls
 * 점화식 세우는거 다시 해보기.
 * DFS 로 해결했지만 점화식으로 세우는것도 해봐야된다.
 */
public class DP_14501_2 {
	
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
		int[] dp = new int[N+2];
		  
		for(int i=1; i<=N; i++) {
            int workDay = i + day[i];     // i번째 날의 상담기간
 
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if(workDay<= N+1) {
            	dp[workDay] = Math.max(dp[workDay], dp[i] + cost[i]);
            }
        }
	 
         System.out.println(dp[N+1]);
	}
	
}

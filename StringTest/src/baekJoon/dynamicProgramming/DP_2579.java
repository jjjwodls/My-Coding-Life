package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 이 문제도 해결하지 못한 문제인데
 * 계단 오르는 문제로 max 값을 무하는 문제이다. 
 * 점화식만 잘 세우면 풀 수 있는 문제.
 * @author jjjwodls
 *
 */
public class DP_2579 {

	private static int[] dp;
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] ary = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		dp[1] = ary[1];
		if(N>=2) dp[2] = dp[1] + ary[2];
		
		for(int i = 3; i <= N ; i++) {
			dp[i] = Math.max(ary[i] + dp[i-2], ary[i]+ary[i-1]+dp[i-3]);
		}
		System.out.println(dp[N]);
		
	}


}

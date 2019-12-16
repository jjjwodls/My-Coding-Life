package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 타일 칠하기 문제.
 * 기존에 강의를 봤었으므로 해결하였다.
 * @author jjjwodls
 *
 */
public class DP_11726 {
	
	private static int N;
	private static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		System.out.println(dp[N]);
	}
	
	public static int dp(int x) {
		if(x == 1) return 1;
		if(x == 2) return 2;
		if(dp[x] != 0) return dp[x];
		dp[x] = (dp(x-1) + dp(x-2))%10007;
		return dp[x];
	}
}	

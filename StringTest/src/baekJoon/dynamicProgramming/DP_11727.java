package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * @author jjjwodls
 *
 */
public class DP_11727 {

	private static int N;
	private static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N+1];
		dp[1] = 1;
		if(N>1) {
			dp[2] = 3;
		}
		for(int i = 3 ; i <= N ; i++) {
			dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[N]);
		
	}

}

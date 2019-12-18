package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * @author jjjwodls
 * 점화식 각이 안보인다 큰일이다.
 */
public class DP_9465 {
	
	private static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int[] result = new int[T];
		
		int[][] ary = null;
		int[][] dp;
		
		for(int i = 0 ; i < T ; i++) {
			int input = sc.nextInt();
			sc.nextLine();
			ary = new int[input+1][2];
			dp = new int[input+1][2];
			String[] temp = sc.nextLine().split(" ");
			String[] temp2 = sc.nextLine().split(" ");
			for(int j = 1 ; j <= input ; j++) {
				ary[j][0] = Integer.parseInt(temp[j-1]);
				ary[j][1] = Integer.parseInt(temp2[j-1]);
			}
			dp[1][0] = ary[1][0];
			dp[1][1] = ary[1][1];
			for(int j = 2 ;  j <= input ; j++) {
				dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + ary[j][0];
				dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + ary[j][1];
			}
			result[i] = Math.max(dp[input][0], dp[input][1]);
		}
		
		for(int rst : result) {
			System.out.println(rst);
		}
	
	}
	
}

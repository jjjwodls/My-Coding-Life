package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 점화식 찾아서 해결함. 대체로 쉬운문제.
 * 오르막 수 찾는 문제
 * @author jjjwodls
 */
public class DP_11057 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] dp = new int[N+1][10];
		
		for(int i = 0 ; i <= 9 ; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2 ; i <= N ; i++) {
			for(int j = 0 ; j <= 9 ; j++) {
				for(int k = j ; k <= 9 ; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k])%10007;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0 ; i <= 9 ; i++) {
			sum+= dp[N][i];
		}
		
		System.out.println(sum%10007);
		
	}
	

}

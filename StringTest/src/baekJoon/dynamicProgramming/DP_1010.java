package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 다리를 놓는 경우의 수를 찾는 문제.
 * 점화식 찾아서 해결함. 대체로 쉬운문제.
 * @author jjjwodls
 */
public class DP_1010 {
	
	private static int T;
	private static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int[][] dp = new int[31][31];
		for(int i = 1 ; i <= 30 ; i++) {
			dp[1][i] = i;
		}
		int[] result = new int[T]; 
		
		for(int i = 0 ; i < T ; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N == M) {
				result[i] = 1;
				continue;
			}
			if(N == 1) {
				result[i] = dp[1][M];
				continue;
			}
			
			for(int j = 2 ; j <= N ; j++) {
				for(int k = 1 ; k <= M ; k++) {
					dp[j][k] = dp[j][k-1] + dp[j-1][k-1];
				}
			}
			result[i] = dp[N][M];
		}
		for(int rst : result) {
			System.out.println(rst);
		}
	}
	

}

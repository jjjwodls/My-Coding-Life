package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 해결했음. 중간에 초콜릿 자르는 횟수를 생각하여 오답 해결.
 * @author jjjwodls
 */
public class DP_2163 {
	
	private static int N;
	private static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] dp = new int[301][301];
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[2][1] = 1;
		dp[2][2] = 3;
		
		for(int i = 3 ; i <= N ; i++) {
			dp[1][i] = i-1;
			dp[i][1] = dp[1][i];
		}
			
		if(M > N) {
			int temp = M;
			M = N;
			N = temp;
		}
		for(int i = 3; i <= N ; i++) {
			for(int j = 2 ; j <=M ; j++) {
				dp[i][j] = j + dp[i-1][j];
				dp[j][i] = dp[i][j];
			}
		}
		System.out.println(dp[N][M]);
		
	}
	

}

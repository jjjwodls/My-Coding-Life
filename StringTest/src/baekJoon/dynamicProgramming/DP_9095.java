package baekJoon.dynamicProgramming;

import java.util.Scanner;
/**
 * 점화식을 찾지 못해 힘들었다.
 * 결국 오답.
 * @author jjjwodls
 *
 */
public class DP_9095 {

	private static int N;
	private static int dp[] = new int[11];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ary[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0 ; i < ary.length ; i++) {
			int aryValue = ary[i];
			for(int j = 4 ; j <= aryValue ; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[aryValue]);
		}
		
	}

}

package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 정답 못품 답 보고 품
 * @author jjjwo
 *
 */
public class DP_11052_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ary = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		int[] dp = new int[N+1];
		//점화식을 세워야함.
		//D[I] = P[N] + D[I-N]; 점화식을 세운 후에는 순차적으로 증가하도록 연산을 해야 최종 결과값을 구할 수 있다.
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				dp[i] = Math.max(dp[i],dp[i-j] + ary[j]);
			}
		}
		System.out.println(dp[N]);
		
	}
	
	

}

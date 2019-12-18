package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 제곱근 연산 관련 문제이다.
 * dp 에는 제곱의 합이 최소가 되는 항의 갯수들이 들어있다.
 * 답을 보면서 풀었고 점화식 및 for문을 짤 때 제곱근 관련해서는 문제를 접하지 않아
 * 생각하지 못한 문제였다.
 * @author jjjwodls
 *
 */
public class DP_1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			dp[i] = i;
			for(int j = 1; j*j <= i ; j++) { //제곱만큼 연산해주어야 하므로.
				if(dp[i] > dp[i-j*j]+1) {
					dp[i] = dp[i-j*j]+1;
				}
			}
		}
		System.out.println(dp[N]);
		
	}

}

package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 패턴 파악 후 쉽게 정답
 * 틀린 부분은 int 형으로 답을 표현해 틀림.
 * 제발 테스트 케이스에서 최대로 주어 질 수 있는 값을 대입해보자..
 * @author jjjwodls
 *
 */
public class DP_9461 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] ary = new int[T+1];
		long [] dp = new long[101];
		
		for(int i = 1 ; i <= T ; i++) {
			ary[i] = sc.nextInt();
		}
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int i = 6 ; i <=100 ; i++) {
			dp[i] = dp[i-1] + dp[i-5];	
		}
		
		for(int i = 1 ; i <= T ; i++) {
			System.out.println(dp[ary[i]]);
		}
		
	}

}

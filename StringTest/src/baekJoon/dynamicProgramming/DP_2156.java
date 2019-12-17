package baekJoon.dynamicProgramming;

import java.util.*;
/**
 * @author jjjwodls
 * 패턴 찾는데 실패
 * 확인하고 정리.
 */
public class DP_2156 {

	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ary[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		int dp[][] = new int[N+1][4];
		
		dp[1][1] = ary[1];
		dp[1][2] = ary[1];
		dp[1][3] = 0;
		
		if(N >= 2) {
			dp[2][1] = dp[1][1] + ary[2];
			dp[2][2] = 0;
			dp[2][3] = ary[2];
		}
		for(int i = 3 ; i <= N ; i++) {
			if(i%3 == 0) {
				dp[i][1] = dp[i-1][1]; 
				dp[i][2] = dp[i-2][2]+ary[i];
				dp[i][3] = dp[i-1][3]+ary[i];
			}else if(i%3 == 1) {
				dp[i][1] = dp[i-2][1]+ary[i];
				dp[i][2] = dp[i-1][2]+ary[i];
				dp[i][3] = dp[i-1][3];
			}else{ 
				dp[i][1] = dp[i-1][1]+ary[i];
				dp[i][2] = dp[i-1][2];
				dp[i][3] = dp[i-2][3]+ary[i];
			}
		}
		
		int result = Math.max(dp[N][1], Math.max(dp[N][2], dp[N][3]));
		System.out.println(result);
		
	}
	
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ary[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		int dp[] = new int[N+1];
		
		dp[1] = ary[1];
		if(N > 1) {
			dp[2] = ary[1] + ary[2];
		}
		/**
		 * i = 3 일때 가정하자.
		 * 첫번째 max 값은 2번째 값과 1번째 값 + 3번째(현재값) 비교함
		 * max 값이 정해졌으면 
		 * 2번+3번 값 더한결과와 max 결과와 비교해서 max 값을 구함. 
		 */
		for(int i = 3 ; i <= N ; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + ary[i]);
			dp[i] = Math.max(dp[i], dp[i-3] + ary[i-1] + ary[i]);
		}
		System.out.println(dp[N]);
		
	}
	
	
}

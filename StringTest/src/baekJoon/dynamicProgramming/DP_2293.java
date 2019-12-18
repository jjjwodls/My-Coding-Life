package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 코인1 문제인데 패턴을 못찾아서 답 보고 해결.
 * 패턴을 넘어 규칙성 및 다른 방식을 찾아야한다.
 * 1. 1원으로 k원까지 만들 수 있는 경우의 수를 찾는다.
 * 2. 그다음 금액으로 만들수 있는 경우의 수에 1원으로 만들 수 있는 경우의 수를 더한다.
 * 2번 과정을 반복하다보면 마지막 배열에 만들 수 있는 경우의 수가 채워진다.
 * @author jjjwodls
 */
public class DP_2293 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[] dp = new int[k+1];
		
		dp[0] = 1; // 시작점은 왜 초기화 하는건지?
		for(int i = 1; i<= n ; i++) {
			for(int j = 1 ; j <=k ; j++) {
				if(j-coin[i] >=0)
					dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
	

}

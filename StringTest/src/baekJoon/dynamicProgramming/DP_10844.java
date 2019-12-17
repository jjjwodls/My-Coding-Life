package baekJoon.dynamicProgramming;

import java.util.Scanner;
/**
 * @author jjjwodls
 * 패턴 또 몾찾음..
 * 그리고 답을 제출 시 long 타입으로 제출하자. 숫자가 너무 큼.
 * 2차원 배열로 만든다. dp[N][L]
 * N은 자릿수 , L은 끝나는 숫자로 표현한다.
 * 자릿수와 끝나는 숫자에 따라 경우의 수가 달라지므로 고려하여 문제를 풀면 된다.
 */
public class DP_10844 {

	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long dp[][] = new long[N+1][11];
		for(int i = 1 ; i <= 9 ; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2 ; i <= N ; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1 ; j <= 9 ; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000; //여기서 j = 10이더라도 j 10의 배열은 값이 0이므로 무시해도 된다. 
			}
		}
		long sum = 0;
		for(int i = 0 ; i < 10 ; i++) {
			sum += dp[N][i];
		}
		
		System.out.println(sum%1000000000);
			
	}

}

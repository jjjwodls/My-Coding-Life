package baekJoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author jjjwodls
 * 패턴을 못찾음.
 * 이전부터 연속적으로 더한 값 vs 현재부터 연속된 값이 어떤게 더 큰건지 판별하면 된다.
 */
public class DP_1912 {

	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ary[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		dp[1] = ary[1];
		int max = ary[1];
		for(int i = 2 ; i <=N ; i++) {
			dp[i] = Math.max(dp[i-1]+ary[i], ary[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
			
	}

}

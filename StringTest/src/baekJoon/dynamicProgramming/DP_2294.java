package baekJoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전 2번 문제인데 
 * 1번과 유사하지만 패턴을 또 찾지 못하였다.
 * @author jjjwodls
 */
public class DP_2294 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		for(int i = 1; i<= n ; i++) {
			for(int j = coin[i]; j <=k ; j++) { //금액만큼 돌면서 해당 동전이 필요한 갯수의 최솟값으로 변환시켜준다.
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
			}
		}
		
		if(dp[k] == 100001) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
		
	}
	

}

package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 스스로 해결 했으며 패턴을 찾아서 해결했다.
 * 런타임 에러가 발생했지만 그건 내가 입력값에 대해 제대로 확인을 안했다. 
 * 최대값, 최소값 범위의 값은 내가 직접 입력 해보자. 그리고 큰 값을 입력했을 때 
 * 음수가 나오는지도 확인하여 long 타입으로 변환이 필요한것으로 판단된다. 
 * @author jjjwodls
 *
 */
public class DP_2193 {

	private static int N;
	private static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N+1];
		
		dp[1] = 1;
		if(N > 1) { // 만약 N = 1 인데 dp[2] = 1 을 대입하면 당연히 exception이 나타나지요..
			dp[2] = 1;
		}
		
		for(int i = 3 ; i <= N ; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[N]);
		
	}

}

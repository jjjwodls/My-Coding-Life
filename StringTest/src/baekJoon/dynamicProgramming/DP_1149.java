package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 색칠 할 수 있는 최소값을 구해야 되는데
 * 케이스가 얼마 되지 않으므로 모든 경우의 수를 구한 후 최소값을 추려내는 방식으로 풀어야함.
 * 
 * 오답.
 * @author jjjwodls
 *
 */
public class DP_1149 {
	
	private static int N;
	private static int[][] ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ary = new int[N+1][3];
		
		
		for(int i = 1 ; i <= N ; i++) {
			ary[i][0] = sc.nextInt();
			ary[i][1] = sc.nextInt();
			ary[i][2] = sc.nextInt();
			sc.nextLine();
		}
		
		for(int j = 2 ; j <= N ; j++) {
			ary[j][0] += Math.min(ary[j-1][1], ary[j-1][2]);
			ary[j][1] += Math.min(ary[j-1][0], ary[j-1][2]);
			ary[j][2] += Math.min(ary[j-1][0], ary[j-1][1]);
		}
		
		System.out.println(Math.min(ary[N][0], Math.min(ary[N][1], ary[N][2])));
		
	}
	

}

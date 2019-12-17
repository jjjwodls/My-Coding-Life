package baekJoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author jjjwodls
 * 쉽게 해결. 패턴을 찾음.
 */
public class DP_1932 {

	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ary[][] = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				ary[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		for(int i = 2 ; i <= N ; i++) {
			ary[i][1] = ary[i][1] + ary[i-1][1];//제일 좌측값을 연산
			for(int j = 2 ; j <= i-1 ; j++) {
				ary[i][j] = Math.max(ary[i][j] + ary[i-1][j-1], ary[i][j] + ary[i-1][j]);
			}
			ary[i][i] = ary[i][i] + ary[i-1][i-1]; //제일 우측값을 연산.
		}
		
		Arrays.sort(ary[N]);
		System.out.println(ary[N][N]);
		
	}

}

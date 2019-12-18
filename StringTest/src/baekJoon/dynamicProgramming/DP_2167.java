package baekJoon.dynamicProgramming;

import java.util.Scanner;

/**
 * 2차원 배열의 합
 * @author jjjwodls
 *
 */
public class DP_2167 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] ary = new int[N+1][M+1];
		
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <=M ; j++) {
				ary[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		
		int K = sc.nextInt();
		//int[][] searchAry = new int[K+1][5];
		int[] result = new int[K];
		int sum = 0;
		for(int l = 0; l < K ; l++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(i == x && j == y) {
				result[l] = ary[i][j];
				continue;
			}
			
			for(int m = i ; m <= x ; m++) {
				for(int n = j ; n <=y ; n++) {
					sum += ary[m][n];
				}
			}
			result[l] = sum;
			sum = 0;
		}
		
		for(int rst : result) {
			System.out.println(rst);
		}
		
	}
}	

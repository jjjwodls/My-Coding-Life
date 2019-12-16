package baekJoon.dynamicProgramming;

import java.util.Scanner;
/**
 * 팩토리얼에서 0 또는 1이 얼마나 등장하는지 찾는 문제였는데 패턴을 찾아 해결
 * @author jjjwodls
 *
 */
public class DP_1003 {

	private static int N;
	private static int[] ary;
	private static int[][] dpCntAry;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ary = new int[N];
		dpCntAry = new int[41][2];
		dpCntAry[0][0] = 1;
		dpCntAry[0][1] = 0;
		dpCntAry[1][0] = 0;
		dpCntAry[1][1] = 1;
		dpCntAry[2][0] = 1;
		dpCntAry[2][1] = 1;
		
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		for(int i = 0 ; i < N ; i++) {
			int temp = ary[i];
			for(int j = 2 ; j <= temp ; j++) {
				dpCntAry[j][0] = dpCntAry[j-1][0] +dpCntAry[j-2][0];
				dpCntAry[j][1] = dpCntAry[j-1][1] +dpCntAry[j-2][1];
			}
			System.out.println(dpCntAry[temp][0] + " " +dpCntAry[temp][1]);
		}
	}

}

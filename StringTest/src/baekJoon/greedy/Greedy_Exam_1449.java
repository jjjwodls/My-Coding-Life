package baekJoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_Exam_1449 {

	private static int[] ary = null;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //추의 갯수
		int L = sc.nextInt(); //추의 갯수
		ary = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		
		for(int i = 0 ; i < N-1 ; i++) {
			if(ary[i+1] - ary[i] < L) {
				
			}
		}
		
	}

}

package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_2437_3 {

	private static int[] ary = null;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //추의 갯수
		ary = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		int sum = ary[0];
		if(sum != 1) {
			System.out.println(1);
		}else{
			for(int i = 1 ; i < N ; i++) {
				if(ary[i] > sum+1) {
					break;
				}
				sum += ary[i];
			}
			System.out.println(sum+1);
		}
			
	}
		
}


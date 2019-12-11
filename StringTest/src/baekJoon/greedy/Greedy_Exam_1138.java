package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_1138 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] ary = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = N ; i>=1 ; i--) {
			list.add(ary[i], i);
		}
		
		for(Integer rst : list) {
			System.out.print(rst + " ");
		}
		
	}
	
}

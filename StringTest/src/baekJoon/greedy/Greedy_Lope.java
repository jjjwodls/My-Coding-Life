package baekJoon.greedy;

import java.util.*;

/**
 * 정답
 * 로프 2217
 * 
 * @author jjjwodls
 *
 */
public class Greedy_Lope {

	private static int N = 0;
	private static int[] ary = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //로프 갯수
		ary = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt(); //
		}
		Arrays.sort(ary);
		int max = -1;
		int mid = 0;
		
		for(int i = 0 ; i < N ; i++) {
			mid = ary[i] * (N-i);
			max = Math.max(mid, max);
		}
		System.out.println(max);
		
	}

}

package baekJoon.implement;

import java.util.*;

public class Implement_2798 {
	
	private static int[] ary;
	private static boolean[] checked;
	private static int result;
	private static int N;
	private static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ary = new int[N];
		checked = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		search(0, 3, 0);
		System.out.println(result);
	}
	
	public static void search(int start, int r,int sum) {
		
		if(r == 0) {
			if(M-sum < 0) {
				return;
			}
			
			if(M-result > M-sum) 
				result = sum;
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			if(!checked[i]) {
				checked[i] = true;
				search(i+1, r-1,sum+ary[i]);
				checked[i] = false;
			}
		}
	}
}

package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_2437_2 {

	private static int[] ary = null;
	private static List<Integer> list = new ArrayList<Integer>();
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //추의 갯수
		ary = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
			list.add(ary[i]);
		}
		Arrays.sort(ary);
		int selectCnt = 2;
		int tempSum = 0;
		while(selectCnt <= N) {
			dfs(0,N,selectCnt, tempSum);
			selectCnt++;
		}
		
		Collections.sort(list);
		int beforeValue = list.get(0);
		int nextValue = 0;
		int listSize = list.size();
		for(int i = 1 ; i < listSize ; i++) {
			nextValue = list.get(i);
			if(nextValue-beforeValue > 1) {
				break;
			}
			beforeValue = nextValue;
		}
		
		System.out.println(beforeValue+1);
		
	}
	
	public static void dfs(int start , int n , int r, int tempSum) {
		if(r == 0) {
			if(list.contains(tempSum)) {
				return;
			};
			list.add(tempSum);
		}else {
			for(int i = start ; i < n ; i++) {
				dfs(i+1,n,r-1,tempSum+ary[i]);
			}
		}
		
	}

}

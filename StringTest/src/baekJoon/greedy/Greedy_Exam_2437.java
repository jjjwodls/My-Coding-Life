package baekJoon.greedy;

import java.util.*;

/**
 * 모든 경우의 수를 따지는것이 아니라 규칙성을 찾아야된다.
 * 만약 현재 ary[i] 가 기존 ary[i-1] 까지 합 +1 보다 크다면 해당 숫자는 만들어 질 수 없는것으로 판단된다고 하네..
 * @author jjjwo
 *
 */
public class Greedy_Exam_2437 {

	private static int[] ary = null;
	private static TreeSet<Integer> searchSet = new TreeSet<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //추의 갯수
		ary = new int[N];
		for(int i = 0 ; i < N ; i++) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		int selectCnt = 1;
		int tempSum = 0;
		while(selectCnt <= N) {
			dfs(0,N,selectCnt, tempSum);
			selectCnt++;
		}
		Iterator<Integer> it = searchSet.iterator();
		int beforeValue = 0;
		if(it.hasNext()) {
			beforeValue =it.next();
		}
		int nextValue;
		while(it.hasNext()) {
			nextValue = it.next(); 
			if(nextValue-beforeValue > 1) {
				break;
			}
			beforeValue = nextValue;
		}
		System.out.println(beforeValue+1);
	}
	
	public static void dfs(int start , int n , int r, int tempSum) {
		if(r == 0) {
			if(searchSet.contains(tempSum)){
				return;
			};
			searchSet.add(tempSum);
		}else {
			for(int i = start ; i < n ; i++) {
				dfs(i+1,n,r-1,tempSum+ary[i]);
			}
		}
		
	}

}

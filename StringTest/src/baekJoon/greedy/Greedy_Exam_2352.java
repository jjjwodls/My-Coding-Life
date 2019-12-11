package baekJoon.greedy;

import java.util.*;

/**
 * LIS 알고리즘으로 최장순열을 구하는 방식이다.
 * 오름차순으로 정렬된 수열을 구할 때 가장 빠르게 구하는 방식으로 O(logn) 시간복잡도를 가진다고 함.
 * 가져다 사용하자...
 * @author jjjwodls
 *
 */
public class Greedy_Exam_2352 {

	private static int k;
	private static int[] ary;
	private static boolean[] visited;
	private static int aryLen;
	private static int compare;
	private static int MAX;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		sc.nextLine();
		ary = new int[k];
		visited = new boolean[k];
		for(int i = 0 ; i < k ; i++) {
			ary[i] = sc.nextInt();
		}
		aryLen = ary.length;
		Vector<Integer> vec = new Vector<Integer>();	
		for (int i : ary) {
			if (vec.isEmpty()) {
				vec.add(i);
			}
			else if((vec.lastElement() < i)){
				 vec.add(i);
			}
			else {
				//해당 값이 존재하지 않는다면 해당 값이 있어야 할 위치가
				//만약 4라면 -4-1 값이 리턴된다. 
				int idx = Collections.binarySearch(vec, i);
				vec.set(-idx-1, i);
			}
		}
		System.out.println(vec.size());
		//1을 기준으로 잡고 진행
		//2를 기준으로 잡고 진행 ... 
		//i가 지나간 idx 보다 작으면서  지나간 idx end보다 i 의 end 가 작으면 가능하다.
		
	}

}

package baekJoon.greedy;

import java.util.*;
//문제 풀었음. 드디어 제대로.
public class Greedy_Exam_1969_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //문자열 갯수
		int M = sc.nextInt(); //문자열 길이
		
		PriorityQueue<DNA> pq = null;
		
		String[] ary = new String[N];
		int[][] dp = new int[N+1][N+1];
		sc.nextLine();
		for(int i = 0; i < N ; i++) {
			ary[i] = sc.nextLine();
		}
		int [] cntAry = new int[26];
		int cntAryLen = cntAry.length;
		
		List<DNA> list = new ArrayList<DNA>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < M ; i++) {
			pq = new PriorityQueue<>();
			Arrays.fill(cntAry, 0);
			for(int j = 0 ; j < N ; j++) {
				cntAry[ary[j].charAt(i)-65]++;
			}
			for(int j = 0 ; j < cntAryLen ; j++) {
				pq.add(new DNA(j,cntAry[j]));
			}
			char temp = (char) (pq.peek().idx+65);
			sb.append(temp);
		}
		
		String result = sb.toString();
		char[] resultAry = result.toCharArray();
		char[] compareAry = null; // 비교할 문자열을 담는 ary
		int minSum = 0;
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			compareAry = ary[i].toCharArray();
			for(int j = 0 ; j < M ; j++)
				if(resultAry[j] != compareAry[j])
					cnt++;
			minSum += cnt;
			cnt = 0;
		}
		System.out.println(result);
		System.out.println(minSum);
	}
	
	public static class DNA implements Comparable<DNA>{
		
		public int idx;
		public int cnt;
		
		public DNA(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "DNA [idx=" + idx + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(DNA o) {
			return o.cnt - this.cnt;
		}
		
	}
}

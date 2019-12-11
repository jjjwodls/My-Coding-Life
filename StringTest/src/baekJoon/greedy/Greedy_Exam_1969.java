package baekJoon.greedy;

import java.util.*;
//문제 파악 잘못함.
public class Greedy_Exam_1969 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //문자열 갯수
		int M = sc.nextInt(); //문자열 길이
	
		String[] ary = new String[N];
		int[][] dp = new int[N+1][N+1];
		sc.nextLine();
		for(int i = 0; i < N ; i++) {
			ary[i] = sc.nextLine();
		}
		Arrays.sort(ary);
		char[] compareAry = null;
		char[] compareAry2 = null;
		int cnt = 0;
		List<DNA> list = new ArrayList<DNA>();
		for(int i = 0 ; i < N ; i++) {
			compareAry = ary[i].toCharArray();
			for(int j = 0 ; j < N ; j++) {
				compareAry2 = ary[j].toCharArray();
				if(i == j) {
					dp[i+1][j+1]= dp[i+1][j]+cnt;
					continue;
				}
				for(int k = 0 ; k < M ; k++) {
					if(compareAry[k] != compareAry2[k])
						cnt++;
				}
				dp[i+1][j+1]= dp[i+1][j]+cnt;
				cnt = 0;
			}
			
			list.add(new DNA(i,dp[i+1][N]));
		}
		
		Collections.sort(list,new Comparator<DNA>() {

			@Override
			public int compare(DNA o1, DNA o2) {
				return o1.sum-o2.sum;
			}
			
		});
		DNA dna = list.get(0);
		int minIdx = dna.idx;
		String result = ary[minIdx];
		int minSum = dna.sum;
		
		System.out.println(result);
		System.out.println(minSum);
	}
	
	public static class DNA{
		public int idx;
		public int sum;
		
		public DNA(int idx, int sum) {
			super();
			this.idx = idx;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "DNA [idx=" + idx + ", sum=" + sum + "]";
		}
		
		
	}

}

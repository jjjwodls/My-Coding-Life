package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_1202 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보석 종류
		int K = sc.nextInt();//가방의 갯수
		int[] resultAry = new int[K+1];
		
		int[] bag = new int[K];
		int[][] jewelry = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			jewelry[i][0] = sc.nextInt();
			jewelry[i][1] = sc.nextInt();
		}
		
		for(int i = 0 ; i < K ; i++) {
			bag[i] = sc.nextInt();
		}
		
		Arrays.sort(jewelry,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(bag);
		
		int idx = 0;
		int k = 1;
		int maxVal = 0;
		int nextIdx = 0;
		while(idx < K) {
			int bagWeight = bag[idx++];
			for(int j = nextIdx; j < N; j++) {
				if(jewelry[j][0] <= bagWeight) {
					if(jewelry[j][1] > maxVal) {
						resultAry[k] = jewelry[j][1];
						maxVal = jewelry[j][1];
					}
				}
			}
			resultAry[k] += resultAry[k-1]; 
			k++;
			maxVal = 0;
		}
		System.out.println(resultAry[K]);
	}
	
	public static class Jewelry{
		
		public int weight;
		public int value;

		public Jewelry(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Jewelry [weight=" + weight + ", value=" + value + "]";
		}
		
	}

}

package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_1202_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보석 종류
		int K = sc.nextInt();//가방의 갯수
		int[] resultAry = new int[K+1];
		
		int[] bag = new int[K];
		int[][] jewelry = new int[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Jewelry> jewelryList = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			jewelry[i][0] = sc.nextInt();
			jewelry[i][1] = sc.nextInt();
			jewelryList.add(new Jewelry(jewelry[i][0],jewelry[i][1]));
		}
		
		for(int i = 0 ; i < K ; i++) {
			bag[i] = sc.nextInt();
		}
		Collections.sort(jewelryList,new Comparator<Jewelry>() {
			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o1.weight - o2.weight;
			}
		});
		
		Arrays.sort(bag);
		
		int idx = 0;
		int k = 1;
		int maxVal = 0;
		//int listSize = 0;
		Jewelry jewelry2 = null;
		int maxIdx = 0;
		while(idx < K) {
			int bagWeight = bag[idx++];
			jewelry2 = new Jewelry(bagWeight, 0);
			System.out.println(Collections.binarySearch(jewelryList, jewelry2));
			int searchIdx = Collections.binarySearch(jewelryList, jewelry2);
			if(searchIdx < 0) {
				searchIdx = searchIdx*-1-1; 
			}else {
				searchIdx = searchIdx+1;
			}
			
			//listSize = jewelryList.size();
			for(int j = 0; j < searchIdx; j++) {
				jewelry2 = jewelryList.get(j);
				if(jewelry2.weight <= bagWeight) {
					if(jewelry2.value > maxVal) {
						resultAry[k] = jewelry2.value;
						maxVal = jewelry2.value;
						maxIdx = j;
					}
				}else if(jewelry2.weight > bagWeight){
					break;
				}
			}
			resultAry[k] += resultAry[k-1]; 
			k++;
			maxVal = 0;
			jewelryList.remove(maxIdx);
			
		}
		System.out.println(resultAry[K]);
	}
	
	public static class Jewelry implements Comparable<Jewelry>{
		
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

		@Override
		public int compareTo(Jewelry o) {
			return this.weight - o.weight;
		}
		
	}

}

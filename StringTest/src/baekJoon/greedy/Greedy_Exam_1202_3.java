package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_1202_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//보석 종류
		int K = sc.nextInt();//가방의 갯수
		
		int[] bag = new int[K];
		int[][] jewelry = new int[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
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
		
		int j = 0;
		long result = 0; // 결과값 주의하기.
		//우선순위 큐를 사용하여 값이 가장 큰 것들 부터 꺼내오는 방식으로 해결하자.
		for(int i = 0 ; i < K ; i++) {
			
			while(j < N  && jewelryList.get(j).weight <= bag[i]) {
				pq.add(jewelryList.get(j).value);
				j++;
			}
			
			if(!pq.isEmpty())
				result+=pq.poll();
				
		}
		System.out.println(result);
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

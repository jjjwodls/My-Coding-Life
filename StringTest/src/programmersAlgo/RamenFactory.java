package programmersAlgo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RamenFactory {

	public static void main(String[] args) {
		RamenFactory factory = new RamenFactory();
		/*int stock = 4;
		int[] dates	= {4,10,15};
		int[] supplies = {20,5,10};*/
		
		int stock = 10;
		int[] dates	= {2,5,19};
		int[] supplies = {1,7,10};
		
		int k = 30;
		System.out.println(factory.solution(stock, dates, supplies, k));
				
	}

	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		int idx = 0;
		
		for(int i = 0 ; i < k ; i++) {
			
			if(i >= dates[idx]) {
				pq.add(supplies[idx]);
				idx++;
			}
			
			if(stock <= 0) {
				stock += pq.poll();
				answer++;
			}
			
			stock--;
		}
		
		/*for (int i = 0; i < dates.length; i++) {
			date = dates[i];
			dateAfter += date;

			if (stock - dateAfter <= 0) {
				stock += supplies[i];
				answer++;
			}

			if (stock >= k - 1) {
				break;
			}
		}
*/
		// stock 현재 재고 4이면 4일동안 사용 가능 3일후 까지 사용 가능하고
		// dates[0] 에는 4일째 공급이 된다. 즉, 4일 아침에 공급받아 4일째 가동 가능하며
		// 공장운영 15일 이후에는 9톤이 남으며 (4일째 20톤 받고나서 11일 사용했으니)
		// k = 30 즉 , 30일날에 밀가루가 공급되므로 29일까지 사용할 밀가루가 있어야된다.
		// 근데 9톤으로는 부족하므로 15일에 공급받는 10톤을 더 받는다.
		// 그렇게 되면 9톤 + 10톤 = 19톤으로 필요한 날짜인 29일이후 까지 15톤이 필요하다.
		// 그렇게 되면 공급이 필요 없다. 2회만 받으면 됨.

		// 해결방법 => 밀가루를 공급 받는 날에 받을지 말지 결정한다.
		// 안받고 다음 공급일 까지 버틸 수 있으면 안받고 못버티면 받는다.
		// 그리고 만약 받은 후 밀가루 공급일 전날인 k-1 일때까지 버틸 수 있으면 받지 않는다.

		return answer;
	}
	//재고는 부족하면 언제든지 dates 안에 있는 배열 날짜 이후로 가져 올 수 있다.
	//예를 들어 dates[0] 가 4일이면 4일 이후 언제든 필요한 날짜에 재고를 들여 올 수 있음.
	public int solution2(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;

		//재고를 가장 큰놈들부터 정렬한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		int idx = 0; //재고를 가져올 idx
		
		for(int day = 0 ; day < k ; day++) { //0일부터 k일까지 차례로 확인한다.

			if(idx<dates.length && day >= dates[idx]) { //재고를 입고한다. 만약 현재 날짜가 공급가능한 일을 넘어 갈 때
				pq.add(supplies[idx]); // 해외에서 공수되는 재고를 넣는다.
				idx++; //다음 재고를 가져 와야 하므로 idx 를 증가시켜준다.
			}

			if(stock <= 0) {
				stock += pq.poll(); // 가져올 수 있는 재고를 가장 큰 놈부터 들여온다.
				answer++;
			}

			stock--; //하루에 소진되는 재고
		}

		return answer;
}

}

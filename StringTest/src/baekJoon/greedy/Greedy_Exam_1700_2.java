package baekJoon.greedy;

import java.util.*;

//가장 나중에 쓰일 것을 먼저 뽑아준다 라고 설명에 나와있는데 잘 이해가 안된다.
public class Greedy_Exam_1700_2 {
	
	private static int N;
	private static int K;
	private static int[] ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //콘센트 갯수
		K = sc.nextInt(); //제품 사용순번
		
		int possibleCnt = N;
		
		ary = new int[K];

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < K ; i++) {
			ary[i] = sc.nextInt();
		}
		int min = 0;
		for(int i = 0 ; i < K; i++) {
			if(possibleCnt > 0) {
				list.add(ary[i]);
				possibleCnt--;
			}else {
				boolean flag = false;
				for(int j = 0 ; j < list.size() ; j++) {
					if(list.get(j) == ary[i]) {
						flag = true;
						break;
					}
				}
				
				if(flag) 
					continue;
					
				int maxd = 0;
				int maxt = 0;
				
				for(int j = 0 ; j < list.size() ; j++) {
					int temp = 1001;
					for(int k = i+1 ; k < K ; k++) {
						if(list.get(j) == ary[k]) {
							temp = j;
							break;
						}
					}
					
					if(maxd < temp) {
						maxd = temp;
						maxt = j;
					}
				}
				list.set(maxt, ary[i]);	
				min++;
			}
		}
		System.out.println(min);
	}
	
}

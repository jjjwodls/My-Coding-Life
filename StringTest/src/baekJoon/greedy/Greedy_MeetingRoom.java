package baekJoon.greedy;

import java.util.*;


/**
 * 회의실 배정 1931
 * 오답
 * @author jjjwodls
 * 문제를 너무 어렵게 생각함.
 */
public class Greedy_MeetingRoom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] MettingTime = new int[N][2];
		int[][] rstMettingTime = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			MettingTime[i][0] = sc.nextInt();
			MettingTime[i][1] = sc.nextInt();
		}
		//정렬 기준만 끝나는 순으로 해주고 끝나는 시간이 작은거 부터 차례로 정렬해준 후 cnt 를 더해주면된다.
		Arrays.sort(MettingTime, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
				
			}
		});
		//끝나는 시간이 짧은거부터 정렬하여 더해주면 된다.
		int end = -1;
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if(MettingTime[i][0] >= end) {
				end = MettingTime[i][1];
				max++;
			}
		}
		
		System.out.println(max);
	}
	
}

package programmersAlgo;

import java.util.*;

/**
 * 체육복 문제 설명 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 * 
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열
 * reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 전체 학생의 수는 2명 이상 30명 이하입니다. 
 * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다. 
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다. 
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
 * 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다. 
 * 입출력 예 
 * n lost reserve return 
 * 5 [2, 4] [1, 3, 5] 5   ==> [2벌,0벌,2벌,0벌,2벌] 이라는 말이다. 즉 , 1~5번 학생들이 가지고 있는 체육복 수량. 
 * 5 [2, 4] [3] 4         ==> [1벌,0벌,2벌,0벌,1벌]
 * 3 [3] [1] 2            ==> [2벌,1벌,0벌]
 * 
 * 입출력 예 설명 
 * 예제 #1 1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
 * 예제 #2 3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
 * 
 * @author jjjwodls
 *
 */

public class Greedy1 {

	public static void main(String[] args) {
		Greedy1 greedy1 = new Greedy1();
		/*int n = 5;
		int[] lost = {2, 3, 4};
		int[] reserve = {3,5};*/ 
		
		int n = 7;
		int[] lost = {2,3,4};
		int[] reserve = {1,2,3,6};
		
		System.out.println(greedy1.solution2(n, lost, reserve));
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		/*List<Integer> lostList = new ArrayList<Integer>();
		List<Integer> reserveList = new ArrayList<Integer>();

		int lostAryLength = lost.length;
		int reserveAryLength = reserve.length;
		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lostAryLength; i++) {
			lostList.add(lost[i]);
		}

		for (int i = 0; i < reserveAryLength; i++) {
			reserveList.add(reserve[i]);
		}

		int idxLost = 0;
		int lostNum = 0;
		int rstCnt = lostAryLength;
		*//**
		 * 5명 // 2 3 4  lost  // 3 5 reserver
			[ 1번 1개 , 2번 0 개 , 3번 1개 , 4번 0개 , 5번 2개 ] 초기 상태 
			[ 1번 1개 , 2번 0 개 , 3번 1개 , 4번 1개 , 5번 1개 ] 결과 상태 총 4명.
		 *//*
		int temp = 0;
		boolean chk = false;
		
		while(true) {
			int k = lostList.get(temp);
			for(int j = 0 ; j < reserveList.size(); j++) {
				if(reserveList.get(j) == k) {
					reserveList.remove(j);
					reserveList.remove(temp);
					chk = true;
					break;
				}
			}
		}
		
		int i = 0;
		int removeIdx = 0;
		boolean chk = false;
		
		while (idxLost < lostAryLength) {
			lostNum = lostList.get(idxLost);
			for (i = 0; i < reserveList.size(); i++) {
				if(reserveList.get(i) == lostNum) { // 자신이 잃어버리고 여유로 1개 있는경우에는 남에게 못빌려준다.
					chk = true;
					removeIdx = i;
					break;
				}else if (reserveList.get(i) - 1 == lostNum || reserveList.get(i) + 1 == lostNum) {
					removeIdx = i;
					chk = true;
				}
			}
			if(chk) {
				reserveList.remove(removeIdx);
				rstCnt --;
			}
			i = 0;
			chk = false;
			idxLost++;
		}
		answer = n - rstCnt;*/

		return answer;
	}
	
	
	public int solution2(int n, int[] lost, int[] reserve) {
		int answer = 0;

		List<Integer> lostList = new ArrayList<Integer>();
		List<Integer> reserveList = new ArrayList<Integer>();

		int lostAryLength = lost.length;
		int reserveAryLength = reserve.length;
		Arrays.sort(lost);
		Arrays.sort(reserve);
		//먼저 내가 잃어버렸는데 남에게 빌려 줄 수 없으므로 그 경우의 수부터 제거한다.
		for(int i = 0 ; i < lostAryLength ; i++) {
			for(int j = 0 ; j < reserveAryLength ; j++) {
				if(lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					break;
				}
			}
		}

		for (int i = 0; i < lostAryLength; i++) {
			if(lost[i] != -1)
				lostList.add(lost[i]);
		}

		for (int i = 0; i < reserveAryLength; i++) {
			if(reserve[i] != -1)
				reserveList.add(reserve[i]);
		}

		int idxLost = 0;
		int lostNum = 0;
		int rstCnt = lostList.size();
		/**
		 * 5명 // 2 3 4  lost  // 3 5 reserver
			[ 1번 1개 , 2번 0 개 , 3번 1개 , 4번 0개 , 5번 2개 ] 초기 상태 
			[ 1번 1개 , 2번 0 개 , 3번 1개 , 4번 1개 , 5번 1개 ] 결과 상태 총 4명.
		 */
		
		while (idxLost < lostList.size()) {
			lostNum = lostList.get(idxLost);
			for (int i = 0; i < reserveList.size(); i++) {
				if (reserveList.get(i) - 1 == lostNum || reserveList.get(i) + 1 == lostNum) {
					reserveList.remove(i);
					rstCnt--;
					break;
				}
			}
			idxLost++;
		}
		answer = n - rstCnt;

		return answer;
	}
}

package programmersAlgo;

import java.util.*;


/**
 * 이중우선순위큐 문제 설명 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
 * 
 * 명령어 수신 탑(높이) 
 * I 숫자 : 큐에 주어진 숫자를 삽입합니다. 
 * D 1  : 큐에서 최댓값을 삭제합니다. 
 * D -1 : 큐에서 최솟값을 삭제합니다.
 * 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
 * 모든 연산을 처리한 후 
 * 큐가 비어있으면 [0,0] 
 * 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 * 
 * 제한사항 operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다. 
 * operations의 원소는 큐가 수행할 연산을 나타냅니다. 
 * 원소는 “명령어 데이터” 형식으로 주어집니다.
 * - 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만
 * 삭제합니다. 
 * 
 * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다. 
 * 입출력 예 
 * operations return 
 * [I 16,D 1] [0,0] 
 * [I 7,I 5,I -5,D -1] [7,5] 
 * 
 * 입출력 예 
 * 설명 16을 삽입 후 최댓값을 삭제합니다. 
 * 비어있으므로 [0,0]을 반환합니다. 
 * 
 * 7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.
 * 
 * HEAP 문제로 우선순위 큐를 사용함.
 * 
 * @author jjjwols
 * 
 * priority Queue 를 두개 사용하여 문제를 해결함. 
 * 문제를 풀 때 좀 더 개선하자면 Integer 타입으로 queue를 만들어도 해결 가능하며 
 * class는 만들필요 없다. 왜냐하면 삭제 시 같은 reference 로 연결된 객체를 삭제하므로 쉽게 해결되는 문제였따.
 * 
 */
public class DoublePriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
		
		//String[] operations = {"I 16","D 1"};
		String[] operations2 = {"I 7","I 5","I -5","D -1"};
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		
		doublePriorityQueue.solution(operations);
		
	}
	
	 /* I 숫자 : 큐에 주어진 숫자를 삽입합니다. 
	 * D 1  : 큐에서 최댓값을 삭제합니다. 
	 * D -1 : 큐에서 최솟값을 삭제합니다.*/
	public int[] solution(String[] operations) {
		int[] answer = {};
	        
		PriorityQueue<DobulePq> minPq = new PriorityQueue<DobulePq>(new Comparator<DobulePq>() {
			@Override
			public int compare(DobulePq o1, DobulePq o2) {
				return o1.value-o2.value;
			}
		});
		
		PriorityQueue<DobulePq> maxPq = new PriorityQueue<DobulePq>(new Comparator<DobulePq>() {
			@Override
			public int compare(DobulePq o1, DobulePq o2) {
				return o2.value-o1.value;
			}
		});
		
		int aryLength = operations.length;
		String[] operation = null;
		int num = 0;
		DobulePq dobulePq = null;
		
		for(int i = 0 ; i < aryLength ; i++) {
			operation = operations[i].split(" ");
			num = Integer.parseInt(operation[1]);
			if(operation[0].equals("I")) {
				dobulePq = new DobulePq(i,num);
				minPq.offer(dobulePq);
				maxPq.offer(dobulePq);
			}else if(operation[0].equals("D")) {
				if(!maxPq.isEmpty() && num == 1) {
					dobulePq = maxPq.remove(); 
					if(!minPq.isEmpty()) {
						minPq.remove(dobulePq); 
					}
				}else if(!minPq.isEmpty() && num == -1){
					dobulePq = minPq.remove();
					if(!maxPq.isEmpty()) {
						maxPq.remove(dobulePq);
					}
					
				}
			}
		}
		
		answer = new int[2];
		if(!maxPq.isEmpty()) {
			answer[0] = maxPq.peek().value;
		}
		
		if(!minPq.isEmpty()) {
			answer[1] = minPq.peek().value;
		}
		
		return answer;
	}
	
	public class DobulePq { //remove 진행 시 offer에서 같은 객체를 가져와 삭제하므로 idx 는 사용하지 않아도 괜찮다.
		
		private int idx;
		private int value;
		
		public DobulePq(int idx, int value) {
			super();
			this.idx = idx;
			this.value = value;
		}

		@Override
		public String toString() {
			return "dobulePq [idx=" + idx + ", value=" + value + "]";
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
	}
	
}

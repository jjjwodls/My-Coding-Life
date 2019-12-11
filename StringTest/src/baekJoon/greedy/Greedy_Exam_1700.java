package baekJoon.greedy;

import java.util.*;

public class Greedy_Exam_1700 {
	
	private static int N;
	private static int K;
	private static int[] ary;
	private static int[] useCheck;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //콘센트 갯수
		K = sc.nextInt(); //제품 사용순번
		
		int possibleCnt = N;
		
		ary = new int[K];
		useCheck = new int[K+1];

		List<Machine> list = new ArrayList<Machine>();
		int[] temp = new int[K+1]; 
		for(int i = 0 ; i < K ; i++) {
			ary[i] = sc.nextInt();
			temp[ary[i]]++;
		}
		for(int i = 0 ; i < temp.length ; i++) {
			if(temp[i] != 0) {
				list.add(new Machine(i, temp[i]));
			}
		}
		Collections.sort(list, new Comparator<Machine>() {
			@Override
			public int compare(Machine o1, Machine o2) {
				return o1.useCnt - o2.useCnt;
			}
		});
		Machine machine = null;
		int min = 0;
		for(int i = 0 ; i < K; i++) {
			if(possibleCnt > 0) {
				useCheck[ary[i]] = 1;
				minusUseCnt(list, ary[i]);
				possibleCnt--;
			}else {
				if(useCheck[ary[i]] == 1) {
					minusUseCnt(list, ary[i]);
				}else {
					int minCnt = 999;
					int idx = 0;
					int k = 0;
					Machine remove = null;
					for(k = 0 ; k < list.size() ; k++) {
						machine = list.get(k);
						if(minCnt > machine.useCnt) {
							minCnt = machine.useCnt;
							idx = machine.idx;
							remove = machine;
						}
					}
					if(minCnt == 0) {
						list.remove(remove);
					}
					
					if(useCheck[idx] == 1) {
						useCheck[idx] = 0;
						useCheck[ary[i]] = 1;
						minusUseCnt(list, ary[i]);
						min ++;
					}
				}
					
			}
		}
		System.out.println(min);
	}
	
	public static class Machine{
		
		public int idx;
		public int useCnt;
		
		public Machine(int idx) {
			super();
			this.idx = idx;
		}
		
		public Machine(int idx, int useCnt) {
			super();
			this.idx = idx;
			this.useCnt = useCnt;
		}

		@Override
		public String toString() {
			return "Machine [idx=" + idx + ", useCnt=" + useCnt + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idx;
			result = prime * result + useCnt;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Machine other = (Machine) obj;
			if (idx != other.idx)
				return false;
			return true;
		}
		
	}
	
	public static void minusUseCnt(List<Machine> list, int paramIdx) {
		Machine machine = new Machine(paramIdx);
		int idx = list.indexOf(machine);
		list.get(idx).useCnt--;
	} 
}

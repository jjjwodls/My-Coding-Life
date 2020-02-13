package codility.lesson4;

import java.util.*;

public class FrogRiverOne {

	public static void main(String[] args) {
//		int [] A  = {1, 3, 1, 3, 2, 1, 3};
//		int X = 3;
		
		int [] A  = {2, 2, 2, 2, 2};
		int X = 2;
		
//		int [] A  = {1, 3, 1, 4, 2, 3, 5, 4};
//		int X = 5;
				
		FrogRiverOne frogRiverOne = new FrogRiverOne();
		System.out.println(frogRiverOne.solution(X, A));
	}
	
	public int solution(int X, int[] A) {
		
		List<Leaf> list = new ArrayList<>();
		
		Map<Integer,Integer> map = new HashMap<>();
		int idx = -1;
		for(int i = 0 ; i < A.length ; i++) {
			list.add(new Leaf(i,A[i]));
			if(A[i] <= X)
				map.put(A[i], i);
		}
		
		for(int i = 1 ; i <= X ; i++) {
			if(map.get(i) == null) {
				return idx;
			}
		}
		
		if(map.get(X) == null) {
			return idx;
		}
		for(Leaf element : list) {
			map.remove(element.getValue());
			if(map.size() == 0) {
				idx = element.getIdx();
				break;
			}
		}
        
		return idx;
    }
	
	public class Leaf{
		
		private int idx;
		private int value;
		
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

		public Leaf(int idx, int value) {
			super();
			this.idx = idx;
			this.value = value;
		}

		@Override
		public String toString() {
			return "leaf [idx=" + idx + ", value=" + value + "]";
		}
		
		
	}
	

}

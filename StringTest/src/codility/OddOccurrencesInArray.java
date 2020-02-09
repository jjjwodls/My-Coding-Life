package codility;

import java.util.*;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int A[] = { 9, 3, 9, 3, 9, 7, 9};

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int aryLen = A.length;

		if (aryLen == 1) {
			return A[0];
		}
		Map<Integer,Integer> map = new HashMap<>();
		Arrays.sort(A);
		Integer getValue = null;
		for(int element : A) {
			getValue = map.get(element);
			if(getValue == null) {
				map.put(element, 1);
			}else {
				map.put(element, getValue+1);
			}
		}
		
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		int result = 0;
		while(it.hasNext()) {
			Integer key = it.next();
			if(map.get(key) % 2 == 1) {
				result = key;
				break;
			}
		}
		

		return result;
	}
}

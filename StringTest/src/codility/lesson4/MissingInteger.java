package codility.lesson4;

import java.util.*;

public class MissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] A) {
		int result = 0;
		Arrays.sort(A);
		int len = A.length;
		if (A[len - 1] <= 0 || (len == 1 && A[0] != 1)) {
			return 1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (A[i] > 0) {
				map.put(A[i], i);
			}
		}
		int search = 1;

		while (map.size() > 0) {
			if (map.get(search) != null) {
				map.remove(search);
				search++;
			} else {
				break;
			}
		}

		return search;

	}
}

package codility.lesson4;

import java.util.*;

public class PermCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] A) {
		int result = 1;
		Arrays.sort(A);
		if(A[0] != 1) {
			return 0;
		}
		
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + 1 != A[i + 1])
				return 0;
		}

		return result;

	}

}

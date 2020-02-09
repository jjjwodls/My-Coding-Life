package codility;

import java.util.*;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] A = {0};
		
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int aryLength = A.length;
		if(aryLength == 0) {
			return 1;
		}
		
		int[] compareAry = new int[aryLength];
		for(int i = 0 ; i < aryLength ; i++) {
			compareAry[i] = i+1;
		}
		
		Arrays.sort(A);
		int result = 0;
		for (int i = 0; i < aryLength; i++) {
			if (A[i] != compareAry[i]) {
				result = compareAry[i];
				break;
			}
		}
		if(result == 0) {
			result = compareAry[aryLength-1] +1;
		}
		

		return result;

	}
}

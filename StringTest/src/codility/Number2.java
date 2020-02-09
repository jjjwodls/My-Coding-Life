package codility;

import java.util.*;

public class Number2 {

	public static void main(String[] args) {

		int[] A = { 5 };
		int K = 4;

		int aryLen = A.length;

//		if (aryLen == 1 || aryLen == K) {
//			for (int temp : A) {
//				System.out.print(temp + " ");
//			}
//		}
		if (K > aryLen) {
			K = K % aryLen;
		}
		List<Integer> list = new ArrayList<>();
		
		for(int element : A) {
			list.add(element);
		}
		Integer getElement = null;
		for(int i = 0 ; i < K ; i++) {
			getElement = list.remove(aryLen-1);
			list.add(0,getElement);
		}
		int[] rstAry = new int[aryLen];
		for(int i = 0 ; i < list.size() ; i++) {
			rstAry[i] = list.get(i);
		}
		
//		int[] ary1 = Arrays.copyOfRange(A, K-1, aryLen);
//		int[] ary2 = Arrays.copyOfRange(A, 0, K-1);
//
//		
//
//		int i;
//		for (i = 0; i < ary1.length; i++) {
//			rstAry[i] = ary1[i];
//		}
//
//		for (int j = 0; j < ary2.length; j++) {
//			rstAry[i] = ary2[j];
//			i++;
//		}

		for (int temp : rstAry) {
			System.out.print(temp + " ");
		}

	}
	
	public static int[] solution(int[] A, int K) {
        
		int aryLen = A.length;

		if (aryLen == 0 || aryLen == K) {
			return A;
		}
		if (K > aryLen) {
			K = K % aryLen;
		}
		List<Integer> list = new ArrayList<>();
		
		for(int element : A) {
			list.add(element);
		}
		Integer getElement = null;
		for(int i = 0 ; i < K ; i++) {
			getElement = list.remove(aryLen-1);
			list.add(0,getElement);
		}
		int[] rstAry = new int[aryLen];
		for(int i = 0 ; i < list.size() ; i++) {
			rstAry[i] = list.get(i);
		}

		return rstAry;
    }

}

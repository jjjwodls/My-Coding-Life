package codility;

import java.util.Arrays;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};
		System.out.println(solution(A));
	}

	
	 public static int solution(int[] A) {
		 int ALen = A.length;
		 
		 int[] resultAry = new int[ALen-1];
		 int resultAryLen = resultAry.length;
		 
		 int sum1 = A[0];
		 int sum2 = 0; 
		 for(int i = 1 ; i < ALen ; i++) {
			 sum2+= A[i];
		 }
		 
		 for(int i = 0 ; i < resultAryLen ; i++) {
			 resultAry[i] = Math.abs(sum1-sum2);
			 sum1 += A[i+1];
			 sum2 -= A[i+1];
		 }
		 Arrays.sort(resultAry);
		 
		 return resultAry[0];
    }
}

package codility.lesson4;

import java.util.*;

public class MaxCounters {

	public static void main(String[] args) {
//		int N = 5;
//		int[] A = {3, 4, 4, 6, 1, 4, 4};
		
		int N = 1;
		int[] A = {2,1,1,2,1};
		MaxCounters counters = new MaxCounters();
		int[] result = counters.solution(N, A);
		for(int rst : result) {
			System.out.println(rst + " ");
		}
	}

	//77점
	public int[] solution(int N, int[] A) {
		
		int[] result = new int[N];
		int max = 0;
		int lastMax = 0;
		for (int i = 0; i < A.length; i++) {
			int element = A[i];
			if (element > N) {
				//Arrays.fill(result, max);
				lastMax = max;
			} else {
				int compare = ++result[element-1];
				if (compare > max)
					max = compare;
			}
		}
		
		for(int i = 0 ; i < result.length ; i++) {
			if(result[i] < lastMax) 
				result[i] = lastMax;
			
		}
		
		return result;

	}
	//100점
	 public int[] solution2(int N, int[] A) {
	        int[] result = new int[N];
			int max = 0;
			int lastMax = 0;
			for (int i = 0; i < A.length; i++) {
				int element = A[i];
				if (element > N) {
					lastMax = max;
				} else {
				    if(result[element-1] < lastMax){
				       result[element-1] = lastMax+1;    
				    }else{
				       result[element-1]++;   
				    }
					
					if (result[element-1] > max)
						max = result[element-1];
				}
			}
			
			for(int i = 0 ; i < result.length ; i++) {
				if(result[i] < lastMax) 
					result[i] = lastMax;
				
			}
			
			return result;
	    }
}

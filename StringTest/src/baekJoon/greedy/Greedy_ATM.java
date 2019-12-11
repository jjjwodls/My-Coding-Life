package baekJoon.greedy;

import java.util.*;

/**
 * ATM 11399
 * 정답
 * @author jjjwodls
 *
 */
public class Greedy_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputCnt = sc.nextInt();
		int[] inputAry = new int[inputCnt+1];
		for(int i = 1 ; i <=inputCnt ; i++) {
			inputAry[i] = sc.nextInt();
		}
		Arrays.sort(inputAry);
		int result = 0;
		for(int i = 1 ; i <= inputCnt ; i++) {
			inputAry[i] = inputAry[i] + inputAry[i-1];
			result += inputAry[i]; 
		}
		
		System.out.println(result);
		
	}

}

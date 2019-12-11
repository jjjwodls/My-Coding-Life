package baekJoon.greedy;

import java.util.*;

/**
 * 동전 0 11047
 * 정답
 * @author jjjwodls
 *
 */
public class Greedy_Coin0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //동전 종류
		int K = sc.nextInt(); //동전들로 만들고자 하는 합
		
		int[] coinValue = new int[N];
		for(int i = 0 ; i < N ; i++) {
			coinValue[i] = sc.nextInt();
		}
		
		int i = 0;
		for(i = N-1 ; i >= 0 ; i--) {
			if(K/coinValue[i] > 0) {
				break;
			}
		}
		int min = 0;
		for(; i >= 0 ; i--) {
		    min += K/coinValue[i];
		    K = K%coinValue[i];
		    if(K == 0) {
		    	break;
		    }
		}
		
		System.out.println(min);
		
	}

}

package baekJoon.greedy;

import java.util.Scanner;
/**
 * 거스름돈 5585
 * 정답
 * @author jjjwodls
 *
 */
public class Greedy_RemainCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int pay = 1000;
		
		int remain = pay-N;
		
		int[] coinAry = {500,100,50,10,5,1};
		int coinAryLen = coinAry.length;
		int i = 0;
		int cnt = 0;
		while(remain != 0) {
			for(; i < coinAryLen ; i++) {
				if(remain/coinAry[i] > 0) {
					cnt += remain/coinAry[i]; 
					remain = remain%coinAry[i];
					i++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}

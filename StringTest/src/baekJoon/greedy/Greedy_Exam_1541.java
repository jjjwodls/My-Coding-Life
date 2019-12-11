package baekJoon.greedy;

import java.util.Scanner;
/**
 * 런타임 에러로 스킵
 * @author jjjwodls 
 *
 */
public class Greedy_Exam_1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next(); //입력받은 연산값.
		
		String[] ary = input.split("\\-");
		int sum = Integer.parseInt(ary[0]);
		String[] tempAry = null;
		for(int i = 1 ; i < ary.length ; i++) {
			tempAry = ary[i].split("\\+");
			for(int j = 0 ; j < tempAry.length; j++) {
				sum -= Integer.parseInt(tempAry[j]);
			}
		}
		System.out.println(sum);
	}

}

package baekJoon.greedy;

import java.util.Scanner;

/**
 * 쉽게 정답 맞춤 
 * 문자열 이동하면서 비교 할 때 마다 갯수를 세고 가장 적은 갯수를 반환
 * @author jjjwodls
 *
 */
public class Greedy_Exam_1120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputAry = input.split(" ");
		char[] input1 = inputAry[0].toCharArray();
		char[] input2 = inputAry[1].toCharArray();
		int min = 9999;
		int cnt = 0;
		int idx = 0;
		for(int i = 0 ; i < input2.length-input1.length+1 ;i++) {
			for(int j = 0 ; j < input1.length ; j++) {
				if(input2[i+j] != input1[j]) {
					cnt++;
				}
			}
			if(cnt < min) {
				min = cnt;
				idx = i;
			}
			cnt = 0;
		}
		
		System.out.println(min);
		
	}

}

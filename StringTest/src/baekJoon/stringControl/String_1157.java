package baekJoon.stringControl;

import java.util.Scanner;

public class String_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] ary = input.toCharArray();
		int result[] = new int[26];
		int aryLen = ary.length;
		for(int i = 0 ; i < aryLen ; i++) {
			if(ary[i] - 97 >= 0) { //소문자
				result[ary[i] - 97]++;
			}else if(ary[i] - 65 >= 0) { // 대문자
				result[ary[i] - 65]++;
			}
		}
		
		int max = -1;
		int maxIdx = -1;
		
		for(int i = 0 ; i < result.length ; i++) {
			if(max < result[i]) {
				max = result[i];
				maxIdx = i;
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < result.length ; i++) {
			if(max == result[i]) {
				cnt++;
			}
		}
		
		if(cnt > 1) {
			System.out.println("?");
		}else {
			char rst = (char) ('A' + maxIdx);
			System.out.println(rst);
		}
		
	}
	
	

}

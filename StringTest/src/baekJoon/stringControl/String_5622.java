package baekJoon.stringControl;

import java.util.Scanner;

public class String_5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char inputAry[] = input.toCharArray();
		int aryLength = input.length();
		int cnt = 0;
		for(int i = 0 ; i < aryLength ; i++) {
			char cur = inputAry[i];
			int dial = 0;
			if(cur == 'S' || cur == 'V' || cur >= 'Y') {
				dial = cur-'A';
				dial = dial/3 +2;
			}else {
				dial = cur-'A';
				dial = dial/3 +3;
			}
			cnt+= dial;
		}
		System.out.println(cnt);
			
		
	}
	
	

}

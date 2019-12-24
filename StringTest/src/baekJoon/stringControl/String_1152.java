package baekJoon.stringControl;

import java.util.Scanner;
import java.util.StringTokenizer;

public class String_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(input, " ");//오직 구분자는 다 제거하고 순수 문자열만 취급
		System.out.println(st.countTokens());
		String test[] = input.split(" ");
		System.out.println(test.length);// split 을 하게되면 첫번째 구분자의 앞의 문자열도 취급하므로 주의
	}

}

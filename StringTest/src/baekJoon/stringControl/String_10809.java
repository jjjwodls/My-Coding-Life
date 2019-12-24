package baekJoon.stringControl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class String_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] ary = input.toCharArray();
		int[] result = new int[26];
		Arrays.fill(result, -1);
		char check = '0';
		for(int i = 0 ; i < ary.length ; i++) {
			check = ary[i];
			if(input.indexOf(check) >= 0) {
				result[check-97] = input.indexOf(check);
			}
		}
		
		for(int rst : result) {
			System.out.print(rst +" ");
		}
	}

}

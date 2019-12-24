package baekJoon.stringControl;

import java.util.Scanner;

public class String_2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		String aToStr = String.valueOf(A);
		String bToStr = String.valueOf(B);
		int strLen = aToStr.length();
		
		String rst1 = "";
		String rst2 = "";
		for(int i = strLen-1 ; i >= 0 ; i--) {
			rst1 += aToStr.charAt(i);
			rst2 += bToStr.charAt(i);
		}
		Integer strToa = Integer.parseInt(rst1);
		Integer strTob = Integer.parseInt(rst2);
		
		if(strToa > strTob) {
			System.out.println(strToa);
		}else {
			System.out.println(strTob);
		}
			
		
	}
	
	

}

package baekJoon.implement;

import java.util.*;

public class Implement_5543 {
	
	private static int BUGGER_MIN = Integer.MAX_VALUE;
	private static int DRINK_MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		for(int i = 0 ; i < 3 ; i++) {
			n = sc.nextInt();
			if(n < BUGGER_MIN) 
				BUGGER_MIN = n;
			
		}
		
		for(int i = 0 ; i < 2 ; i++) {
			n = sc.nextInt();
			if(n < DRINK_MIN)
				DRINK_MIN = n;
		}
		
		System.out.println((BUGGER_MIN+DRINK_MIN)-50);
		
		
	}
	
}

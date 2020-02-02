package baekJoon.implement;

import java.util.*;

public class Implement_10872 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(factorial(N));
		
	}
	
	public static int factorial(int N) {
		if(N == 0) {
			return 1;
		}
		int result = N*factorial(N-1);
		return result;
	}
}

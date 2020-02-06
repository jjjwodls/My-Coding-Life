package baekJoon.implement;

import java.util.*;

//소수 구하기
public class Implement_4948 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int n2 = n*2;
		while(n > 0) {
			int cnt = 0;
			for(int i = n+1 ; i <= n2 ; i++) {
				if(isPrime(i))
					cnt++;
			}
			System.out.println(cnt);
			n = sc.nextInt();
			n2 = n*2;
		}
	}
	
	public static boolean isPrime(int n) {
		boolean rst = true;
		for(int i = 2 ; i*i <= n ; i++) { //제곱으로 나눠주는게 가장 빠름.
			if(n%i == 0) {
				rst = false;
				break;
			}
		}
		return rst;
	}
	
}

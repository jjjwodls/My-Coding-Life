package baekJoon.implement;

import java.util.*;

public class Implement_2577 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		char[] result = String.valueOf(A*B*C).toCharArray();
		int length = result.length;
		int cnt = 0;
		for(int i = 0 ; i < 10 ; i++) {
			for(int j = 0; j < length ; j++) {
				if(result[j]-'0' == i)
					cnt++;
			}
			System.out.println(cnt);
			cnt = 0;
		}
		
		
	}
}

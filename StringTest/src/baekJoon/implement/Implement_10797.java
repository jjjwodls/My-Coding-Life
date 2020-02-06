package baekJoon.implement;

import java.util.*;

public class Implement_10797 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String[] number = sc.nextLine().split(" ");
		int cnt = 0;
		for(int i = 0 ; i < number.length ; i++) {
			if(Integer.parseInt(number[i]) == n)
				cnt++;
		}
		System.out.println(cnt);
	}
	
}

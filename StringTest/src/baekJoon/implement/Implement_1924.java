package baekJoon.implement;

import java.util.*;

public class Implement_1924 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int temp = 0;
		sc.nextLine();
		String[] input = sc.nextLine().split(" ");
		for(int i = 0 ; i < N ; i++) {
			temp = Integer.parseInt(input[i]);
			if(temp < X)
				System.out.print(temp + " ");
		}
	}
}

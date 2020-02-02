package baekJoon.implement;

import java.util.*;

public class Implement_10039 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int score = 0;
		for(int i = 0 ; i < 5 ; i++) {
			score= sc.nextInt();
			if(score<40) {
				sum += 40;
			}else {
				sum += score;
			}
		}
		
		System.out.println(sum/5);
	}
}

package baekJoon.implement;

import java.util.*;

public class Implement_2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 0;
		int N_5kg = N;
		int N_3kg = N;
		int result = 0;
		while(true) {
			N_5kg = N-5*i;
			int kg_5 = (N_5kg)/5;
			int kg_5mod = N_5kg%5;
			if(kg_5mod == 0) {
				result = kg_5;
				break;
			}
			N_3kg = kg_5mod + 5*i;
			int kg_3 = N_3kg/3;
			int kg_3mod = N_3kg%3;
			if(kg_3mod == 0) {
				result = kg_5 + kg_3;
				break;
			}
			if(N_3kg == N) {
				result = -1;
				break;
			}
			i++;
		}
		
		System.out.println(result);
		
	}
}

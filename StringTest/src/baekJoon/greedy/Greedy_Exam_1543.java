package baekJoon.greedy;

import java.util.Scanner;

//라빈카프 알고리즘을 통해 해결함.
public class Greedy_Exam_1543 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String M = sc.nextLine(); //문서
		String P = sc.nextLine(); //패턴
		
		int power = 1;
		
		int docLength = M.length();
		int patternLen = P.length();
		int docHash = 0;
		int patternHash = 0;
		int cnt = 0;
		
		for(int i = 0 ; i < docLength - patternLen+1; i++) {
			
			if(i == 0) {
				for(int j = 0 ; j < patternLen ; j++) {
					docHash += (M.charAt(patternLen-1-j))*power;
					patternHash += (P.charAt(patternLen-1-j))*power;
					power *= 2;
				}
			}else {
				int searchLen = i + patternLen;
				power = 1;
				String temp = "";
				docHash = 0;
				for(int j = 0 ; j < patternLen ; j++) {
					temp += M.charAt(searchLen-j-1);
					docHash += (M.charAt(searchLen-j-1))*power;
					power *= 2;
				}
				System.out.println(temp);
			}
			if(docHash == patternHash) {
				boolean flag = true;
				for(int k = 0 ; k < patternLen ; k++) {
					if(M.charAt(k+i) != P.charAt(k)) {
						flag = false;
					}
				}
				if(flag) {
					cnt++;
					i = i + patternLen -1;
				}
			}
			
		}
		System.out.println(cnt);
		
		
	}
}

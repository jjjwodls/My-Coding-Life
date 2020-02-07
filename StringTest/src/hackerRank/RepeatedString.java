package hackerRank;

import java.util.Scanner;

public class RepeatedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		long n = sc.nextLong();
		System.out.println(repeatedString(s,n));
	}

	
	static long repeatedString(String s, long n) {
		int stringLen = s.length();
		char firstString = 'a';
		int cnt = 0;
		for(int i = 0 ; i < stringLen ; i++) {
			if(s.charAt(i) == firstString)
				cnt++;
		}
		
		long modLength = n%stringLen;
		long totalCnt = (n/stringLen)*cnt;
		
		for(int i = 0 ; i < modLength ; i++) {
			if(s.charAt(i) == firstString)
				totalCnt++;
		}
        
		return totalCnt;
    }
}

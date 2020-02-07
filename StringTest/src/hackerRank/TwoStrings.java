package hackerRank;

import java.util.*;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		sc.nextLine();
		int cnt = 0;
		for(int i = 0 ; i < m ; i++) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			
			System.out.println(twoStrings(s1, s2));
		}
		
	}

	static String twoStrings(String s1, String s2) {
        boolean flag = false;
        String result;
        int cnt = 0;
        char checkChar = 'a';
        for(int i = 1 ; i < 27 ; i++) {
        	if(s1.indexOf(checkChar) > -1) {
        		cnt++;
        	}
    		if(s2.indexOf(checkChar) > -1) {
    			cnt++;
    		}
    		
    		if(cnt == 2) {
    			flag = true;
    			break;
    		}
        	cnt = 0;
        	checkChar++;
        }
        if(flag)
            result = "YES";
        else
            result = "NO";

        return result;

    }
	

}

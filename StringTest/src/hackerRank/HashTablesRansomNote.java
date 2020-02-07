package hackerRank;

import java.util.*;

public class HashTablesRansomNote {

	private static int m;
	private static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		sc.nextLine();
		String magazine[] = sc.nextLine().split(" ");
		String note[] = sc.nextLine().split(" ");
		checkMagazine(magazine, note);
	}
	
	 static void checkMagazine(String[] magazine, String[] note) {
		 boolean flag = true;
		 int m = magazine.length;
		 int cnt = 0;
		 for(String str : note) {
			 for(int i = 0 ; i < m ; i++) {
				 if(magazine[i].equals(str)) {
					 magazine[i] = "";
					 cnt++;
					 break;
				 }
			 }
			 if(cnt == 0) {
				 System.out.println("No");
				 flag = false;
				 break;
			 }
			 cnt = 0;
		 }
		 if(flag) {
			 System.out.println("Yes");
		 }
		 
    }

}

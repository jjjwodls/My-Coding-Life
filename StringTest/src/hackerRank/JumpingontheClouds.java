package hackerRank;

import java.util.Scanner;

public class JumpingontheClouds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int ary[] = new int[r];
		sc.nextLine();
		String num[] = sc.nextLine().split(" ");
		for(int i = 0 ; i < r ; i++) {
			ary[i] = Integer.parseInt(num[i]);
		}
		
		System.out.println(jumpingOnClouds(ary));
		
	}
	
	static int jumpingOnClouds(int[] c) {
        int cnt = 0;
        int i = 0;
        for(i = 0; i < c.length-1 ; i++){
        	if(i+2 != c.length && c[i+2] != 1) {
        		i++;
                cnt++;
        	}else {
        		cnt++;
        	}
        }

        return cnt;

    }

}

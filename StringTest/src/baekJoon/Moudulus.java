package baekJoon;

import java.util.Scanner;
/**
 * baekjoon 10430
 * @author JJI
 *
 */
public class Moudulus {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int A = sc.nextInt();
	        int B = sc.nextInt();
	        int C = sc.nextInt();
	        
	    System.out.println((A+B)%C);
	    System.out.println((A%C + B%C)%C);
	    System.out.println((A*B)%C);
	    System.out.println((A%C * B%C)%C);
	        
	}

}

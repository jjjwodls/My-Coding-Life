package baekJoon;

import java.util.Scanner;

/**
 * ExamNumber 1934
 * 
 * 입력되는 행의 갯수만큼 최소공배수 고하기
 * @author JJI
 *
 */
public class HCF {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCnt = sc.nextInt();
		
		int firstInput;
		int secondInput;
		int r = 1;
		int originA;
		int originB;
		int LCM; //최소공배수
		
		for(int i = 0 ; i < testCnt ; i++){
			firstInput = sc.nextInt();
			secondInput = sc.nextInt();
			
			
			originA = firstInput;
			originB = secondInput;
			
			if(firstInput < secondInput){
				firstInput = originB;
				secondInput = originA;
			}
			
			while(r>0){
				r = firstInput%secondInput;
				firstInput = secondInput;
				secondInput = r;
			}
			
			LCM = originA*originB/firstInput;
			
			System.out.println(LCM);
			r=1;
		}
	}
}

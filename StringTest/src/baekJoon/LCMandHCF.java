package baekJoon;

import java.util.Scanner;

/**
 * baekjoon 2609 
 * 
 * LCM is lowest common multiple (최소공배수) HCF is highest common factor (최대공약수)
 * 
 * 두수의 곱 = 최대공약수 * 최소공배수 와 같음.
 * 
 * @author JJI
 * 유클리드 호제법
 * 1. 두 수를 입력받는다.
 * 
 * 2. 두 수중 큰수와 작은수를 구분한다.
 * 
 * 3. 두 수를 나눈 나머지가 0일때 까지 큰수와 작은수를 나눈다.
 * 
 * 4.나머지가 0이 되는 순간 큰수가 최대공약수이다.
 * 
 * 5.처음 입력받은 두수의 곱을 최대공약수로 나누면 최소공배수가된다.
 * 
 */
public class LCMandHCF {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int LCM; //최소공배수
		int r = 1;
		
		int originA = a;
		int originB = b;
		
		if(a < b){
			a = originB;
			b = originA;
		}
		
		while(r>0){
			r = a%b;
			a = b;
			b = r;
		}
		
		LCM = originA*originB/a;
		
		System.out.println(a);
		System.out.println(LCM);
		
		
	}
}

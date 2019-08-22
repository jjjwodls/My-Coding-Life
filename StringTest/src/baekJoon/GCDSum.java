package baekJoon;

import java.util.Scanner;

/**
 * 값들의 합이 int 범위를 넘어서면 long 을 써야한다.
 * 따라서 어떤 primitive 타입을 사용 할 지 문제의 조건을 확인하고 진행하자.
 * 
 * @author JJI
 *
 */
public class GCDSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		int lineTestCnt;
		
		long firstInput;
		long secondInput;
		long r = 1;
		long originA;
		long originB;
		
		long sumOfGCM = 0;
		
		long [] GCDAry = null;
		
		for(int i = 0 ; i < testCaseCnt ; i++){
			lineTestCnt = sc.nextInt();
			GCDAry = new long[lineTestCnt];
			
			for(int j = 0 ; j < lineTestCnt; j++){
				GCDAry[j] = sc.nextInt();
			}
			for(int j = 0 ; j < lineTestCnt-1 ; j++){
				for(int k = j+1 ; k < lineTestCnt; k++){
					firstInput = GCDAry[j];
					secondInput = GCDAry[k];
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
					sumOfGCM  += firstInput;
					r = 1;
				}
			}
			System.out.println(sumOfGCM);
			sumOfGCM = 0;
			r = 1;
		}
	}

}

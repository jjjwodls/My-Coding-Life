package baekJoon;

import java.util.Scanner;

public class GCDSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		int lineTestCnt;
		
		int firstInput;
		int secondInput;
		int r = 1;
		int originA;
		int originB;
		
		int sumOfGCM = 0;
		
		int [] GCDAry = null;
		
		for(int i = 0 ; i < testCaseCnt ; i++){
			lineTestCnt = sc.nextInt();
			GCDAry = new int[lineTestCnt];
			
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

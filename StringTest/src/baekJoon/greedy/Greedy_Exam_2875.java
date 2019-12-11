package baekJoon.greedy;

import java.util.Scanner;

/**
 * 
 * 쉽게 성공
 * @author jjjwodls
 *
 */
public class Greedy_Exam_2875 {

	private static int N, M, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //여학생
		M = sc.nextInt(); //남학생
		K = sc.nextInt(); //인턴쉽에 참여해야 하는 학생수
		//MAX 팀을 구해라. 팀은 2N * M = 1팀 
		// 총 학생 수 = N + M 
		int totalPeople = N + M;
		
		while(K > 0) {
			if(N >= 2*M) {
				N--;
				K--;
			}else {
				M--;
				K--;
			}
		}
		
		System.out.println(Math.min(N/2, M));
		
	}

}

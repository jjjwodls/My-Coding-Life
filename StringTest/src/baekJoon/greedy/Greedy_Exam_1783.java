package baekJoon.greedy;

import java.util.Scanner;

/**
 * 
 * @author jjjwodls
 * 조건 절 하나 실수했지만 그래도 얼추 정답.
 */
public class Greedy_Exam_1783 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //행크기
		int M = sc.nextInt(); //열크기
		int curY = 1;
		int cnt = 1;
		
		if(N == 1) {
			cnt = 1;
		}else if(N == 2) {
			while(curY + 2 <= M && cnt < 4) {
				curY += +2;
				cnt++;
			}
		}else {
			if(M< 7){
				cnt = Math.min(4, M); 
			}else {
				cnt = M-2;
			}
		}
		System.out.println(cnt);
	}
}

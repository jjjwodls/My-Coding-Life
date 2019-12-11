package baekJoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2차원 배열을 사용하지 말고 단일 배열을 사용해서 정렬하자.
 * 2차원 배열 정렬 시 뭔가 문제가 발생하는듯 한데 아직은 잘 모르겠다.
 * @author jjjwodls
 *
 */
public class Greedy_Exam_1049 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //끊어진 기타줄
		int M = sc.nextInt(); //브랜드 갯수
		int[] pack = new int[M];
		int[] unit = new int[M];
		
		for(int i = 0 ; i < M ; i++) {
			pack[i] = sc.nextInt();
			unit[i] = sc.nextInt();
		}
		Arrays.sort(pack);
		int packageMin = pack[0];
		Arrays.sort(unit);
		int unitMin = unit[0];
		
		int min = 1000000000;
		min = Math.min(((N/6)+1)*packageMin, N*unitMin);
		min = Math.min(min, (N/6)*packageMin + (N%6)*unitMin);
		
		System.out.println(min);
		
	}

}

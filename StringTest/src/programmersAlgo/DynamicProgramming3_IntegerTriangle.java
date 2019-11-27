package programmersAlgo;

import java.util.Arrays;

/**
 * 정수 삼각형 문제 설명  
 * 
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는
 * 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 * 
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를
 * 완성하세요.
 * 
 * 제한사항 삼각형의 높이는 1 이상 500 이하입니다. 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다. 입출력 예
 * triangle result 
 * [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]] 30
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43105 문제 참고
 * 정답 제대로 확인
 * @author jjjwodls
 *
 */
public class DynamicProgramming3_IntegerTriangle {
	
	private int[][] memory = null;

	public static void main(String[] args) {
		int[][] triangle = {{7,0,0,0,0}, {3, 8,0,0,0}, {8, 1, 0,0,0}, {2, 7, 4, 4,0}, {4, 5, 2, 6, 5}};
		DynamicProgramming3_IntegerTriangle dynamicProgramming3_IntegerTriangle = new DynamicProgramming3_IntegerTriangle();
		int rst = dynamicProgramming3_IntegerTriangle.solution2(triangle);
		System.out.println(rst);
		
	}	
	
	public int solution(int[][] triangle) {
		int answer = 0;
		
		int triangleLength = triangle.length;
		int colLength = (int) Math.pow(2, triangleLength-1);
		memory = new int[triangleLength][colLength];
		memory[0][0] = triangle[0][0];
		int k = 0;
		int l = 0;
		int loopCnt = 1;
		for(int i = 1 ; i< triangleLength; i++) {
			k=0;//k 만큼 안돌수도 있으므로 생각을 해야된다. 
			l=0;
			for(int j = 0 ; j < loopCnt ; j++) {
				memory[i][k++] = memory[i-1][j] + triangle[i][l++];
				memory[i][k++] = memory[i-1][j] + triangle[i][l];
			}
			loopCnt *= 2;
		}
		int[] resultArray = Arrays.copyOf(memory[triangleLength-1],memory[triangleLength-1].length);
		Arrays.sort(resultArray);
		answer = resultArray[resultArray.length-1];
		
		return answer;
	}
	//이게 정답이며 삼각형을 채워 나갈 때 점점 큰 수들로 채워나가며 마지막에 정렬을 통해 최대로 큰 값을 리턴하는 방식이다.
	public int solution2(int[][] triangle) {
		int answer = 0;
		
		int triangleLength = triangle.length;
		memory = new int[triangleLength][triangleLength];
		memory[0][0] = triangle[0][0];
		int loopCnt = 1;
		
		int compare1 = 0;
		int compare2 = 0;
		
		for(int i = 1 ; i< triangleLength; i++) {
			loopCnt= triangle[i].length;
			memory[i][0] = memory[i-1][0] + triangle[i][0];
			for(int j = 1 ; j < loopCnt ; j++) {
				compare1 = memory[i-1][j-1] + triangle[i][j];
				compare2 = memory[i-1][j] + triangle[i][j];
				if(compare1 > compare2) {
					memory[i][j] = compare1;
				}else {
					memory[i][j] = compare2;
				}
			}
		}
		int[] resultArray = Arrays.copyOf(memory[triangleLength-1],memory[triangleLength-1].length);
		Arrays.sort(resultArray);
		answer = resultArray[resultArray.length-1];
		
		return answer;
	}

}

package programmersAlgo;

/**
 * 그림에서 타일에 적힌 수는 각 타일의 한 변의 길이를 나타낸다. 타일 장식물을 구성하는 정사각형 타일 한 변의 길이를 안쪽 타일부터
 * 시작하여 차례로 적으면 다음과 같다. [1, 1, 2, 3, 5, 8, .] 지수는 문득 이러한 타일들로 구성되는 큰 직사각형의 둘레가
 * 궁금해졌다. 예를 들어, 처음 다섯 개의 타일이 구성하는 직사각형(위에서 빨간색으로 표시한 직사각형)의 둘레는 26이다.
 * 
 * 타일의 개수 N이 주어질 때, N개의 타일로 구성된 직사각형의 둘레를 return 하도록 solution 함수를 작성하시오.
 * 
 * 제한 사항 N은 1 이상 80 이하인 자연수이다. 
 * 
 * 입출력 예
 *  N return 
 *  5 26 
 *  6 42
 * 
 * @author jjjwodls
 * 
 * 문제 패턴을 확인하고 피보나치 수열 방식과 비슷하여 recursive를 활용하고 결과값을 도출.
 *
 */
public class DynamicProgramming2_TilePerimeter {

	private long[] memoization = new long[100];

	public long solution(int N) {
		long answer = 0;
		caculate(N);
		answer = (memoization[N]+memoization[N-1])*2 + memoization[N]*2;
		
		return answer;
	}

	public long caculate(int num) {

		if (num == 1 || num == 2) {
			return memoization[num] = 1;
		}
		if (memoization[num] != 0) {
			return memoization[num];
		}
		memoization[num] = caculate(num - 2) + caculate(num - 1);
		return memoization[num];
	}

	public static void main(String[] args) {
		DynamicProgramming2_TilePerimeter dynamicProgramming2_TilePerimeter = new DynamicProgramming2_TilePerimeter();
		long rst = dynamicProgramming2_TilePerimeter.solution(6);
		System.out.println(rst);
	}	

}

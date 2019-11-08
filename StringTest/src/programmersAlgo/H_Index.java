package programmersAlgo;

import java.util.Arrays;

/**
 * 문제 설명 H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고
 * 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의
 * H-Index입니다.
 * 
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return
 * 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다. 
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다. 
 * 입출력 예 
 * citations return [3, 0, 6, 1, 5] 
 * return : 3 
 * 입출력 예 설명 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의
 * 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 * 
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 * 
 * @author jjjwodls
 *
 */
public class H_Index {

	public static void main(String[] args) {
		//int[] ary = {5, 0, 6, 1, 5,2,7,4,3,5,6};
		int[] ary = {4,4,4,4,3};
		//int[] ary = {3,0,6,1,5};
		//int[] ary = {1,2,2,6,6,6,6,5,5,7,7,7,7,9,9,8}; //test case 고름. 근데 이건 큰쪽일경우. 작은쪽도 구해야됨. 
		System.out.println(solution(ary));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		int answer2 = 0;
		
		int length = citations.length;
		int mid = length/2;
		Arrays.sort(citations);
		int idxValue = citations[mid]; // 선택한 값에서 max value 찾기.
		int curIdx = mid;
		int curIdxValue = idxValue;
		
		while(curIdx < length) {
			if((length - curIdx) >= idxValue && idxValue > answer) {
				answer = idxValue;
			}
			curIdxValue++;
			curIdx++;
			idxValue = citations[curIdx];
		}
		curIdx = mid;
		while(curIdx > -1) {
			idxValue = citations[curIdx];
			if((length - curIdx) >= idxValue && idxValue > answer2) {
				answer2 = idxValue;
			}
			curIdx--;
		}
		
		if(answer < answer2) {
			answer = answer2;
		}
		
		return answer;
	}
	
/*	 
 * 패턴은 찾았지만 완벽하게 문제를 이해하는데 오래걸렸다. 그리고 최소값, 최대값을 구하는 Math.max, Math.min 을 잘 활용하면 문제푸는데 속도가 더 향상할거같다.
 * Arrays.sort(citations);

     int max = 0;
     for(int i = citations.length-1; i > -1; i--){
         int min = (int)Math.min(citations[i], citations.length - i);
         if(max < min) max = min;
     }

     return max;*/
}

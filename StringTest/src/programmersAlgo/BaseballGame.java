package programmersAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다.
 * 
 * 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로
 * 상대가 정한 숫자를 예상한 뒤 맞힙니다.
 * 
 * 숫자는 맞지만, 위치가 틀렸을 때는 볼 숫자와 위치가 모두 맞을 때는 스트라이크 숫자와 위치가 모두 틀렸을 때는 아웃 예를 들어, 아래의
 * 경우가 있으면
 * 
 * A : 123 B : 1스트라이크 1볼. 
 * A : 356 B : 1스트라이크 0볼. 
 * A : 327 B : 2스트라이크 0볼. 
 * A : 489 B : 0스트라이크 1볼. 
 * 이때 가능한 답은 324와 328 두 가지입니다.
 * 
 * 질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 질문의 수는 1 이상 100 이하의 자연수입니다. baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를
 * 담고 있습니다. 입출력 예 
 * baseball 										 return 
 * [[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] 2 입출력 예 설명 문제에 나온 예와 같습니다.
 * 
 * 걍 하드코딩으로 처리..
 * 
 * @author jjjwodls
 *
 */
public class BaseballGame {

	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}
	
	public static int solution(int[][] baseball) {
		int answer = 0;
		int aryLength = baseball.length;
		String aryVal = null ;
		int strike = 0;
		int ball = 0;
		String checkVal = "";
		for(int i = 1 ; i < 10 ; i++) {
			for(int j = 1 ; j < 10 ; j++) {
				for(int k = 1 ; k < 10 ; k++) {
					if(i!=j && i!=k && j!=k){
						checkVal = String.valueOf((i*100) + (j*10) + k);
						boolean temp = true;
						for(int m = 0; m < aryLength ; m++) {
							strike = 0;
							ball = 0;
							aryVal = String.valueOf(baseball[m][0]);
							for(int n = 0 ; n < aryVal.length() ; n++) {
								if(aryVal.indexOf(String.valueOf(checkVal.charAt(n))) >= 0) {
									if(aryVal.charAt(n) == checkVal.charAt(n)) {
										strike++;
									}else {
										ball++;
									}
								}
							}
							if(strike != baseball[m][1] || ball != baseball[m][2]) {
								temp = false;
								break;
							}
						}
						if(temp) 
							answer++;
					}
					
				}	
			}
		}
		return answer;
		
		//searchBassball(baseball,strike,visited,0,aryLength,2);
	}
	
	/*public static void searchBassball(int[][] baseball,int[] strike,boolean[] visited,int start, int n , int r) {
		if(r == 0) {
			int [][] arr = new int [2][3];
			int k = 0;
			for(int i = 0 ; i < n ; i ++) {
				if(visited[i]) {
					arr[k] = baseball[i];
					k++;
				}
			}
			int[] checkArr = arr[0];
			int[] checkArr1 = arr[1];
			String temp = String.valueOf(checkArr[0]);
			String temp1= String.valueOf(checkArr1[0]);
			if(checkArr[1] > 0 && checkArr1[1] > 0) {
				for(int i = 0 ; i < temp.length() ; i++) {
					if(temp.charAt(i) == temp1.charAt(i)) {
						strike[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
					}
				}
			}
		}else {
			for(int i = start ; i < n ; i ++) {
				visited[i] = true;
				searchBassball(baseball,strike,visited,i+1,n,r-1); //자신의 탐색은 제거하기 위해 i+1 부터 시작함.
				visited[i] = false;	
			}
		}
	}*/
	// 1) r = 2 0 searchBassball 
	// 2) r = 1 0 들어가있고  for 문 1 대입 searchBassball
	// 3) r = 0 출력 0 , 1 return 
	// 2) 상태로 복귀 후 i = 1 상태에서 visted[1] = false;
	// 2) i = 2 에서 visted[2] = true; 후 searchBassball
	// 4) r = 0 이므로 출력 후 return 0, 2 출력
	// 2) i = 2 에서 visted[2] = false; 후 i++; 
	// 2) i = 3 에서 visted[3] = true; 후 searchBassball
	// 5) r = 0 이므로 출력 후 return 0, 3 출력
	// 2) for 문 종료 후 다시 1) 로 복귀
	// 1) r = 2 visted[0] = false; 수행 후 i++;
	// 1) visted[1] = true 입력 후 searchBassball 실행.
	// 6) 가면 다시  visted[0] = false 상태이므로 visted[0] = true 로 변경 후 searchBassball... 여기서 잘못.	

}

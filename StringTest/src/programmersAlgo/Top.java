package programmersAlgo;

import java.util.*;

/**
 * 탑 
 * 
 * 문제 설명 
 * 
 * 수평 직선에 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 발사한 신호는 신호를 보낸
 * 탑보다 높은 탑에서만 수신합니다. 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.
 * 
 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 
 * 그러면, 탑은 다음과 같이 신호를 주고받습니다. 
 * 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는 높이가
 * 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 높이가 9인 두 번째 탑과 높이가 6인 첫
 * 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.
 * 
 * 송신 탑(높이) 수신 탑(높이) 
 * 5(4) 4(7)              =>5번째 (4) , 4번째 (7)
 * 4(7) 2(9) 
 * 3(5) 2(9) 
 * 2(9) - 
 * 1(6) - 
 * 맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 
 * 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항 heights는 길이 2 이상 100 이하인 정수 배열입니다. 
 * 모든 탑의 높이는 1 이상 100 이하입니다. 
 * 신호를 수신하는 탑이 없으면 0으로 표시합니다. 
 * 입출력 예 
 * heights return 
 * [6,9,5,7,4] [0,0,2,2,4] => return 은 배열 idx 가 아닌 순서로 리턴한다.(몇 번째 탑인지)
 * [3,9,9,3,5,7,2] [0,0,0,3,3,3,6] 
 * [1,5,3,6,7,6,5] [0,0,2,0,0,5,6] 
 * 
 * 입출력 예 설명 입출력 예 #1 앞서 설명한 예와 같습니다.
 * 
 * 입출력 예 #2
 * 
 * [1,2,3] 번째 탑이 쏜 신호는 아무도 수신하지 않습니다. 
 * [4,5,6] 번째 탑이 쏜 신호는 3번째 탑이 수신합니다. 
 * [7] 번째 탑이 쏜 신호는 6번째 탑이 수신합니다.
 * 
 * 입출력 예 #3
 * 
 * [1,2,4,5] 번째 탑이 쏜 신호는 아무도 수신하지 않습니다. 
 * [3] 번째 탑이 쏜 신호는 2번째 탑이 수신합니다. 
 * [6] 번째 탑이 쏜 신호는 5번째 탑이 수신합니다. 
 * [7] 번째 탑이 쏜 신호는 6번째 탑이 수신합니다.
 * 
 * @author jjjwodls
 *
 */
public class Top {

	public static void main(String[] args) {
		//int [] heights = {6,9,5,7,4};
		int [] heights = {3,9,9,3,5,7,2};
		Top top = new Top();
		int[] answer = top.solution(heights);
		for(int rst : answer) {
			System.out.println(rst);
		}
		
	}

	public int[] solution(int[] heights) {
		int[] answer = {};
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0 ; i < heights.length; i++) {
			stack.push(heights[i]);
		}
		Stack<Integer> answerStack = new Stack<Integer>();
		
		while(!stack.isEmpty()) {
			int topValue = stack.pop();
			int maxPosition = 0;
			
			for(int i = 0 ; i < stack.size(); i++) {
				if(stack.get(i) > topValue) {
					maxPosition = i+1;
				}
			}
			answerStack.push(maxPosition);
			
		}
		answer = new int[answerStack.size()];
		
		for(int i = 0 ; i< answer.length; i++ ) {
			answer[i] = answerStack.pop();
		}
		
		return answer;
	}
	
	

}

package programmersAlgo;

import java.util.*;

/**
 * 큰 수 만들기 문제 설명 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰
 * 숫자는 94 입니다.
 * 
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를
 * 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한 조건 number는 1자리 이상, 1,000,000자리 이하인 숫자입니다. 
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 
 * 입출력 예 
 * number 		k 	return 
 * 1924   		2  	94 
 * 1231234 		3 	3234 
 * 4177252841 	4 	775841
 * 
 * @author jjjwodls
 *
 */
public class Greedy3_BigNumber {

	private int numAryLen;
	private int selectCount;
	private int tempCnt = 0;
	private int maxValue = 0;
	
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		Greedy3_BigNumber bigNumber = new Greedy3_BigNumber();
		System.out.println(bigNumber.solution2(number, k));
	}

	public String solution(String number, int k) {
		String answer = "";
		char[] numAry = number.toCharArray();
		this.numAryLen = numAry.length;
		boolean[] visited = new boolean[numAryLen];
		this.selectCount = numAryLen - k;
		dfs(numAry, visited, 0, numAryLen, selectCount);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		answer = String.valueOf(list.get(0));

		return answer;
	}
	
	//정답이며 풀진 못했다. 하나씩 숫자를 체크하면서 가다가 나보다 큰놈이 있는지 없는지 확인한다.
	//만약 나보다 큰놈이 있으면 교체해주는 방식도 있고(stack을 통해 top에 있는 값과 비교하는 방식.) 
	// 또는 다음과 같이 구간을 잘라서 비교하는 방식을 사용해야된다.
	public String solution2(String number, int k) {
		String answer = "";
		char[] numAry = number.toCharArray();
		char max = '0';
		int idx = 0;
		int numAryLength = numAry.length;
		int loopCnt = numAryLength - k;
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0 ; i < loopCnt; i++) {
			max = '0';
			for(int j = idx; j <=i+k; j++) {
				if(max < numAry[j]) {
					max = numAry[j];
					idx = j+1;
				}
			}
			builder.append(max);
		}
		
		answer = builder.toString();
		
		return answer;
	}

	public void dfs(char[] numAry, boolean[] visited, int start, int n, int r) {

		if (r == 0) {
			tempCnt = 0;
			String temp = "";
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					tempCnt++;
					temp += numAry[i];
				}
				if (tempCnt == selectCount) {
					break;
				}
			}
			maxValue = Math.max(maxValue, Integer.parseInt(temp));
		} else {
			for (int i = start; i < numAryLen; i++) {
				visited[i] = true;
				dfs(numAry, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
		}

	}

	public class NumberObject {

		private int idx;
		private char number;

		public NumberObject(int idx, char number) {
			super();
			this.idx = idx;
			this.number = number;
		}

		@Override
		public String toString() {
			return "numberObject [idx=" + idx + ", number=" + number + "]";
		}

	}

}

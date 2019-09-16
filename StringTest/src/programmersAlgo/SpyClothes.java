package programmersAlgo;

import java.util.HashMap;
import java.util.Stack;

/**
 * 문제 설명 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나
 * 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * 
 * 종류 이름 얼굴 동그란 안경,검정 선글라스 상의 파란색 티셔츠 하의 청바지 겉옷 긴 코트
 * 
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를
 * 작성해주세요.
 * 
 * 제한사항 clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다. 스파이가 가진 의상의 수는 1개 이상 30개
 * 이하입니다. 같은 이름을 가진 의상은 존재하지 않습니다. clothes의 모든 원소는 문자열로 이루어져 있습니다. 모든 문자열의 길이는 1
 * 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다. 스파이는 하루에 최소 한 개의 의상은 입습니다.
 * 
 * 입출력 예 clothes return [[yellow_hat, headgear], [blue_sunglasses,
 * eyewear],[green_turban, headgear]] 5 [[crow_mask, face], [blue_sunglasses,
 * face],[smoky_makeup, face]] 3
 * 
 * 입출력 예 설명
 * 
 * 예제 #1 headgear에 해당하는 의상이 yellowhat, greenturban이고 eyewear에 해당하는 의상이
 * blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
 * 
 * 1. yellow_hat 2. blue_sunglasses 3. green_turban 4. yellow_hat +
 * blue_sunglasses 5. green_turban + blue_sunglasses
 * 
 * 예제 #2 face에 해당하는 의상이 crowmask, bluesunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이
 * 가능합니다.
 * 
 * 1. crow_mask 2. blue_sunglasses 3. smoky_makeup
 * 
 * @author JJI
 * 
 *         combination 알고리즘이 필요하다. 간결한걸로. 재귀 참고사이트 :
 *         https://bumbums.tistory.com/2
 *         http://swlock.blogspot.com/2016/03/combination-algorithm.html
 *         https://
 *         huiyu.tistory.com/entry/Combination-n%EA%B0%9C-%EC%A4%91-k%EA%
 *         B0%9C%EB
 *         %A5%BC-%EA%B3%A0%EB%A5%B4%EB%8A%94-%EB%B0%A9%EB%B2%95%EC%9D%98
 *         -%EC%88%98 그냥은 안풀린다...
 * 
 *         추가 : 경우의수 알고리즘이 아닌 단순 곱셈 연산으로 풀린다.. 정답 확인하였음.
 * 
 */
public class SpyClothes {

	public static int[] clothTypeCnt = null;
	public static Stack<Integer> st = new Stack<Integer>();
	public static int result = 0;

	public static void main(String[] args) {
		// String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses",
		// "eyewear"},{"green_turban", "headgear"}};
		String[][] clothes = { { "yellow_hat", "headgear" },
				{ "blue_sunglasses", "eyewear" }, { "white_turban", "pants" },
				{ "red_hat", "headgear" }, { "black_sunglasses", "eyewear" },
				{ "green_turban", "pants" }, { "blue_hat", "headgear" },
				{ "red_sunglasses", "eyewear" } };

		/*
		 * System.out.println(clothes.length);
		 * System.out.println(clothes[0].length);
		 */
		System.out.println(solution2(clothes));
	}

	public static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
		int clothesLength = clothes.length;
		String clothType = null;
		Integer clothCnt = null;
		int i = 0;
		for (i = 0; i < clothesLength; i++) { // 종류별로 몇개씩 들어있는지 갯수를 샌다.
			clothType = clothes[i][1];
			clothCnt = clothMap.get(clothType);
			if (clothCnt == null) {
				clothMap.put(clothType, 1);
			} else {
				clothMap.put(clothType, ++clothCnt);
			}
		}
		/* int [] clothTypeCnt = new int[clothMap.size()]; */
		clothTypeCnt = new int[clothMap.size()];
		i = 0;
		// HashMap에 들어있는 key를 가져와 핸들링하는 방법
		for (String key : clothMap.keySet()) {
			System.out.println(key);
			clothTypeCnt[i] = clothMap.get(key); // 각 옷 종류별로 몇개씩 들어있는지 int 형 배열에
													// 담는다.
			i++;
		}
		/*
		 * int k = 0; for(i = 0 ; i < clothTypeCnt.length ; i++){ k =
		 * clothTypeCnt[i]; for(int j = i+1 ; j < clothTypeCnt.length; j++){
		 * answer += clothTypeCnt[j]*k; } }
		 */

		/*
		 * for(i = 0 ; i < clothTypeCnt.length ; i++){
		 * System.out.println(clothTypeCnt[i]); }
		 */
		for (i = 2; i <= clothTypeCnt.length; i++) {
			doCombination(clothTypeCnt.length, i, 0);
		}
		answer = result + clothesLength;

		// 옷 종류별로 경우의 수를 구한다. ex ) 배열에 [3,3,2] => 옷의 타입별로 존재하는 갯수들이므로 연산이 필요함.

		return answer;
	}

	public static void showStack() {
		// 스택에 있는 값들을 출력한다.
		int rst = 1;
		for (int i = 0; i < st.size(); i++) {
			System.out.print(st.get(i) + " ");
			rst *= st.get(i);
		}
		result += rst;
		System.out.println(result);
	}

	public static void doCombination(int n, int r, int index) {
		// n : 전체 개수
		// r : 뽑을 개수
		// index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
		if (r == 0) {
			// 0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로 스택을 출력하고 함수를 종료한다.
			showStack();
			return;
		} else if (n == r) {
			// nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
			for (int i = 0; i < n; i++)
				st.add(clothTypeCnt[index + i]);// index부터 n개를 차례대로 스택에 넣고
			showStack(); // 스택을 보여준다.
			for (int i = 0; i < n; i++)
				st.pop(); // 이후 전부 pop을 시켜 다음 과정을 진행한다.
		} else {
			// 저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.

			// index를 포함하는 경우
			st.add(clothTypeCnt[index]);
			doCombination(n - 1, r - 1, index + 1); // index를 스택에 넣은상태로 index를
													// 1옮겨 그대로 진행.

			// index를 포함하지 않는 경우
			st.pop(); // index를 제거해주고
			doCombination(n - 1, r, index + 1); // index를 제외한 상태에서 n-1Cr 진행.

		}
		return;
	}

	/**
	 * 1개 이상을 포함한 순서를 고려하지 않은 경우의 수  
	 * @param clothes
	 * @return
	 */
	public static int solution2(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> clothMap = new HashMap<String, Integer>();
		int clothesLength = clothes.length;
		String clothType = null;
		Integer clothCnt = null;
		int i = 0;
		for (i = 0; i < clothesLength; i++) { // 종류별로 몇개씩 들어있는지 갯수를 샌다.
			clothType = clothes[i][1];
			clothCnt = clothMap.get(clothType);
			if (clothCnt == null) {
				clothMap.put(clothType, 1);
			} else {
				clothMap.put(clothType, ++clothCnt);
			}
		}
		for (String key : clothMap.keySet()) {
			answer *= (clothMap.get(key)+1);
		}

		return answer-1;
	}

}

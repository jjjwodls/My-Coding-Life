package programmersAlgo;

import java.util.ArrayList;
import java.util.List;

/**
 * 타겟 넘버 문제 설명 n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 * 
 * -1+1+1+1+1 = 3 
 * +1-1+1+1+1 = 3 
 * +1+1-1+1+1 = 3 
 * +1+1+1-1+1 = 3 
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를
 * 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 주어지는 숫자의 개수는 2개 이상 20개 이하입니다. 
 * 각 숫자는 1 이상 50 이하인 자연수입니다. 
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다. 
 * 입출력 예 
 * numbers 		  target return 
 * [1, 1, 1, 1, 1]   3 		5 
 * 입출력 예 설명 문제에 나온 예와 같습니다.
 * 
 * @author jjjwodls
 * 
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 
 */
public class TargetNumber {

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		solution(numbers,3);
	}
	
	public static int solution(int[] numbers, int target) {
		
		int aryLength = numbers.length;
		boolean[] visted = new boolean[aryLength];
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 1 ; i < aryLength ; i++) {
			searchDFS(numbers,visted,0,aryLength,i,target,list);
		}
		
		int answer = list.size();
		
		System.out.println(searchDFS2(numbers,aryLength,0,target));
		
		return answer;
	}
	
	public static void searchDFS (int[] numbers,boolean[] visted,int start,int n,int r,int target,List<Integer> list) {
		if(r == 0) {
			int sum = 0;
			for(int i = 0 ; i < visted.length ; i++) {
				if(visted[i]) {
					sum += (numbers[i] *-1);
				}else {
					sum += numbers[i];
				}
			}
			if(sum == target) {
				list.add(1);
			}
		}else {
			for(int i = start ; i < numbers.length ; i++) {
				if(!visted[i]) {
					visted[i] = true;
					searchDFS(numbers,visted,i+1,numbers.length,r-1,target,list);
					visted[i] = false;
				}
			}
		}
	}
	//정답 2 
	public static int searchDFS2 (int[] numbers,int length,int idx, int target) {
		
		if(idx == length) {
			int sum = 0;
			for(int k : numbers ) {
				sum += k;
			}
			
//			if(sum == target) {
//				return 1;
//			}else {
//				return 0;
//			}
			return sum == target ? 1 : 0; 
		}
		int result = 0;
		
		
		result += searchDFS2(numbers,length,idx+1,target); 
		numbers[idx] *= -1;
		
		result += searchDFS2(numbers,length,idx+1,target);
		numbers[idx] *= -1;
		
		return result;
		
	}
	
	/** 깔끔하게 짠 다른 정답 3
	 * public int backTrack(int[] numbers, int target, int idx) {
        if (idx == numbers.length) {
            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }

            return sum == target ? 1 : 0;
        }

        int res = 0;
        res += backTrack(numbers, target, idx + 1);

        numbers[idx] *= -1;
        res += backTrack(numbers, target, idx + 1);

        numbers[idx] *= -1;

        return res;
    }
	 */

}

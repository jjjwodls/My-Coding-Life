package programmersAlgo;

import java.util.Stack;

/**
 * 네트워크 문제 설명 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가
 * 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할
 * 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록
 * solution 함수를 작성하시오.
 * 
 * 제한사항 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다. 각 컴퓨터는 0부터 n-1인 정수로 표현합니다. i번 컴퓨터와 j번
 * 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다. computer[i][i]는 항상 1입니다. 
 * 입출력 예 n computers return 
 * 3  [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 2 
 * 3  [[1, 1, 0], [1, 1, 1], [0, 1, 1]] 1
 * 
 * @author jjjwodls
 * 
 * 깊이우선 탐색 DFS 는 모든 경우의 수를 탐색해야 한다. 즉, 방문 여부를 체크해야됨.
 * 전부 방문했는지 안했는지 확인한다.
 *
 */
public class Network {
		
	public static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		/*stack.push(1);
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());*/
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		//int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		//int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int n = 3;
		//int[][] computers = {{1, 1, 0,0}, {0, 1, 1,0}, {0, 0, 1,1}, {0,0,0,1}};
		System.out.println(solution(n,computers));
	}

	/*public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visted = new boolean[n];
		answer = n+searchDFS(computers,visted,0,n,2);
		return answer;
	}
	
	public static int searchDFS(int[][] computers,boolean[] visted , int start,int n,int r) {
		int networkCnt = 0;
		if(r == 0) {
			int idx1 = 0;
			int idx2 = 0;
			for(int i = 0 ; i < n ; i++) {
				if(visted[i]) {
					stack.push(i);
				}
			}
			idx1 = stack.pop();
			idx2 = stack.pop();
			if(computers[idx1][idx2] == 1) {
				return -1;
			}else {
				return 0;
			}
		}else {
			for(int i = start ; i < n ; i++) {
				visted[i] = true;
				networkCnt += searchDFS(computers,visted ,i+1,n,r-1);
				visted[i] = false;
			}
		}
		return networkCnt;
	}*/
	
	 public static int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean[] chk = new boolean[n];
	        for(int i = 0; i < n; i++) {
	            if(!chk[i]) {
	                dfs(computers, chk, i);
	                answer++;
	            }
	        }
	        return answer;
	    }
	 public static void dfs(int[][] computers, boolean[] chk, int start) {
		 chk[start] = true;
		 for(int i = 0; i < computers.length; i++) {
			 if(computers[start][i] == 1 && !chk[i]) {
				 dfs(computers, chk, i);
			 }
		 }
	 }

}

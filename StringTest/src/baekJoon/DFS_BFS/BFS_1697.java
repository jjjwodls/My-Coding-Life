package baekJoon.DFS_BFS;

import java.util.*;

/**
 * 도저히 패턴 생각이 나지 않아서 정답 보고 참조했다.
 * 방문 배열을 만들어 놓고 모든 경우의 수를 다 대입하면서 찾아낸다.
 * 그리고 BFS 이므로 현재 방문한 횟수가 최소가 되는 경우의 수를 찾는데 적합함.
 * 잘못된 풀이 방법. boolean 형으로 방문 여부만 체크하면 되는데 저렇게 체크하면 
 * 최소가 되는 경우의 수를 체크 할 수 없다. 
 * 12851 번을 보고 참고하자
 * @author jjjwodls
 *
 */
public class BFS_1697 {

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int visited[] = new int[100001];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;
		while(!q.isEmpty()) {
			N = q.poll();
		
			if(N == K)
				break;
			
			if(N+1 <= 100000 && visited[N+1] == 0) {
				q.add(N+1);
				visited[N+1] = visited[N] + 1;
			}
			
			if(N-1 >= 0 && visited[N-1] == 0) {
				q.add(N-1);
				visited[N-1] = visited[N] + 1;
			}
			
			if(N*2 <=100000 && visited[N*2] == 0) {
				q.add(N*2);
				visited[N*2] = visited[N] + 1;
			}
		}
		System.out.println(visited[N]-1);
				
	}

}

package baekJoon.DFS_BFS;

import java.util.*;

public class BFS_1260_1 {

    private static int N;
    private static int[][] edge;
    private static boolean[] visited;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점의 갯수
		int M = sc.nextInt(); // 간선 갯수
		int V = sc.nextInt(); // 시작할 간선의 정점번호
		
		edge = new int[1001][1001];
		int start = 0;
		int end = 0;
		for(int i = 1 ; i <= M ; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			edge[start][end] = 1;
			edge[end][start] = 1;
		}
		visited = new boolean[1001];
		visited[V] = true;
		dfs(V);
        
		Queue<Integer> q = new LinkedList<>();
        Integer curV = null;
        q.offer(V);
		System.out.println();
		Arrays.fill(visited, false);
		visited[V] = true;
		while(!q.isEmpty()) {
			curV = q.poll();
			System.out.print(curV + " ");
			for(int i = 1 ; i <= N ; i++) {

				if(edge[curV][i] != 0 && !visited[i]){
					q.offer(i);
					visited[i] = true;
                }
			}
					
		}
	}
    
    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 1 ; i <= N ; i++){
            if(edge[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        
    }

}


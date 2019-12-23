package baekJoon.DFS_BFS;

import java.util.*;

public class BFS_1260 {

	static ArrayList<Integer>[] list;
	static int N;
	static boolean[] check;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 갯수
		int M = sc.nextInt(); // 간선 갯수
		int V = sc.nextInt(); // 시작할 간선의 정점번호
		
		list = new ArrayList[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			Collections.sort(list[i]);
		}
		check = new boolean[N+1];
		dfs(V);
		System.out.println();
		Arrays.fill(check,false);
		bfs(V);
		
		sc.close();
	}
	
	public static void dfs(int x) {
		
		if(check[x]) {
			return;
		}
		
		check[x] = true;
		System.out.print(x + " ");
		for(int j : list[x]) {
			if(check[j])
				dfs(j);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for(int j : list[x]) {
				if(!check[j]) {
					check[j] = true;
					queue.offer(j);
				}
			}
			
		}
	}
}

package studyAlgorithm;

import java.util.*;

public class BfsSearch {

	private static boolean[] visited = new boolean[8];
	private static int[][] ary = new int[8][8];
	
	public static void main(String[] args) {
		ary[1][2] = 2;
		ary[2][1] = 1;
		
		ary[1][3] = 3;
		ary[3][1] = 1;
		
		ary[2][3] = 3;
		ary[3][2] = 2;

		ary[2][4] = 4;
		ary[4][2] = 2;
		
		ary[2][5] = 5;
		ary[5][2] = 2;
		
		ary[3][6] = 6;
		ary[6][3] = 3;
		
		ary[3][7] = 7;
		ary[7][3] = 3;

		ary[4][5] = 5;
		ary[5][4] = 4;
		
		ary[6][7] = 7;
		ary[7][6] = 6;
		
		bfs(1);
		System.out.println("끝");
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.println(x);
			for(int i = 0 ; i < ary[x].length; i++) {
				int temp = ary[x][i];
				if(temp != 0 && !visited[temp]) {
					q.add(temp);
					visited[temp] = true;
				}
			}
			
		}
		
	}

}

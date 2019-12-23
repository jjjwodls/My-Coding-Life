package baekJoon.DFS_BFS;

import java.util.*;

public class BFS_2178 {
	
	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY= {0,0,1,-1};
	public static boolean[][] visited; 
	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //행의 갯수
		M = sc.nextInt(); //열의 갯수
		
		int[][] map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		String input = null;
		sc.nextLine();
		for(int i = 1 ; i <= N ; i++) {
			input = sc.nextLine();
			for(int j = 1 ; j <= M ; j++) {
				map[i][j] = input.charAt(j-1)-'0';
			}
		}
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(1,1,1));
		visited[1][1] = true;
		Position position = null;
		int nextX = 0;
		int nextY = 0;
		while(!q.isEmpty()) {
			position = q.poll();
			if(position.x == N && position.y == M) {
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++) {
				nextX = position.x + moveX[i];
				nextY = position.y + moveY[i];
				if(checkRange(nextX,nextY,map) && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					q.offer(new Position(nextX, nextY, position.cnt+1));
				}
			}
		}
		System.out.println(position.cnt);
		
	}
	
	public static boolean checkRange(int nextX,int nextY,int[][] map) {
		if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= M && map[nextX][nextY] != 0) {
			return true;
		}
		
		return false;
	}
	
	public static class Position{
		public int x;
		public int y;
		public int cnt;
		
		public Position(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}

}

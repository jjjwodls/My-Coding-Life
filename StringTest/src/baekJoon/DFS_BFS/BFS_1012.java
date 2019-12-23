package baekJoon.DFS_BFS;

import java.util.*;

/**
 * 쉽게 해결했는데 반례를 생각하는데 시간이 좀 걸렸음.
 * 반례는
 * 2
 * 10
 * 01 인경우이다.
 * 1,1 은 내가 이미 밟은 자리이므로 방문 처리 및 카운트를 쳐줘야 하는데 이걸 빼먹었음.
 * @author jjjwodls
 *
 */
public class BFS_1012 {

	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY= {0,0,1,-1};
	public static int[][] map; 
	
	public static int T; // 테스트 케이스 개수 입력
	public static int M; // 배추밭의 가로 길이
	public static int N; // 배추밭의 새로 길이
	public static int K; // 심어진 배추의 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); //정사각형 배열이여서 하나만 입력 받는다.
		sc.nextLine();
		int cnt = 0;
		
		for(int i = 1 ; i <= T ; i++) {// MAP 을 초기화
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[M+1][N+1];
			for(int k = 1 ; k <= K ; k++) {
				map[sc.nextInt()+1][sc.nextInt()+1] = 1;
			}
			Queue<Position> queue = new LinkedList<>();
			int nextX = 0;
			int nextY = 0;
			while(true) {
				Position p = searchStart();
				if(p == null) {
					break;
				}
				queue.offer(p);
				map[p.x][p.y] = 0; //이부분이 내가 빼먹은 부분이다.
				cnt ++;
				while(!queue.isEmpty()) {
					p = queue.poll();
					for(int t = 0 ; t < 4 ; t++) {
						nextX = p.x + moveX[t];
						nextY = p.y + moveY[t];
						if(checkRange(nextX,nextY)) {
							map[nextX][nextY] = 0;
							queue.offer(new Position(nextX, nextY));
						}
					}
				}
			}
			System.out.println(cnt);
			cnt=0;
		}
	}
	
	public static boolean checkRange(int nextX,int nextY) {
		if(nextX > 0 && nextX <= M && nextY > 0 && nextY <= N && map[nextX][nextY] != 0) {
			return true;
		}
		
		return false;
	}
	
	public static Position searchStart() {
		Position p = null;
		boolean flag = false;
		for(int i = 1 ; i <= M ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(map[i][j] == 1) {
					p = new Position(i, j);
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
		
		return p;
	}
	
	public static class Position{
		public int x;
		public int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
		
	}
	

}

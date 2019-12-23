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
public class BFS_2667 {

	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY= {0,0,1,-1};
	public static int[][] map; 
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //정사각형 배열이여서 하나만 입력 받는다.
		
		map = new int[N+1][N+1];
		String input = null;
		sc.nextLine();
		for(int i = 1 ; i <= N ; i++) {// MAP 을 초기화
			input = sc.nextLine();
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = input.charAt(j-1)-'0';
			}
		}
		List<Integer> list = new ArrayList<Integer>(); // 입력받을 단지별 갯수.
		int nextX = 0;
		int nextY = 0;
		int cnt = 0;
		Queue<Position> queue = new LinkedList<>();
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
				for(int i = 0 ; i < 4 ; i++) {
					nextX = p.x + moveX[i];
					nextY = p.y + moveY[i];
					if(checkRange(nextX,nextY)) {
						map[nextX][nextY] = 0;
						cnt++;
						queue.offer(new Position(nextX, nextY));
					}
				}
			}
			list.add(cnt);
			cnt = 0;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(Integer rst : list) {
			System.out.println(rst);
		}
	}
	
	public static boolean checkRange(int nextX,int nextY) {
		if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= N && map[nextX][nextY] != 0) {
			return true;
		}
		
		return false;
	}
	
	public static Position searchStart() {
		Position p = null;
		boolean flag = false;
		for(int i = 1 ; i <= N ; i++) {
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

package baekJoon.DFS_BFS;

import java.util.*;

/**
 * 경우의 수를 고려하여 제법 잘 해결했음.
 * @author jjjwodls
 *
 */
public class BFS_7576 {

	public static int[] moveX = {1,-1,0,0};
	public static int[] moveY= {0,0,1,-1};
	public static int[][] map;
	public static int M;
	public static int N;
	public static int minusCnt = 0;
	public static int oneCnt = 0; //토마토의 익은 갯수를 저장하여 추 후 모든 토마토가 익었는지 확인하기 위한 
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 열의 갯수
		N = sc.nextInt(); // 행의 갯수
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1]; 
		String[] inputAry = null;
		int in = 0;
		int day = 0;
		sc.nextLine();
		for(int i = 1 ; i <= N ; i++) {// MAP 을 초기화
			inputAry = sc.nextLine().split(" ");
			for(int j = 1 ; j <= M ; j++) {
				in = Integer.parseInt(inputAry[j-1]);
				if(in == -1) {
					minusCnt++;
				}
				map[i][j] = in;
			}
		}
		List<Queue<Position>> qList = searchStart();
		List<Position> list = null; // 임시 리스트로 q에서 꺼내온 값을 담아주는 리스트이다.
		Position p = null; //큐에서 나오는 position 담을 값.
		int nextX = 0;
		int nextY = 0;
		int qListSize = qList.size();
		int isEmptyChk = 0;
		
		if(qListSize == 0) {
			System.out.println(-1);
		}else {
			while(true) {
				for(Queue<Position> q : qList) {
					list = new ArrayList<>();
					while(!q.isEmpty()) {
						p = q.poll();
						for(int i = 0 ; i < 4 ; i++) {
							nextX = p.x + moveX[i];
							nextY = p.y + moveY[i];
							if(checkRange(nextX,nextY) && !visited[nextX][nextY]) {
								map[nextX][nextY] = 1;
								visited[nextX][nextY] = true;
								oneCnt++;
								//큐에 새롭게 계속 담으면 무한루프에 빠지므로 list에 임시로 저장해 놓는다.
								list.add(new Position(nextX, nextY));
							}
						}
					}
					for(int i = 0 ; i < list.size() ; i++) {
						q.offer(list.get(i));
					}
				}
				for(Queue<Position> q : qList) {
					if(q.isEmpty()) {
						isEmptyChk++;
					}
				}
				if(isEmptyChk == qListSize) {
					break;
				}
				isEmptyChk = 0;
				day++;
			}
			
			if(oneCnt+minusCnt == N*M) { // 1 갯수와 -1 갯수의 합이 배열 전체의 합이여야 모든 토마토가 익은 경우다.
				System.out.println(day);
			}else {
				System.out.println(-1);
			}
		}
		
	}
	
	public static boolean checkRange(int nextX,int nextY) {
		if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= M && map[nextX][nextY] == 0) {
			return true;
		}
		
		return false;
	}
	
	public static ArrayList<Queue<Position>> searchStart() {
		Position p = null;
		Queue<Position> q = null;
		ArrayList<Queue<Position>> list = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= M ; j++) {
				if(map[i][j] == 1) {
					p = new Position(i, j);
					visited[p.x][p.y] = true;
					q = new LinkedList<Position>();
					q.add(p);
					list.add(q);
					oneCnt++;
				}
			}
		}
		
		return list;
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

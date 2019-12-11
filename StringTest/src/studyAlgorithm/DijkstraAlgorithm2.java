package studyAlgorithm;

import java.util.*;

//더 빠른속도로 만든 것이며 heap 을 사용하여 생성 (다시 시작하기)
public class DijkstraAlgorithm2 {

	private static PriorityQueue<Edge> pq = new PriorityQueue<>();
	private static int MAX = 10000000;
	private static int edgeCnt = 6;
	private static int[] distance = new int[7];
	
	public static void main(String[] args) {
		for(int i = 0 ; i <= edgeCnt; i++) {
			distance[i] = MAX;
		}

				
	}
	
	public static class Edge implements Comparable<Edge>{
		
		private int start;
		private int end;
		private int cost;
		
		public Edge(int cost, int start, int end) {
			super();
			this.cost = cost;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void dijkstra(int start) {
		distance[start] = 0;
		
		
		
	}

}

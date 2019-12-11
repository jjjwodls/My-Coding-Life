package studyAlgorithm;

import java.util.*;

public class DijkstraAlgorithm {

	private static int edge = 6;
	private int MAX = 100000000;
	
	private int[][] edgeAry = {
			{0,2,5,1,MAX,MAX},
			{2,0,3,2,MAX,MAX},
			{5,3,0,3,1,5},
			{1,2,3,0,1,MAX},
			{MAX,MAX,1,1,0,2},
			{MAX,MAX,5,MAX,2,0}
	};
			
	private boolean[] visited = new boolean[edge]; //방문한 노드
	private static int[] distance = new int[edge]; //최단 거리
	
	public static void main(String[] args) {
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
		algorithm.dijkstra(0);
		for(int rst : distance) {
			System.out.print(rst + " ");
		}
	}
	
	public int getSmallIdx() {
		int min = MAX;
		int idx = 0;
		for(int i = 0 ; i < edge ; i++) {
			if(distance[i] < min && !visited[i]) {
				min = distance[i];
				idx = i;
			}
		}
		return idx;
	}
	// 선형 탐색으로 만든 경우여서 O(n^2) 걸림.
	public void dijkstra(int start) {
		for(int i = 0 ; i < edge ; i++) {
			distance[i] = edgeAry[start][i];
		}
		visited[start] = true;
		for(int i = 0 ; i < edge-2 ; i++) {
			int current = getSmallIdx();
			visited[current] = true;
			for(int j = 0 ; j < edge ; j++) {
				if(!visited[j]) {
					if(distance[current] + edgeAry[current][j] < distance[j]) {
						distance[j] = distance[current] + edgeAry[current][j];
					}
				}
			}
		}
	}
	
}

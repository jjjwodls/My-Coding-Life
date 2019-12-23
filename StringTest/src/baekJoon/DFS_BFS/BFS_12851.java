package baekJoon.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 생각만 했지 실제로 해결하진 못했음.. 
 * 이전 문제도 마찬가지
 * @author jjjwodls
 *
 */
public class BFS_12851 {
	static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visited = new boolean[100001];
		System.out.println(solve());
		System.out.println(cnt);
	}

	static int[] arr = new int[3];
	static int cnt = 0;
	static boolean[] visited;

	private static int solve() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(n, 0));
		visited[n] = true;
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Pair t = queue.poll();
			arr[0] = t.n - 1;
			arr[1] = t.n + 1;
			arr[2] = t.n * 2;
			visited[t.n] = true;
			if (t.n == k) {
				min = Math.min(min, t.time);
				if (min != t.time)
					break;
				cnt++;
			}
			for (int i = 0; i < 3; i++) {
				if (arr[i] >= 0 && arr[i] <= 100000 && !visited[arr[i]])
					queue.add(new Pair(arr[i], t.time + 1));
			}
		}
		return min;
	}

	static class Pair {
		private int n;
		private int time;

		public Pair(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}
}

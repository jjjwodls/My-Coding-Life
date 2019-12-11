package studyAlgorithm;

import java.util.*;

//이분 매칭이며 서로 완벽한 매칭을 할 때 사용한다.
public class BipartiteMatching {

	final static int MAX = 101; 
	
	private static Vector<int[]> a = new Vector<>();
	
	private static int d[] = new int[MAX];
	private static boolean v[] = new boolean[MAX];
	private static int n = 3;
	private static int m = 0;
	private static int s = 0;
	
	public static void main(String[] args) {
		
		int count = 0;
		
		int[] ary = null;
		a.add(ary);
		int[] ary1 = {1,2,3};
		a.add(ary1);
		int[] ary2 = {1};
		a.add(ary2);
		int[] ary3 = {2};
		a.add(ary3);
		
		for(int i = 1 ; i <= n ; i++) {
			Arrays.fill(v, false);
			if(dfs(i)) count++;
		}
		
		for(int i = 1 ; i < 5 ; i++) {
			if(d[i] != 0) {
				System.out.print(d[i] + " -> " + i);
			}
			System.out.println();
		}
		
	}
	
	public static boolean dfs(int x) {
		
		for(int i = 0 ; i < a.get(x).length ; i++) {
			int t = a.get(x)[i];
			if(v[t]) continue;
			v[t] = true;
			
			if(d[t] == 0 || dfs(d[t])) {
				d[t] = x;
				return true;
			}
			
		}
		
		return false;
	}

}

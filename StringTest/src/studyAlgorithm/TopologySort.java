package studyAlgorithm;

import java.util.*;

//위상정렬
public class TopologySort {
	
	private static int[] inDegree = new int[10];
	private static int n;
	private static Vector<ArrayList<Integer>> ary = new Vector<>();
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		ary.add(list);
		
		list = new ArrayList<>();
		list.add(2);
		list.add(5);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		list = new ArrayList<>();
		list.add(3);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		
		list = new ArrayList<>();
		list.add(4);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		
		list = new ArrayList<>();
		list.add(6);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		
		list = new ArrayList<>();
		list.add(6);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		
		list = new ArrayList<>();
		list.add(7);
		ary.add(list);
		for(int i = 0 ; i < list.size(); i++) {
			inDegree[list.get(i)]++;
		}
		n = ary.size();
		
		list = new ArrayList<>();
		ary.add(list);
		
		topologySort();
	}
	
	public static void topologySort() {
		int[] result = new int[10];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1 ; i <n ; i++) {
			if(inDegree[i] == 0)
				q.offer(i);
		}
		
		for(int i = 1 ; i <= n ; i++) {
			
			if(q.isEmpty()) {
				System.out.println("사이클 생김");
				break;
			}
			
			int x = q.poll();
			result[i] = x;
			for(int j = 0 ; j < ary.get(x).size() ; j++) {
				int y = ary.get(x).get(j);
				if(--inDegree[y] == 0) {
					q.offer(y);
				}
			}
			
		}
		
		for(int rst : result) {
			System.out.print(rst + " ");
		}
	}
	
	

}

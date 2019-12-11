package baekJoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * dfs 문제로 풀어야 되는데 도저히 방법을 생각하지 못했따.
 * 오답이다.
 * @author jjjwodls
 *
 */
public class Greedy_Exam_2529 {
	
	private static ArrayList<String> list = new ArrayList<String>();
	private static int k;
	private static String[] ary;
	private static boolean[] visited = new boolean[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		sc.nextLine();
		String compare= sc.nextLine();
		ary = compare.split(" ");
		
		for(int i = 0 ; i <= 9 ; i ++) {
			visited[i] = true;
			dfs(i,0,i + "");
		}
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
	}
	
	public static void dfs(int start , int cnt , String str) {
		if(cnt == k) {
			list.add(str);
		}else {
			for(int i = 0 ; i <= 9 ; i++) {
				if(!visited[i]) {
					if(ary[cnt].equals("<")) {
						if(start >= i) {
							continue;
						}
					}else {
						if(start <= i) {
							continue;
						}
					}
					visited[i] = true;
					dfs(i,cnt+1,str+i);
				}
			}
		}
		visited[start] = false;
	}
	

}

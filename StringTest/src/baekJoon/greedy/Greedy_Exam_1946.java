package baekJoon.greedy;

import java.util.*;
import java.io.*;

/**
 * 문제 실패
 * 하나의 기준에 초점을 맞추고 했어야 했는데 너무 복잡하게 생각.
 * @author jjjwodls
 *
 */
public class Greedy_Exam_1946 {
	
	private static int[][] ary = null;
	private static int[][] top = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer str;
		for(int i = 0 ; i < testCase ; i++) {
			int N = Integer.parseInt(br.readLine());
			List<Exam> list = new ArrayList<Exam>();
			ary = new int[N][2];
			for(int j = 0 ; j < N; j++) {
				str=new StringTokenizer(br.readLine());
				ary[j][0] = Integer.parseInt(str.nextToken());//서류등수
				ary[j][1] = Integer.parseInt(str.nextToken());//면접등수
				list.add(new Exam(j,ary[j][0],ary[j][1]));
			}
			top = new int[2][2]; // 서류,면접 1등 저장하는 배열.
			Collections.sort(list,new Comparator<Exam> () {
				@Override
				public int compare(Exam o1, Exam o2) {
					return o1.paper-o2.paper;
				}
			});
			Exam exam = list.get(0);
			top[0][0] = exam.paper;
			top[0][1] = exam.interview;
			list.remove(0);
			Collections.sort(list,new Comparator<Exam> () {
				@Override
				public int compare(Exam o1, Exam o2) {
					return o1.interview-o2.interview;
				}
			});
			exam = list.get(0);
			top[1][0] = exam.paper;
			top[1][1] = exam.interview;
			list.remove(0);
			
			int topAryLen = top.length;
			int listSize = list.size();
			int passN = listSize;
			boolean pass = true;
			for(int k = 0 ; k < listSize ; k++) {
				exam = list.get(k);
				for(int m = 0 ; m < topAryLen ; m++) {
					if(exam.paper > top[m][0] && exam.interview > top[m][1]) {
						pass = false;
					}
				}
				if(!pass) {
					passN--;
				}
				pass = true;
			}
			
			System.out.println(passN+2);
		}
		
	}
	
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 0 ; i < testCase ; i++) {
			sc.nextLine();
			int N = sc.nextInt();
			sc.nextLine();
			List<Exam> list = new ArrayList<Exam>();
			ary = new int[N][2];
			for(int j = 0 ; j < N; j++) {
				ary[j][0] = sc.nextInt();
				ary[j][1] = sc.nextInt();
				list.add(new Exam(j,ary[j][0],ary[j][1]));
			}
			sc.nextLine();
			top = new int[2][2]; // 서류,면접 1등 저장하는 배열.
			Collections.sort(list,new Comparator<Exam> () {
				@Override
				public int compare(Exam o1, Exam o2) {
					return o1.paper-o2.paper;
				}
			});
			Exam exam = list.get(0);
			top[0][0] = exam.paper;
			top[0][1] = exam.interview;
			list.remove(0);
			Collections.sort(list,new Comparator<Exam> () {
				@Override
				public int compare(Exam o1, Exam o2) {
					return o1.interview-o2.interview;
				}
			});
			exam = list.get(0);
			top[1][0] = exam.paper;
			top[1][1] = exam.interview;
			list.remove(0);
			
			int topAryLen = top.length;
			boolean pass = false;
			int listSize = list.size();
			int passN = listSize;
			for(int k = 0 ; k < listSize ; k++) {
				exam = list.get(k);
				for(int m = 0 ; m < topAryLen ; m++) {
					if(exam.paper < top[m][0] || exam.interview < top[m][1]) {
						pass = true;
						break;
					}
				}
				if(!pass) {
					passN--;
				}
				pass = false;
			}
			
			System.out.println(passN+2);
		}
		
	}*/
	
	
	
	public static class Exam{
		
		public int idx;
		public int paper;
		public int interview;
		
		public Exam(int idx, int paper,int interview) {
			super();
			this.idx = idx;
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public String toString() {
			return "Exam [idx=" + idx + ", interview=" + interview + ", paper=" + paper + "]";
		}
		
		
	}
	
}

	


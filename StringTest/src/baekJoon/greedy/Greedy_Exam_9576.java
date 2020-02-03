package baekJoon.greedy;

import java.util.*;

/**
 * @author jjjwodls
 *
 */
public class Greedy_Exam_9576 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		
		for(int t = 0 ; t < T ; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean check[] = new boolean[N+1];
			List<BookReq> list = new ArrayList<>();
			for(int i = 0 ; i < M ; i++) {
				list.add(new BookReq(sc.nextInt(), sc.nextInt()));
			}
			Collections.sort(list, new Comparator<BookReq>() {
				@Override
				public int compare(BookReq o1, BookReq o2) {
					if(o1.b == o2.b) {
						return o1.a-o2.a;
					}
					return o1.b - o2.b;
				}
			});
			int result = 0;
			BookReq req = null;
			for(int j = 0; j < M ; j++) {
				req = list.get(j);
				for(int k = req.getA(); k<=req.getB() ; k++) {
					if(!check[k]) {
						check[k] = true;
						result++;
						break;
					}
				}
			}
			System.out.println(result);
		}
		
	}
	
	public static class BookReq{
		
		private int a;
		private int b;
		
		public BookReq() {
			
		}

		public BookReq(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "BookReq [a=" + a + ", b=" + b + "]";
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
		
	}

}

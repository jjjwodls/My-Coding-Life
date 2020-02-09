package codility;

import java.util.*;

public class Temp {

	public static void main(String[] args) {
		System.out.println(Test());
	}
	//연속된 정수 즉 ,  [4, 5, 5, 4, 2, 2, 4] 라면 연속된 정수는 5,5 2,2 이렇게 존재한다. 따라서 2를 리턴
	public static int Test() {
		int bookAry[] = new int[100001];
		
		
		// int A[] = {1,2,2,2,4,5,6,6,7,7};
		// int A[] = {1, 1, 3, 4, 3, 3, 4};
		// int A[] = {1, 1, 3, 4, 3, 3, 4};

		// int A[] = {1, 1, 1, 1, 2, 3, 4};
		// int A[] = {1, 1, 3, 4, 3, 3, 4,4};
		int A[] = { 10000,10000,10000,10000,10000};
		// int K = 10;
		int K = 10000;
		int aryLength = A.length;
		if (A.length == K) {
			return K;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int book : A) {
			if (map.get(book) == null) {
				map.put(book, 1);
			} else {
				map.put(book, map.get(book) + 1);
			}
		}
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		List<Book> list = new ArrayList<>();
		while (it.hasNext()) {
			Integer key = it.next();
			list.add(new Book(key, map.get(key)));
		}
		int listSize = list.size();
		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.idx - o2.idx;
			}
		});
		if (listSize == 1 || K == 0) {
			return list.get(listSize - 1).getCnt();
		}

		List<Book> list2 = new ArrayList<>(list);

		list2.sort(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				if (o2.cnt == o1.cnt) {
					return o2.idx - o1.idx;
				}
				return o2.cnt - o1.cnt;
			}
		});
		Book maxCntBook = list2.get(0);
		int result = maxCntBook.getCnt() + K;
		if (aryLength < result) {
			result = aryLength;
		}

		return result;
	}

	public static class Book {

		private int idx;
		private int cnt;

		public Book(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Book [idx=" + idx + ", cnt=" + cnt + "]";
		}

	}

}

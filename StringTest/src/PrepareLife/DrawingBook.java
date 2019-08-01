package PrepareLife;

/**
 * Complete the pageCount function in the editor below. It should return the
 * minimum number of pages Brie must turn.
 * 
 * pageCount has the following parameter(s):
 * 
 * n: the number of pages in the book 
 * p: the page number to turn to
 * 
 * @author JJI
 * 
 */
public class DrawingBook {

	public static void main(String[] args) {
		int n = 6;
		int p = 5;

		System.out.println(pageCount(n, p));

	}

	/*
	 * Complete the pageCount function below.
	 */
	// 시작 페이지 이며 시작페이지는 1 또는 n 두가지 경우이다. 그리고 1부터 시작하는게 빠를지 아니면 n부터 시작하는게 빠를지 그리고
	// 해당 페이지가 나올때 까지 넘겨야 하는 횟수를 구하자.
	// p : 보여야 하는 페이지
	public static int pageCount(int n, int p) {

		if (p == 1 || n == p) {
			return 0;
		}

		int frontPageSlipCnt = 0;
		int backPageSlipCnt = 0;

		frontPageSlipCnt = p / 2;

		// 현재 페이지가 짝수인지.
		if (n % 2 == 0) {
			if (p % 2 == 0) { // 도착지점이 짝수인지
				backPageSlipCnt = (n - p) / 2;
			} else { // 홀수인지
				backPageSlipCnt = (n - p) / 2 + 1;
			}
		} else {
			backPageSlipCnt = (n - p) / 2;
		}

		if (frontPageSlipCnt <= backPageSlipCnt) {
			return frontPageSlipCnt;
		} else {
			return backPageSlipCnt;
		}

	}

}

package codility;

public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(solution(1,85,3));
	}

	public static int solution(int X, int Y, int D) {
		int result = 0;
		if (X == Y) {
			return result;
		}

		int range = Y - X;

		result = range / D;
		if(range%D != 0) {
			result++;
		}
		

		return result;
	}

}

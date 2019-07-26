package StringTest;

public class HouseAndTree {

	/**
	 * 7 11 집 간 거리 5 15 나무들 위치 ( 첫번째는 사과 , 두번째는 오렌지) 3 2 (과일 갯수) -2 2 1 사과 현재 위치
	 * 5 -6 오렌지 현재 위치
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int s = 7;
		int t = 11;

		int a = 5;
		int b = 15;

		int[] apples = { -2, 2, 1 };
		int[] oranges = { 5, -6 };

		int myApple = 0;
		int myOrange = 0;

		int i = 0;
		int tempPoint = 0;
		int appleCnt = apples.length;
		int orangeCnt = oranges.length;
		//1번방법
	/*	for (i = 0; i < appleCnt; i++) {
			tempPoint = apples[i] + a;
			if (tempPoint >= s && tempPoint <= t) {
				myApple++;
			}
		}

		for (i = 0; i < orangeCnt; i++) {
			tempPoint = oranges[i] + b;
			if (tempPoint >= s && tempPoint <= t) {
				myOrange++;
			}
		}*/

		//2번방법 루프 횟수를 줄여 시간복잡도를 줄이자.
		int loopCnt = orangeCnt;
		boolean flag = true; 
		if(appleCnt < orangeCnt){
			loopCnt = appleCnt;
			flag = false;
		}
		
		for (i = 0; i < loopCnt; i++) {
			tempPoint = apples[i] + a;
			if (tempPoint >= s && tempPoint <= t) {
				myApple++;
			}
			
			tempPoint = oranges[i] + b;
			if (tempPoint >= s && tempPoint <= t) {
				myOrange++;
			}
		}
		
		if(flag){
			for( ; i < appleCnt ; i++){
				tempPoint = apples[i] + a;
				if (tempPoint >= s && tempPoint <= t) {
					myApple++;
				}
			}
		}else{
			for( ; i < orangeCnt ; i++){
				tempPoint = oranges[i] + b;
				if (tempPoint >= s && tempPoint <= t) {
					myOrange++;
				}
			}
		}
		
		

		System.out.println(myApple);
		System.out.println(myOrange);

	}

}

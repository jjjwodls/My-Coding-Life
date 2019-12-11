package studyAlgorithm;

public class FloydWarshallAlgorithm {

	private static int number =4;
	private static int INF = 10000000;
	
	private static int[][] ary = {
			{0, 5,INF ,8},
			{7, 0,9 , INF},
			{2, INF, 0, 4},
			{INF, INF, 3, 0}
	};
	
	public static void main(String[] args) {
		int[][] d = new int[number][number];
		
		//결과 그래프를 초기화해준다.
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) {
				d[i][j] = ary[i][j];
			}
		}
		
		//거쳐가는 정점
		for(int i = 0 ; i < number ; i++) {
			for(int j = 0 ; j < number ; j++) { //시작하는점
				for(int k = 0 ; k < number ; k++) { // 도착지점
					if(d[j][i] + d[i][k] < d[j][k]) {
						d[j][k] = d[j][i] + d[i][k]; 
					}
				}
				
			}
		}
		
		for(int i = 0 ; i < number ; i++){
			for(int j = 0 ; j < number ; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

}

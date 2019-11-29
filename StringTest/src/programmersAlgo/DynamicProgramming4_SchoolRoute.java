package programmersAlgo;

/**
 * 
 * 등굣길
	문제 설명
	계속되는 폭우로 일부 지역이 물에 잠겼습니다. 
	물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.

아래 그림은 m = 4, n = 3 인 경우입니다.

가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 
집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

제한사항
격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
물에 잠긴 지역은 0개 이상 10개 이하입니다.
집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
입출력 예
	m	n	puddles	return
	4	3	[[2, 2]]	4
 * @author jjjwodls
 *
 *
 */
public class DynamicProgramming4_SchoolRoute {

	private int m;
	private int n;
	private int routeCnt;
	private int[][] memory; 
	
	public static void main(String[] args) {
		DynamicProgramming4_SchoolRoute dynamicProgramming4_SchoolRoute = new DynamicProgramming4_SchoolRoute();
		/*int [][] puddles = {{2, 2}};
		int rst = dynamicProgramming4_SchoolRoute.solution(4,3,puddles);*/
		int [][] puddles1 = {{0,0},{1,2},{2,2}};
		int rst = dynamicProgramming4_SchoolRoute.solution(4,4,puddles1);
		System.out.println(rst);
		
		int [][] puddles2 = {{0,0},{1,2},{2,2}};
		int rst2 = dynamicProgramming4_SchoolRoute.solution2(4,4,puddles2);
		System.out.println(rst2);
	}
	
	//정답
	public int solution(int m, int n, int[][] puddles) {
		
		int answer = 0;
        if(m== 1 && n == 1) {
        	return answer;
        }
        int waterAryLenght = puddles.length;
        if(m*n-2 == waterAryLenght)
        	return answer;
        
        this.m = m;
        this.n = n;
		int[][] load = new int[m+1][n+1];
		memory = new int[m+1][n+1];
		int[] waterPosition = null; 
		//물에 잠긴곳들의 위치를 담는다.
		for(int i = 0 ; i < waterAryLenght ; i++) {
			waterPosition = puddles[i];
			load[waterPosition[0]][waterPosition[1]] = -1;
		}
		int i = 0;
		for(i = 1 ; i < m+1 ; i++) {
			if(load[i][1] == -1) {
				memory[i][1] = -1;
				break;
			}else {
				memory[i][1] = 1;
			}
		}
		for(; i < m+1 ; i++) {
			memory[i][1] = -1;
		}
		
		
        for(i = 1 ; i < n+1 ; i++) {
        	if(load[1][i] == -1) {
				memory[1][i] = -1;
				break;
			}else {
				memory[1][i] = 1;
			}
        }
        for(; i<n+1; i++) {
        	memory[1][i] = -1;
        }
        
        
        int waterChk1 = 0;
        int waterChk2 = 0;
        
        for(int k = 2 ; k < m+1 ; k++) {
        	for(int j = 2 ; j < n+1 ; j++) {
        		if(load[k][j] != -1) {
        			waterChk1 = memory[k-1][j];
        			if(load[k-1][j] == -1 || waterChk1 == -1) {
        				waterChk1 = 0;
        			}
        			
        			waterChk2 = memory[k][j-1];

        			if(load[k][j-1] == -1 || waterChk2 == -1) {
        				waterChk2 = 0;
        			}
        			
        			memory[k][j] = (waterChk1 + waterChk2)%1000000007; // 중간 계산 결과들을 나머지로 계속 나누어 주어야 가능하다.(이부분을 놓쳐서 효율성에서 정답이 안나왔다.중간 결과값들의 나머지를 계속 구해주어야함)
        		}
        	}
        }
		answer = memory[m][n];
       
        return answer;
    }
	//답은 나오나 시간복잡도에서 밀림.
	public int solution2(int m, int n, int[][] puddles) {

		int answer = 0;
		if(m== 1 && n == 1) {
			return answer;
		}
		int waterAryLenght = puddles.length;
		if(m*n-2 == waterAryLenght)
			return answer;

		this.m = m;
		this.n = n;
		int[][] load = new int[m+1][n+1];
		memory = new int[m+1][n+1];
		int[] waterPosition = null; 
		//물에 잠긴곳들의 위치를 담는다.
		for(int i = 0 ; i < waterAryLenght ; i++) {
			waterPosition = puddles[i];
			load[waterPosition[0]][waterPosition[1]] = -1;
		}
		searchLoad(load,1,1,0);
		
		answer = routeCnt%1000000007;
	       
        return answer;
		
	}
	
	public void searchLoad(int[][] load,int x , int y, int route) {
		if(x > m || y > n) {
			return;
		}
		
		if(load[x][y] == -1) {
			return;
		}
		
		if( (x == m -1 && y == n) || (x == m && y == n-1)) {
			routeCnt++;
			return;
		}
		
		searchLoad(load,x+1,y,route+1);
		searchLoad(load,x,y+1,route+1);
	}

}

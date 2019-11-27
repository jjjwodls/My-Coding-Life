package programmersAlgo;

import java.util.*;
/**
 * N으로 표현 문제 설명 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 * 
 * 12 = 5 + 5 + (5 / 5) + (5 / 5) 
 * 12 = 55 / 5 + 5 / 5 
 * 12 = (55 + 5) / 5
 * 
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 
 * 그리고 이중 가장 작은 경우는 4입니다. 
 * 이처럼 숫자 N과 number가 주어질 때, N과
 * 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 * 
 * 제한사항 N은 1 이상 9 이하입니다. number는 1 이상 32,000 이하입니다. 
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다. 
 * 최솟값이 8보다 크면 -1을 return 합니다. 
 * 
 * 입출력 예
 * N number return 
 * 5 12 4 
 * 2 11 3
 * 
 * 입출력 예 설명 예제 #1 문제에 나온 예와 같습니다.
 * 예제 #2 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 * 
 * @author jjjwodls
 *
 */
public class DynamicProgramming_Nexpression {

	public static void main(String[] args) {
		DynamicProgramming_Nexpression dynamicProgramming_Nexpression = new DynamicProgramming_Nexpression();
		dynamicProgramming_Nexpression.solution2(5, 12);
	}	

	public int solution(int N, int number) {
		int answer = 0;
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		if(N  == number) {
			return 1;
		}
		
		int i = 2;
		Integer tempInteger = null;
		String tempString = null;
		String strNum = String.valueOf(N);
		
		String[] calArray = new String[5];
		
		
		
		while(true) {
			
			if(i == 9) {
				answer = -1;
				break;
			}
			
			//스트링 붙이기 연산
			for(int j = 0 ; j < i ; j++) {
				calArray[0] += strNum;
			}
			
			
			i++;
		}
		
		//int i = 2;
		// 55 , 5*5 , 5+5 , 5-5 , 5/5  
		// 555 , 5*5*5 , 5+5+5 , 5-5-5 , 5/5/5  >>> 5*5+5 , 5*5-5 ,5*5*5,  5*5/5 , (5+5)*5 , (5+5)-5 , (5+5)/5 , (5/5) +5  
		// 555, 5+5+5, 5-5+5, 5/5+5 ,5*5 +5 , 5*5 - 5 , 55 + 5 , (55 + 5) / 5 , (55/5)*5, (5/5)*5 , (55 - 5) / 5 , 5*(5+5) , 5*(5-5)  ,5*5*5   
		// 555, 15 , 	5 , 	6 , 	30 , 	20 , 	60 , 		12 , 			55 , 	5 , 		10,			50,			0	  , 
		// 5555 , 5+5+5+5 , 5+5+5-5 , 5+5-5-5 x , 5*5*5-5 , 5*5*-5-5 , 5*5+5+5,
		// 더하는 방법 5+5 빼는방법 5-5 (x ) , 
		
		return answer;
	}
	
	//DFS 로 해결 가능하다...
	int answer = -1;

    public int solution2(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }

    public void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) {
            nn=nn*10+n;
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }
}

package PrepareLife;

import java.util.ArrayList;
import java.util.HashMap;

public class ClimbingtheLeaderboard {
	
	public static void main(String[] args){
		int[] scores = new int[6];
		
		scores[0] = 100;
		scores[1] = 90;
		scores[2] = 90 ;
		scores[3] = 80 ;
		scores[4] = 75 ;
		scores[5] = 60 ;
		
		int[] alice = new int[5];
		alice[0] = 50;
		alice[1] = 65;
		alice[2] = 77 ;
		alice[3] = 90 ;
		alice[4] = 102 ;
		
		int[] rst = climbingLeaderboard(scores,alice);
		
		for(int i = 0 ; i < rst.length ; i++){
			System.out.println(rst[i]);
		}
		
	
	}
	
	public static int[] climbingLeaderboard(int[] scores, int[] alice) {
		
		int scoreLen = scores.length;
		int aliceLen = alice.length;
		int[] resultRank = new int[aliceLen];
		
		HashMap<Integer,Integer> rankMap = new HashMap<Integer,Integer>();
		
		int rank = 1;
		int tempScore = scores[0];
		
		rankMap.put(1,tempScore);
		int i = 0;
		
		//점수별로 rank 정리.
		for(i = 1 ; i < scoreLen ; i++){
			if(tempScore > scores[i]){
				rankMap.put(++rank,scores[i]);
			}
			tempScore = scores[i];
		}
		
		
		int curScoreAlice = 0;
		int j = 0;
		int rankMapSize = rankMap.size();
		
	/*	1번방법
	 * for(i = 0 ; i < aliceLen ; i++){
			curScoreAlice = alice[i];
			for(j = 1; j <= rankMapSize ; j++){
				if(curScoreAlice >= rankMap.get(j)){
					resultRank[i] = j;
					break;
				}
			}
			
			if(j == rankMapSize+1){
				resultRank[i] = j;
			}
		}*/
		
		
		/*
		 * 2번방법은 마지막 사이즈와 현재점수를 비교해서 마지막랭크인지 확인
		 * for(i = 0 ; i < aliceLen ; i++){
			curScoreAlice = alice[i];
			
			   if(curScoreAlice < rankMap.get(rankMapSize)){
	                resultRank[i] = rankMapSize+1;
	                continue;
	            }
			
			for(j = 1; j <= rankMapSize ; j++){
				if(curScoreAlice >= rankMap.get(j)){
					resultRank[i] = j;
					break;
				}
			}
			
		}
		*/
		
		/**
		 * 알고리즘 문제 푸는중 
		 * 정답 
		 */
		int curRank = rankMapSize;
		// 점수가 x 일때 몇등.
		for(i = 0 ; i < aliceLen ; i++){
			curScoreAlice = alice[i];
			
		    if(curScoreAlice < rankMap.get(rankMapSize)){
	                resultRank[i] = rankMapSize+1;
	                curRank = rankMapSize;
	                continue;
	        }else if(curScoreAlice >= rankMap.get(1)){ //만약 현재 점수가 랭킹 1등이면 더이상 체크할 필요가 없다.
	        	resultRank[i] = 1;
	        	break;
	        }
				
			for(j = curRank; j > 0 ; j--){
				if(curScoreAlice < rankMap.get(j)){
					resultRank[i] = j+1;
					curRank = j+1;
					break;
				}else if(curScoreAlice == rankMap.get(j)){
					resultRank[i] = j;
					curRank = j;
					break;
				}
			}
				
		}
		
		for(; i < aliceLen ; i++){
			resultRank[i] = 1;
		}
		
		//1000개까진 돌아가는데 그 이상되면 시간복잡도가 너무 커서 그런지 시간초과 
		
		return resultRank;
    }
}

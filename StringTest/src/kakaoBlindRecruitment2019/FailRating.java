package kakaoBlindRecruitment2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
 * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
 * 
 * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게
 * 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
 * 
 * 실패율은 다음과 같이 정의한다. 
 * 	스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은
 * 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 * 
 * 제한사항 
 * 
 * - 스테이지의 개수 N은 1 이상 500 이하의 자연수이다. 
 * - stages의 길이는 1 이상 200,000 이하이다. 
 * - stages에는 1 이상 N + 1 이하의 자연수가 담겨있다. 
		- 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다. 
		- 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
		 
 * - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다. 
 * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다. 
 * 입출력 예
 *  N 			stages 				result 
 *  5 	[2, 1, 2, 6, 2, 4, 3, 3] [3,4,2,1,5] 
 *  4 	[4,4,4,4,4] 			 [4,1,2,3] 
 *  입출력 예 설명 
 *  입출력 예 #1 
 *  1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은
 * 다음과 같다.
 * 
 * 1 번 스테이지 실패율 : 1/8 
 * 
 * 2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
 * 2 번 스테이지 실패율 : 3/7 
 *
 * 마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
 * 3 번 스테이지 실패율 : 2/4 
 * 4번 스테이지 실패율 : 1/2 
 * 5번 스테이지 실패율 : 0/1 
 * 각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
 * [3,4,2,1,5] 
 * 
 * 입출력 예 #2
 * 모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
 * [4,1,2,3]
 * 
 * @author JJI
 * 
 */

/**
 * 정렬 기준 , 그리고 객체 생성을 하면서 구현하자.
 *
 */
public class FailRating {
	
	public static void main(String[] args) {
		//int N = 5;
		//int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};		
		int N = 4;
		int [] stages = {4, 4, 4, 4, 4};
		//solution(N,stages);
		int[] rst = solution2(N,stages);
		for(int i = 0 ; i < rst.length ; i++){
			System.out.println(rst[i]);
		}
		
	}
	
	
    public static int[] solution(int N, int[] stages) {
    	
    	int[] answer = {};
        answer = new int[N];
    	
    	Arrays.sort(stages);
    	int stagesLength = stages.length;
    	int remainUser = stagesLength;
    	int curStageUser = 0;
    	
    	Map<Float,Integer> map = new HashMap<Float,Integer>();
    	
    	List<Float> resultList = new ArrayList<Float>();
    	List<FailSortObject> resultList2 = new ArrayList<FailSortObject>();
    	
    	
    	Float failRating = null;
    	int i = 0;
    	int firstStage =stages[0]; // 첫번째 배열의 스테이지.
    	FailSortObject failSortObject = null; 
    	if(firstStage > 1){
    		for(i = 0 ; i < firstStage-1; i++){
    			resultList.add((float) 0.0);
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(i+1);
    			failSortObject.setFailRating((float) 0.0);
    			resultList2.add(failSortObject);
    			
        	}
    	}
    	//remainUser = remainUser - i;
    	int curStage = firstStage;
    	
    	for(i=0 ;i < stagesLength; i++){

    		if(stages[i] > N){
    			failRating = (float)curStageUser/remainUser;
    			resultList.add(failRating);
    			map.put(failRating, resultList.size());
    			curStageUser = 0;
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(curStage);
    			failSortObject.setFailRating(failRating);
    			resultList2.add(failSortObject);
    			
    			break;
    		}else if(curStage < stages[i]){
    			failRating = (float)curStageUser/remainUser;
    			resultList.add(failRating);
    			map.put(failRating, resultList.size());
    			curStage = stages[i];
    			remainUser = remainUser - curStageUser;
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(curStage);
    			failSortObject.setFailRating(failRating);
    			resultList2.add(failSortObject);
    			curStageUser = 1;
    		}else if(curStage == stages[i] || stages[i] == N){
    			curStageUser++;
    		}
    	}
    	failRating = (float)curStageUser/remainUser;
		resultList.add(failRating);
		failSortObject = new FailSortObject();
		failSortObject.setIdx(curStage);
		failSortObject.setFailRating(failRating);
		resultList2.add(failSortObject);
    	
		Float[] resultAry = resultList.toArray(new Float[resultList.size()]);
		for(i = 0 ; i < resultAry.length ; i++){
    		System.out.println(resultAry[i]);
    	}
		System.out.println("=============");
		System.out.println("=============");
		Arrays.sort(resultAry);
		
		for(i = 0 ; i < resultAry.length ; i++){
    		System.out.println(resultAry[i]);
    	}
		
		System.out.println("=============");
		System.out.println("=============");
		
		Collections.sort(resultList); //jdk 버전 확인하기
    	
    	for(i = 0 ; i < resultList.size() ; i++){
    		System.out.println(resultList.get(i));
    	}

    	Collections.reverse(resultList);
    	System.out.println("=============");
    	Integer stageSort = null;
    	int beforeSort = 0;
    	for(i = 0 ; i < resultList.size() ; i++){
    		//System.out.println(resultList.get(i));
    		stageSort = map.get(resultList.get(i));
    		if(stageSort == null){
    			answer[i] = i+1;
    		}else{
    			if(beforeSort == stageSort){
    				answer[i] = stageSort+1;
    			}else{
    				answer[i] = stageSort;
    			}
    			beforeSort = answer[i];
    		}
    	}
    	
    	for(i = 0 ; i < answer.length; i++){
    		System.out.println(answer[i]);
    	}
    	
        return answer;
    }
    
    
    public static int[] solution2(int N, int[] stages) {
    	
    	int[] answer = {};
    	
    	Arrays.sort(stages);
    	int stagesLength = stages.length;
    	int remainUser = stagesLength;
    	int curStageUser = 0;
    	List<FailSortObject> resultList2 = new ArrayList<FailSortObject>();
    	
    	Float failRating = null;
    	int i = 0;
    	int firstStage =stages[0]; // 첫번째 배열의 스테이지.
    	FailSortObject failSortObject = null; 
    	if(firstStage > 1){
    		for(i = 0 ; i < firstStage-1; i++){
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(i+1);
    			failSortObject.setFailRating((float) 0.0);
    			resultList2.add(failSortObject);
    			
        	}
    	}
    	//remainUser = remainUser - i;
    	int curStage = firstStage;
    	
    	for(i=0 ;i < stagesLength; i++){

    		if(stages[i] > N){
    			failRating = (float)curStageUser/remainUser;
    			curStageUser = 0;
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(resultList2.size()+1);
    			failSortObject.setFailRating(failRating);
    			resultList2.add(failSortObject);
    			break;
    		}else if(curStage < stages[i]){
    			failRating = (float)curStageUser/remainUser;
    			curStage = stages[i];
    			remainUser = remainUser - curStageUser;
    			failSortObject = new FailSortObject();
    			failSortObject.setIdx(resultList2.size()+1);
    			failSortObject.setFailRating(failRating);
    			resultList2.add(failSortObject);
    			curStageUser = 1;
    		}else if(curStage == stages[i] || stages[i] == N){
    			curStageUser++;
    		}
    	}
    	failRating = (float)curStageUser/remainUser;
		failSortObject = new FailSortObject();
		failSortObject.setIdx(resultList2.size()+1);
		failSortObject.setFailRating(failRating);
		resultList2.add(failSortObject);
    	
		Collections.sort(resultList2, new Comparator<FailSortObject>() {
			@Override
			public int compare(FailSortObject o1, FailSortObject o2) {
				if(o1.getFailRating() > o2.getFailRating()){
					return -1;
				}else if(o1.getFailRating() < o2.getFailRating()){
					return 1;
				}else{
					return 0;
				}
			}
		});

    	int listSize = resultList2.size();
    	answer = new int[listSize];
    	for(i = 0 ; i < listSize; i++){
    		answer[i] = resultList2.get(i).getIdx();
    	}
    	
        return answer;
    }
    
    
    public static class FailSortObject{
    	
    	private int idx;
    	private float failRating;
    	
    	public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public float getFailRating() {
			return failRating;
		}
		public void setFailRating(float failRating) {
			this.failRating = failRating;
		}
    	
    }
}

/**
 *
 * 
 * public int[] solution(int N, int[] stages){
        int[] answer = {};
        answer = new int[N];

        List<item> list = new LinkedList<item>();

        for(int i = 1; i <= N; i++){
            int stagePeople = 0;
            int challengePeople = 0;
            for(int j = 0; j < stages.length; j++){
                if(i <= stages[j]){
                    stagePeople++;
                    if( i == stages[j]){
                        challengePeople++;
                    }
                }
            }

            double fail = (double)challengePeople / (double)stagePeople;
            list.add(new item(i, fail));
        }

        Collections.sort(list, new Comparator<item>(){
            @Override
            public int compare(item i1, item i2){
                System.out.println(i1.index + " vs " + i2.index);
                if(i1.fail > i2.fail){
                    return -1;
                } else if(i1.fail < i2.fail){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).index;
        }
        return answer;
    }

    class item {
        public int index;
        public double fail;
        public item(int i, double f){
            this.index = i;
            this.fail = f;
        }
    }
}
 * 
*/
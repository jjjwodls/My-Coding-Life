package programmersAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막
 * 문제까지 다음과 같이 찍습니다.
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2번 수포자가 찍는 방식: 2, 1, 2, 3,
 * 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4,
 * 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에
 * 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 조건 시험은 최대 10,000 문제로 구성되어있습니다. 문제의 정답은 1, 2, 3, 4, 5중 하나입니다. 가장 높은 점수를 받은
 * 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요. 
 * 입출력 예 
 * answers 	   return 
 * [1,2,3,4,5] [1]
 * [1,3,2,4,2] [1,2,3] 입출력 예 설명 입출력 예 #1
 * 
 * 수포자 1은 모든 문제를 맞혔습니다. 
 * 수포자 2는 모든 문제를 틀렸습니다. 
 * 수포자 3은 모든 문제를 틀렸습니다. 
 * 따라서 가장 문제를 많이
 * 맞힌 사람은 수포자 1입니다.
 * 
 * 입출력 예 #2
 * 
 * 모든 사람이 2문제씩을 맞췄습니다.
 * 
 * @author jjjwodls
 * 완전탐색
 */

public class PreExam {

	public static void main(String[] args) {
		//int[] answer = {1,2,3,4,5};
		int[] answer = {1,3,2,4,2};
		
		solution(answer);
	}
	
    public static int[] solution(int[] answers) {
    	
    	int answerLength = answers.length;
    	
    	int[] userA = {1,2,3,4,5};
    	int[] userB = {2,1,2,3,2,4,2,5};
    	int[] userC = {3,3,1,1,2,2,4,4,5,5};
    	
    	List<UserAnswer> list = new ArrayList<UserAnswer>();
    	
    	UserAnswer userAnswer = null;
    	
    	UserAnswer userAnswerA = new UserAnswer();
    	UserAnswer userAnswerB = new UserAnswer();
    	UserAnswer userAnswerC = new UserAnswer();
    	
    	userAnswerA.setUserNum(1);
    	userAnswerB.setUserNum(2);
    	userAnswerC.setUserNum(3);
    	
    	list.add(userAnswerA);
    	list.add(userAnswerB);
    	list.add(userAnswerC);
    	
    	//int scoreA , scoreB , scroeC;
    	
    	for(int i = 0 ; i < answerLength ; i++) {
    		
    		if(answers[i] == userA[i%userA.length]) {
    			userAnswer = list.get(0);
    			userAnswer.setAnswerCnt(userAnswer.getAnswerCnt()+1);
    		}
    		
    		if(answers[i] == userB[i%userB.length]) {
    			userAnswer = list.get(1);
    			userAnswer.setAnswerCnt(userAnswer.getAnswerCnt()+1);
    		}
    		
    		if(answers[i] == userC[i%userC.length]) {
    			userAnswer = list.get(2);
   				userAnswer.setAnswerCnt(userAnswer.getAnswerCnt()+1);
    		}
    	}
    	
    	Collections.sort(list, new Comparator<UserAnswer>() {
			@Override
			public int compare(UserAnswer o1, UserAnswer o2) {
				if (o1.getAnswerCnt() > o2.getAnswerCnt()) {
					return -1;
				}else if(o1.getAnswerCnt() < o2.getAnswerCnt()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
    	
    	int i = 0;
    	
    	for(i = 0 ; i < list.size()-1 ; i++) {
    		if(list.get(i).getAnswerCnt() != list.get(i+1).getAnswerCnt()) {
    			break;
    		}
    	}
    	int[] answer = new int[i+1];
    	for(i = 0 ; i < answer.length ; i++) {
    		answer[i] = list.get(i).getUserNum();
    	}
        return answer;
    }
    
    public static class UserAnswer {
    	
    	private int userNum;
    	private int answerCnt;
    	
		public int getUserNum() {
			return userNum;
		}
		public void setUserNum(int userNum) {
			this.userNum = userNum;
		}
		public int getAnswerCnt() {
			return answerCnt;
		}
		public void setAnswerCnt(int answerCnt) {
			this.answerCnt = answerCnt;
		}
    	
    }
    
    /** Math.max 를 잘 활용하자... 다른 사람의 정답인데 정갈하게 잘 활용했다.
     *  
     *  개선점은 score 배열보단 int 변수 3개가 좋다는 말도 있었고
     *  루핑돌 때 length를 미리 계산해 놓으면 확실히 빠르다.
     *  
     *  int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
     */

}

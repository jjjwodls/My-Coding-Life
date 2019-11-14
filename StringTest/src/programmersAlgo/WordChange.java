package programmersAlgo;

import java.util.*;

/**
 * 단어 변환 문제 설명 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여
 * begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다. 2. words에 있는 단어로만 변환할 수 있습니다. 예를 들어 begin이 hit,
 * target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog ->
 * cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을
 * target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항 각 단어는 알파벳 소문자로만 이루어져 있습니다. 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다. 
 * begin과 target은 같지 않습니다. 
 * 변환할 수 없는 경우에는 0를 return 합니다. 
 * 입출력 예 
 * begin target 	words 					return 
 * hit 		cog [hot, dot, dog, lot, log, cog] 4 
 * hit 		cog [hot, dot, dog, lot, log] 	   0 
 * 입출력 예 설명 
 * 
 * 예제 #1 문제에 나온 예와 같습니다.
 * 예제 #2 target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.
 * 
 * @author jjjwodls
 *  
 * 단어의 순서도 중요하다. 예를들어 abc acb 와 같은 것은 전부 같은것임.
 */
public class WordChange {
	
	public static List<Integer> list =  new ArrayList<Integer>();
	
	public static String[] wordsAry = null;
	public static Integer cnt = 0;
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
		System.out.println(solution(begin, target, words));

	}

/*	
 * 오답
 * public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		Stack<String> stack = new Stack<String>();
		
		wordsAry = words;
		
		stack.push(begin);
		int n = words.length;
		boolean[] visted = new boolean[n];
		//DFS(target,words,visted,n,stack);
		answer = DFS(begin, target, visted, n, 0);
		
		if(list.size() == 0) {
			answer = 0;
		}else {
			Collections.sort(list);
			answer = list.get(0);
		}
		
		return answer;
	}
	
	public static void DFS(String target, String[] words,boolean[] visted,int n,Stack<String> stack) {
		String compare = stack.peek();
		for(int i = 0 ; i < n ; i++) {
			if(!visted[i]) {
				String word = words[i];
				int diffCnt = 0;
				boolean chk = true;
				for(int j = 0 ; j < word.length(); j++) {
					if(compare.charAt(j) != word.charAt(j)) {
						diffCnt++;
					}
					if(diffCnt>1) {
						chk = false;
						break;
					}
				}
				if(chk) {
					stack.push(word);
					visted[i] = true;
					DFS(target,words,visted,n,stack);
				}
				visted[i] = false;
			}
		}
		if(target.equals(stack.pop())) {
			list.add(stack.size());
		}
		
	}
	*
	*
	*/
	
	/*
	 * 다른 사람 답안. (너비우선 탐색으로 queue 를 사용)
	 * 
	 * public static int solution(String begin, String target, String[] words) {

        Queue<String> queue = new LinkedList<String>();
        queue.offer(begin);

        boolean has_target = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                has_target = true;
            }
        }
        if(!has_target) return 0;


        int answer = 0;

        while(true) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(target)) return answer;

                for(int j=0; j<words.length; j++){
                    if(diff(str, words[j])==1){
                        queue.offer(words[j]);
                    }
                }
            }
            answer += 1;

            if(answer > words.length) return 0;
        }

    }

    public static int diff(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }*/
	
	// 깊이우선 탐색으로 stack을 사용. 다른사람 답안.
    public static int solution(String begin, String target, String[] words) {
    	boolean exist = false;
    	System.out.println("begin : " + begin +", target :"+target + "\n");
    	
    	System.out.print("words print : ");
    	for(String word: words) { //(1) 변환할 문자열을 체크한다. 만약 없으면 끝.
    		System.out.print(word + ",");
    		if(target.equals(word)) {
    			exist = true;
    		}
    	}
    	System.out.println();
    	if(exist) {
    		int result = 0;
    		Stack<String> stack = new Stack<>();
    		stack.push(begin);
    		int k = 1;
    		while(!stack.empty()&&result<words.length) {
    			String current = stack.pop();
    			System.out.println("\n"+current + " 을 스택에서 꺼내어 다음 비교 진행");
    			System.out.println(k + "번째 수행");
    			if(isChangable(current, target)) { // 내 현재 문자열과 target 문자열과 변경 가능하므로 성공. (1) 에서 변환할 문자열을 전부 체크하므로 target은 무조껀 존재한다.
    				System.out.println("종료");
    				return result+1;  //target 문자열은 필수적으로 존재하므로 경우의 수는 현재 level + 1 이므로 끝낸다.
    			}
    			for(int i=0;i<words.length;i++) {
    				if(isChangable(current, words[i])) {
    					stack.push(words[i]);
    				}
    			}
    			for(int i = 0 ; i < stack.size() ; i++) {
    				System.out.print(i+" : " + stack.get(i)+" , ");
    			}
    			System.out.println();
    			k++;
    			result++; // 한단계 더 들어가서 찾는다.
    		}
    	}
    	return 0;
    }

    public static boolean isChangable(String str1, String str2) {
    	int count = 0;
    	for(int i=0;i<str1.length();i++) {
    		if(str1.charAt(i)!=str2.charAt(i)) {
    			count++;
    		}
    	}
    	return count==1;
    }


}

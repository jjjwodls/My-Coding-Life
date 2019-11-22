package programmersAlgo;

import java.util.*;
/**
 * 조이스틱 문제 설명 조이스틱으로 알파벳 이름을 완성하세요. 
 * 
 * 맨 처음엔 A로만 이루어져 있습니다. 
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 * 
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 * 
 * ▲ - 다음 알파벳  
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로) 
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서) 
 * ▶ - 커서를 오른쪽으로 이동 예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
 * 
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다. 
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다. 
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다. 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다. 
 *  만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요. 제한 사항 name은 알파벳 대문자로만 이루어져 있습니다. 
 *  name의 길이는 1 이상 20 이하입니다. 
 *  
 *  입출력 예 
 *  name return 
 *  JEROEN 56 
 *  JAN 23
 *  1) 우측으로 이동하는 경우 : J : 9번 , -> 1번 , -> 1번 , N : 13번  ==> TOTAL 24번
 *  2) 좌측으로 이동하는 경우 : J : 9번 , <- 1번 , N : 13번 , <- 1번  ==> ToTAL 24번
 * 
 * @author jjjwodls
 * 문제가 뭔가 이상한것으로 판단됨.
 */
public class Greedy2_Joystick {

	public static void main(String[] args) {
		/*System.out.println('M' - 'A');
		System.out.println('N' - 'A');
		System.out.println('Z' - 'N'+1);*/
		String name1 = "AZAZAAAAAB";
		//String name1 = "AABAAAAAAAB";
		
		Greedy2_Joystick greedy2_Joystick = new Greedy2_Joystick();
		int rst = greedy2_Joystick.solution2(name1);
		System.out.println(rst);
		
	}
	//내가 이동하는 횟수 + 움직여서 완성해야 하는 문자열을 횟수를 확인하여 선택한다.
	//if JAZ 같은 경우 J를 먼저 변경하고 (시작이므로) 좌측으로 갈지 우측으로 갈지 선택해야된다.
	//좌측 이동 시 2번의 변경 필요. 우측 이동 시 3번 변경 필요
    public int solution(String name) {
        int answer = 0;
        char[] nameAry = name.toCharArray();

        //0시작 후 끝에서부터 데이터를 꺼내면서 확인.좌측방향으로
        Stack<Character> rightStack = new Stack<>();
        //0부터 차례대로  데이터를 꺼내면서 확인 우측방향
        Queue<Character> leftQueue = new LinkedList<>();
        leftQueue.offer(nameAry[0]);
        for(int i = 1 ; i < nameAry.length; i++) {
        	rightStack.push(nameAry[i]);
        	leftQueue.offer(nameAry[i]);
        }
        rightStack.push(nameAry[0]);
        
        int rightCnt = 0;
        int leftCnt = 0;
        char compareChar;
        boolean chk = false;
        //JAZ 
        //우측방향 : J : 9번 , -> 1번 , -> 1번 , Z : 1번
        //좌측방향 : J : 9번, <- 1번 , Z : 1번  끝 . A는 변경할 필요 없으니.
        // JAAAZ 인 경우 생각해보자. J를 바꾸고 나서 
        while(!rightStack.isEmpty()) {
        	compareChar = rightStack.pop();
        	chk = false;
        	
        	if(compareChar != 'A') {
        		if(compareChar <'N') {
        			rightCnt+= compareChar - 'A';
        		}else {
        			rightCnt+= 'Z' - compareChar+1;
        		}
        	}
        	
        	for(int i = 0 ; i < rightStack.size() ; i++) {
        		if(rightStack.get(i) != 'A') {
        			chk = true;
        			break;
        		}
        	}
        	if(!chk) 
        		break;
        	
        	rightCnt++;
        	
        }
        
        while(!leftQueue.isEmpty()) {
        	compareChar = leftQueue.poll(); 
        	chk = false;
        	
        	if(compareChar != 'A') {
        		if(compareChar <'N') {
        			leftCnt+= compareChar - 'A';
        		}else {
        			leftCnt+= 'Z' - compareChar+1;
        		}
        	}
        	Iterator<Character> iterator =  leftQueue.iterator();
        	while(iterator.hasNext()) {
        		if(iterator.next() != 'A') {
        			chk = true;
        			break;
        		}
        	}
        	if(!chk)
        		break;
        	
        	leftCnt++;
        }
        
        if(rightCnt > leftCnt) {
        	answer = leftCnt;
        }else {
        	answer = rightCnt;
        }
        
        return answer;
    }

	//A 가 아닌놈을 왼쪽으로 찾아가서 바꾸는게 빠른지 오른쪽이 빠른지 탐색해보자.
    //12c3g45 좌측으로는 4번 우측으로는 1번
    //1c234g5 좌측으로는 3번 우측으로는 2번
    
    //1g234c5 좌측으로는 3번 우측으로는 2번
    //size - 우측	 "AZAAAZ"
    public int solution2(String name) {
        int answer = 0;
        char[] nameAry = name.toCharArray();
        
        List<Character> list = new ArrayList<>();
        Queue<Character> tempQueue = new LinkedList<>();
        Character inputChar = null;
        for(int i = 0 ; i < nameAry.length; i++) {
        	inputChar = nameAry[i]; 
        	list.add(inputChar);
        	tempQueue.offer(inputChar);
        }
        
        int moveTotalCnt = 0;
        char compareChar;
        boolean chk = false;
        
        int idx = 0;
        int cursor = 0;
        
        int rightMove = 0;
        int leftMove = 0;
        //AZAZAAAAAB 
        while(idx < list.size()) {
        	compareChar = list.get(idx);
    		if(compareChar == 'A') {
    			idx++;
        		continue;
        	}else {
        		if(compareChar <'N') {
        			moveTotalCnt+= compareChar - 'A';
        		}else {
        			moveTotalCnt+= 'Z' - compareChar+1;
        		}
        	}
    		
    		//AgZAAAcB ==> 7 번 , 5QJS
    		if(cursor > idx) { //무조껀 좌측으로 가야된다.
    			leftMove = cursor-idx; //움직인 횟수
    			rightMove = list.size() -leftMove;
    			if(rightMove > leftMove) {
    				moveTotalCnt += leftMove;
    			}else {
    				moveTotalCnt += rightMove;
    			}
    		}else if(cursor < idx){
    			rightMove = idx-cursor;
    			leftMove = list.size() - rightMove;
    			if(rightMove > leftMove) {
    				moveTotalCnt += leftMove;
    			}else {
    				moveTotalCnt += rightMove;
    			}
    		}
    		cursor = idx;
    		tempQueue.poll();
    		
    		Iterator<Character> iterator =  tempQueue.iterator();
        	while(iterator.hasNext()) {
        		if(iterator.next() != 'A') {
        			chk = true;
        			break;
        		}
        	}
        	if(!chk)
        		break;
        	
        	idx++;
        }
    	answer = moveTotalCnt;
        return answer;
    }
}

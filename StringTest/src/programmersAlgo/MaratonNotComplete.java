package programmersAlgo;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
		
/**
 * 
 * @author JJI
 * @since 2019.09.02
 * 
 * 문제 설명
    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
participant	completion	return
[leo, kiki, eden]	[eden, kiki]	leo
[marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
[mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
입출력 예 설명
예제 #1
leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.


 */
public class MaratonNotComplete {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant,completion));
		
	}
	
/*	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Integer sameName = null;
         
        
        Map<String,Integer> partiMap = new HashMap<String,Integer>();
        Map<String,Integer> compleMap = new HashMap<String,Integer>();
        
        int participantLen = participant.length;
        int completionLen = completion.length;
        int i;
        for(i = 0 ; i < participantLen ; i++) {
        	sameName = partiMap.get(participant[i]);
        	if(sameName == null) {
        		partiMap.put(participant[i],0);
        	}else {
        		partiMap.put(participant[i],++sameName);
        	}
        }
        
        for(i = 0 ; i < completionLen ; i++) {
        	sameName = compleMap.get(completion[i]);
        	if(sameName == null) {
        		compleMap.put(completion[i],0);
        	}else {
        		compleMap.put(completion[i],++sameName);
        	}
        }
        Integer b = null; //참여자 명부에 있는 
        
        for(i = 0 ; i < participantLen ; i++) {
        	sameName = compleMap.get(participant[i]);
        	if(sameName == null) {
        		answer = participant[i];
        		break;
        	}else {
        		b = partiMap.get(participant[i]);
        		if(sameName != b) {
        			answer = participant[i];
        			break;
        		}
        	}
        }
        
        return answer;
       
    }*/

	//2번방법 for문을 줄여보자.
	/*public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Integer partiCnt = null;
        Integer compleCnt = null;
         
        
        Map<String,Integer> partiMap = new HashMap<String,Integer>();
        Map<String,Integer> compleMap = new HashMap<String,Integer>();
        
        int participantLen = participant.length;
        int i;
        String aryTemp = "";
        for(i = 0 ; i < participantLen-1; i++) {
        	aryTemp = participant[i];
        	partiCnt = partiMap.get(aryTemp);
        	if(partiCnt == null) {
        		partiMap.put(aryTemp,0);
        	}else {
        		partiMap.put(aryTemp,++partiCnt);
        	}
        	aryTemp = completion[i];
        	compleCnt = compleMap.get(aryTemp);
        	if(compleCnt == null) {
        		compleMap.put(aryTemp,0);
        	}else {
        		compleMap.put(aryTemp,++compleCnt);
        	}
        }
        partiCnt = partiMap.get(participant[participantLen-1]);
    	if(partiCnt == null) {
    		partiMap.put(participant[participantLen-1],0);
    	}else {
    		partiMap.put(participant[participantLen-1],++partiCnt);
    	}
        
        for(i = 0 ; i < partiMap.size() ; i++) {
        	aryTemp = participant[i];
        	compleCnt = compleMap.get(aryTemp);
        	if(compleCnt == null) {
        		answer = participant[i];
        		break;
        	}else {
        		partiCnt = partiMap.get(aryTemp);
        		if(compleCnt != partiCnt) {
        			answer = participant[i];
        			break;
        		}
        	}
        }
        
        return answer;
       
    }*/
	
	/*3번문제 (다른문제 정답 가져옴 정렬 하자 그냥) 동명이인은 이름이 같은 딱 두사람만 있기 때문에 정렬 하면 금방 끝난다. 동명이인이 아닌 여러 사람이 이름이 같은 사람이 존재할 수도 있다 생각했따 (3명이상) 하지만 그래도 상관없이
	어차피 정렬하면 이름 같은 사람들도 세명이 나란히 있을거니까 거기서 어긋나면 그 사람은 완주하지 못한사람이니까 
	문제의 핵심인 동명이인이므로 정렬 한다음 비교만 하면 그냥 끝나는데 너무 어렵게 생각했다... 여기에 얼마나 많은 시간을 허비한건지....*/
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0 ; i < completion.length; i++){
        	if(!participant[i].equals(completion[i])){
        		return answer = participant[i];
        	}
        }
        
        return participant[participant.length -1];
       
    }
}

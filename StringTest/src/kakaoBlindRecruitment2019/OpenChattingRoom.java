package kakaoBlindRecruitment2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 오픈채팅방 문제 설명 오픈채팅방 카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 가상의 닉네임을
 * 사용하여 채팅방에 들어갈 수 있다.
 * 
 * 신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로
 * 했다. 
 * 
 * 채팅방에 누군가 들어오면 다음 메시지가 출력된다. 
 * [닉네임]님이 들어왔습니다.
 * 채팅방에서 누군가 나가면 다음 메시지가 출력된다.
 * [닉네임]님이 나갔습니다.
 * 
 * 채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
 * 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다. 채팅방에서 닉네임을 변경한다. 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던
 * 메시지의 닉네임도 전부 변경된다.
 * 
 * 예를 들어, 채팅방에 Muzi와 Prodo라는 닉네임을 사용하는 사람이 순서대로 들어오면 채팅방에는 다음과 같이 메시지가 출력된다.
 * 
 * Muzi님이 들어왔습니다. Prodo님이 들어왔습니다.
 * 
 * 채팅방에 있던 사람이 나가면 채팅방에는 다음과 같이 메시지가 남는다.
 * 
 * Muzi님이 들어왔습니다. Prodo님이 들어왔습니다. Muzi님이 나갔습니다.
 * 
 * Muzi가 나간후 다시 들어올 때, Prodo 라는 닉네임으로 들어올 경우 기존에 채팅방에 남아있던 Muzi도 Prodo로 다음과 같이
 * 변경된다.
 * 
 * Prodo님이 들어왔습니다. Prodo님이 들어왔습니다. Prodo님이 나갔습니다. Prodo님이 들어왔습니다.
 * 
 * 채팅방은 중복 닉네임을 허용하기 때문에, 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 두 명이 있다. 이제, 채팅방에 두 번째로
 * 들어왔던 Prodo가 Ryan으로 닉네임을 변경하면 채팅방 메시지는 다음과 같이 변경된다.
 * 
 * Prodo님이 들어왔습니다. Ryan님이 들어왔습니다. Prodo님이 나갔습니다. Prodo님이 들어왔습니다.
 * 
 * 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후,
 * 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
 * 
 * 제한사항 record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다. 
 * 다음은 record에 담긴 문자열에 대한 설명이다. 
 * 모든 유저는 [유저 아이디]로 구분한다. 
 * [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - Enter [유저아이디] [닉네임] (ex. Enter uid1234 Muzi) 
 * [유저 아이디] 사용자가 채팅방에서 퇴장 - Leave [유저 아이디] (ex. Leave uid1234) 
 * [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - Change [유저 아이디] [닉네임] (ex. Change uid1234 Muzi) 
 * 첫 단어는 Enter, Leave, Change 중 하나이다. 
 * 각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다. 
 * 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다. 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다. 
 * 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다. 
 * 입출력 예 
 * record	["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
 * result ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."] 
 * 입출력 예 설명 입출력 예 #1 문제의 설명과 같다.
 * 
 * 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
 * 
 * @author JJI
 * 
 */
public class OpenChattingRoom {

	public static void main(String[] args) {
		String[] recored = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] rst = solution(recored);
		for(int i = 0 ; i < rst.length ; i ++){
			System.out.println(rst[i]);
		}
	}
	
	//내가 푼 방식
    public static String[] solution(String[] record) {
    	String[] answer = {};
    	int inputLength = record.length;
    	String[] tempRecord = null;
    	String tempId = null;
    	String status = null;
    	String nickName = null;
    	HashMap<String,String> idMap = new HashMap<String,String>();
    	int i = 0 ;
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<String> actionList = new ArrayList<String>();
    	
    	int answerLength = 0;
    	
    	for(i = 0 ; i < inputLength ; i++){
    		tempRecord = record[i].split(" ");
    		status = tempRecord[0];
    		tempId = tempRecord[1];
    		nickName = idMap.get(tempId);
    		
    		if(!status.equals("Change")){
    			list.add(tempId);
    			actionList.add(status);
			}
    		
    		if(!status.equals("Leave")){
    			nickName = tempRecord[2];
    			idMap.put(tempId, nickName);
    		}
    		
    	}
    	answerLength = list.size();
    	answer = new String[answerLength];
    	for(i = 0 ; i < answerLength ; i++){
    		status = actionList.get(i);
    		nickName = idMap.get(list.get(i));
			if(status.equals("Leave")){
				answer[i] = nickName+"님이 나갔습니다.";
			}else{
				answer[i] = nickName+"님이 들어왔습니다.";
			}
    	}
    	
        return answer;
    }
    
    public static String[] solution2(String[] record) {
        HashMap<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for(String str:record){
            String[] split = str.split("\\s+");
            String code = split[0];
            String uid = split[1];
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }
            if(!"Change".equalsIgnoreCase(code)){
                list.add(code +" "+uid);
            }

        }
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            String[] split = list.get(i).split("\\s+");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
    }
    
}

/*
 * 다양한 자료구조를 활용하여 반복문 횟수를 줄이고 효율적으로 문제를 풀어나가자. 
 * */

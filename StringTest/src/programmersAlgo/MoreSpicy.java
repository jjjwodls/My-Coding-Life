package programmersAlgo;

import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * 더 맵게
    문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 1 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
입출력 예
scoville			   K	return
[1, 2, 3, 9, 10, 12]	7	2
입출력 예 설명
스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
가진 음식의 스코빌 지수 = [13, 9, 10, 12]

모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 * 
 * @author jjjwodls
 * HEAP 관련 문제
 */
public class MoreSpicy {

	public static void main(String[] args) {
		Map<String,Integer> map = new TreeMap<>();
		TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		treeMap.put(1, 1);
		treeMap.put(5, 5);
		treeMap.put(3, 3);
		treeMap.put(2, 2);
		treeMap.put(4, 4);
//		System.out.println(treeMap);
		Entry<Integer, Integer> entry = treeMap.pollFirstEntry();
//		System.out.println("entry = " + entry);
		entry.getKey();
		
		treeMap.firstEntry();
		treeMap.pollFirstEntry();
//		System.out.println(treeMap.pollFirstEntry());
//		System.out.println(treeMap.size());
		
		map.put("temp3", 5);
		map.put("temp1", 1);
		map.put("temp2", 2);
		Set<Map.Entry<String, Integer>>  set = map.entrySet();
//		System.out.println(set);
		
		MoreSpicy moreSpicy = new MoreSpicy();
		int K = 7;
		int[] scoville = {1, 2, 3, 9, 10, 12};
		moreSpicy.solution2(scoville, K);
		
	}
	
	// 정답은 1개 빼고 다 맞고 효율성이 매우 낮음.
	public int solution2(int[] scoville, int K) {
        int answer = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int input : scoville){
            treeMap.put(input,input);
        }
        
        Entry<Integer, Integer> entry1 = null;
        Entry<Integer, Integer> entry2 = null;
        
        int lowest1;
        int lowest2;
        
        
        int tempScovil;
        
        while(treeMap.size() > 1){
            entry1 = treeMap.pollFirstEntry();
            entry2 = treeMap.pollFirstEntry();
            lowest1 = entry1.getKey();
            lowest2 = entry2.getKey();
            if(lowest1 >= K){
                return answer;
            }
            
            tempScovil = lowest1 + (lowest2*2);
            treeMap.put(tempScovil,tempScovil);
            
            answer++;
        }
        entry1 = treeMap.pollFirstEntry();
        if(entry1.getKey() < K){
            answer = -1;
        }
        
        return answer;
    }
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int input : scoville){
        	priorityQueue.offer(input);
        }
        
        System.out.println(priorityQueue);
        
        int lowest1;
        int lowest2;
        int tempScovil;
        
        while(priorityQueue.size() > 1){
            lowest1 = priorityQueue.poll();
            if(lowest1 >= K){
                return answer;
            }
            lowest2 = priorityQueue.poll();
            tempScovil = lowest1 + (lowest2*2);
            priorityQueue.offer(tempScovil);
            
            answer++;
        }
        lowest1 = priorityQueue.poll();
        if(lowest1 < K) {
        	answer = -1;
        }
        
        return answer;
    }

}

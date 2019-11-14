package programmersAlgo;

import java.util.*;

/**
 * 문제 설명 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.
 * 
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록
 * solution 함수를 작성해주세요.
 * 
 * 제한사항 모든 공항은 알파벳 대문자 3글자로 이루어집니다. 주어진 공항 수는 3개 이상 10,000개 이하입니다. tickets의 각 행
 * [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다. 주어진 항공권은 모두 사용해야 합니다. 만일 가능한 경로가 2개
 * 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다. 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다. 
 * 입출력 예
 * tickets 															return 
 * [[ICN, JFK], [HND, IAD], [JFK, HND]] 					   [ICN, JFK, HND, IAD]
 * [[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]] [ICN, ATL, ICN, SFO, ATL, SFO] 
 * 
 * 입출력 예 설명 예제 #1
 * [ICN, JFK, HND, IAD] 순으로 방문할 수 있습니다.
 * 예제 #2
 * [ICN, SFO, ATL, ICN, ATL, SFO] 순으로 방문할 수도 있지만 [ICN, ATL, ICN, SFO, ATL, SFO] 가 알파벳 순으로 앞섭니다.
 * 
 * @author jjjwodls
 * 
 * 총평 : 문제를 75% 정도 풀었지만 아무래도 깊이우선 탐색에 대한 이해가 부족한것으로 판단된다.
 * 너무 어렵게 생각하고 있으며 깊이 우선 탐색에 더 공부하고 많은 문제를 풀어봐야 할것으로 판단된다.
 *
 */
public class TravelRoute {

	
	public static List<Stack<String>> result = new ArrayList<Stack<String>>();
	
	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		//String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		//String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
		//[[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]]
		//[["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]]
		TravelRoute travelRoute = new TravelRoute();
		String[] rst = travelRoute.solution(tickets);
		for(String result : rst) {
			System.out.print(result + " -> ");
		}
		
	}

	/*public static String[] solution(String[][] tickets) {
		String[] answer = {};
		answer = new String[tickets.length + 1];
		Stack<String> stack = new Stack<String>();
		Queue<Integer> idxQueue = new LinkedList<Integer>();
		
		
		boolean[] visted = new boolean[tickets.length];
		
		String begin = "ICN";
		String temp = "";
		String topStr = "";
		int checkVal = 0;
		stack.push(begin);
		
		while(stack.size() < tickets.length + 1) {
			if(stack.size() < tickets.length + 1) {
				break;
			}
			for (int j = 0; j < tickets.length; j++) {
				if (!visted[j] && tickets[j][0].equals(begin)) {
					visted[j] = true;
					idxQueue.offer(j);
					begin = tickets[j][1];
					while(!stack.isEmpty()) {
						temp = stack.pop();
						topStr = stack.peek();
						checkVal = idxQueue.poll();
						if(topStr.equals(begin)) {
							begin = temp;
							break;
						}
						if(temp.compareTo(topStr) < 0) { //0보다 작으면 오름차순이므로 
							stack.pop();
							visted[checkVal] = false;
							stack.push(temp);
						}else {
							visted[idxQueue.peek()] = false;
						}
						
					}
					stack.push(begin); // 계속 넣는다. 갈 수 있는곳까지.
					visted[j] = false;
				}
			}
		}
		
		for (int i = 0; i < stack.size(); i++) {
			answer[i] = stack.get(i);
		}
		return answer;
	}

	*//**
	 * String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[][] tickets = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
	 *//*
	public static void dfs(String[][] tickets,int level, boolean[] visted, String begin,Stack<String> stack) {
		String temp = "";
		String topStr = "";
		for (int j = 0; j < tickets.length; j++) {
			if (!visted[j] && tickets[j][0].equals(begin)) {
				visted[j] = true;
				begin = tickets[j][1];
				while(!stack.isEmpty()) {
					temp = stack.pop();
					topStr = stack.peek();
					if(topStr.equals(begin)) {
						begin = temp;
						break;
					}
					if(temp.compareTo(topStr) < 0) { //0보다 작으면 오름차순이므로 
						stack.pop();
						stack.push(temp);
					}
				}
				stack.push(begin); // 계속 넣는다. 갈 수 있는곳까지.
				if(stack.size() == tickets.length +1) 
					return;
				dfs(tickets,level,visted,begin,stack);
				visted[j] = false;
			}
		}
	}*/
	
	
	public String[] solution(String[][] tickets) {
		
		int ticketLength = tickets.length;
		String[] answer = {};
		answer = new String[ticketLength + 1];
		
		boolean[] visted = new boolean[ticketLength];
		Stack<String> st = new Stack<>();
        st.push("ICN");
        dfs(visted, st, 0,tickets);
        
        Collections.sort(result, new Comparator<Stack<String>>() {

			@Override
			public int compare(Stack<String> o1, Stack<String> o2) {
				int arySize = o1.size();
				for(int i = 0 ; i < arySize ; i++) {
					if(o1.get(i).compareTo(o2.get(i)) == 0) {
						continue;
					}
					if(o1.get(i).compareTo(o2.get(i)) < 0) {
						return -1;
					}else {
						return 1;
					}
				}
				return 0;
			}
		});
        
        st = result.get(0);
		for (int i = 0; i < st.size(); i++) {
			answer[i] = st.get(i);
		}
		
		//내가푼거
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String begin = "ICN";
		
		ArrayList<String> tempList= null;
		
		for(int i = 0 ; i < ticketLength ; i++) {
			if (tickets[i][0].equals(begin)) {
				visted = new boolean[ticketLength];
				visted[i] = true;
				tempList = new ArrayList<String>();
				tempList.add(begin);
				dfs(tickets,visted,tempList,tickets[i][1]);
				if(tempList.size() == ticketLength+1) {
					list.add(tempList);
				}
			}
		}
		Collections.sort(list, new Comparator<ArrayList<String>>() {

			@Override
			public int compare(ArrayList<String> o1, ArrayList<String> o2) {
				int arySize = o1.size();
				for(int i = 0 ; i < arySize ; i++) {
					if(o1.get(i).compareTo(o2.get(i)) == 0) {
						continue;
					}
					if(o1.get(i).compareTo(o2.get(i)) < 0) {
						return -1;
					}else {
						return 1;
					}
				}
				return 0;
			}
		});
		tempList = list.get(0);
		for (int i = 0; i < tempList.size(); i++) {
			answer[i] = tempList.get(i);
		}
		return answer;
	}
	
	public void dfs(String[][] tickets,boolean[] visted,ArrayList<String> tempList,String begin){
		for(int i = 0 ; i < tickets.length ; i++) {
			if(!visted[i] && tickets[i][0].equals(begin)) {
				visted[i] = true;
				tempList.add(begin);
				begin = tickets[i][1];
				dfs(tickets,visted,tempList,begin);
				//visted[i] = false;
			}
		}
		if(tempList.size() == tickets.length) {
			tempList.add(begin);
			return;
		}
	}
	
	public class StackNode {
		
		public StackNode(int idx, String nodeValue) {
			this.idx = idx;
			this.nodeValue = nodeValue;
		}
		
		private int idx;
		private String nodeValue;
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public String getNodeValue() {
			return nodeValue;
		}
		public void setNodeValue(String nodeValue) {
			this.nodeValue = nodeValue;
		}
		
		@Override
		public String toString() {
			return "idx = " + this.idx + " nodeValue = " + this.nodeValue;
		}
		
	}
	//순차적으로 깊이 우선 탐색을 진행해야한다. 모든 경우의 수 고려하기. (정답)
	public void dfs(boolean[] visited, Stack<String> st, int len,String[][] tickets) {
		if (len == tickets.length) {
			Stack<String> res = new Stack<>();
			for (String s : st) {
				res.push(s);
			}
			result.add(res);
			return;
		}

		String arrive = st.peek();

		for (int i = 0; i < tickets.length; i++) {
			String[] tic = tickets[i];

			if (!visited[i] && arrive.equals(tic[0])) {
				st.push(tic[1]);
				visited[i] = true;
				dfs(visited, st, len + 1,tickets);
				visited[i] = false;
				st.pop();
			}
		}
	}
	
}

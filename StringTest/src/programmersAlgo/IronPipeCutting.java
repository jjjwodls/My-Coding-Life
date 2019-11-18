package programmersAlgo;

import java.util.*;

/**
 *
 * 제한사항
	arrangement의 길이는 최대 100,000입니다.
	arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
	입출력 예
	arrangement	return
	()(((()())(())()))(())	17
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42585 참고
 * 
 * @author jjjwodls
 *
 * 오답 : 문제 해결이 잘 안됨. 
 * 
 *
 */
public class IronPipeCutting {

	public static void main(String[] args) {
		IronPipeCutting cutting = new IronPipeCutting();
		String arrangement = "()(((()())(())()))(())";
		System.out.println(cutting.solution(arrangement));
		
		
		//System.out.println(arrangement.replace("()","1"));
	}
	// 내가 짠 코드는 속도가 너무 느림. 문제 이해도 제대로 안되어있고 
	/*public int solution(String arrangement) {
		int answer = 0;
		
		if(arrangement.length() > 100000) {
			return 0;
		}
		
		List<Integer> layserList = new ArrayList<>();
		Queue<Lasyer> lasyerQueue = new LinkedList<Lasyer>();
		
		List<Point> pipeList = new ArrayList<Point>();
		
		
		arrangement = arrangement.replace("()","1");
		char[] inputArray = arrangement.toCharArray();
		int aryLenght = inputArray.length;
		
		char left = '(';
		char right = ')';
		Lasyer layser = null;
		
		
		Stack<Integer> temp = new Stack<>();
		for(int i = 0 ; i < aryLenght ; i++) {
			if(inputArray[i] != '1') {
				layser = new Lasyer(i,inputArray[i]);
				lasyerQueue.offer(layser);
			}else {
				layserList.add(i);
			}
		}
		int tempCnt = 0;
		for(int i = 0 ; i < aryLenght ; i++) {
			if(inputArray[i] == left) {
				temp.push(1);
			}else if(inputArray[i] == right) {
				answer += tempCnt+1;
				temp.pop();
			}else {
				tempCnt++;
			}
			
			if(temp.size() == 0) {
				tempCnt = 0;
			}
		}
		
		
		Lasyer pipe1 = null;
		Lasyer pipe2 = null;
		Point point = null;
		
		while(!lasyerQueue.isEmpty()) {
			layser = lasyerQueue.poll();
			if(pipe2!=null && layser.getThing() == right) {
				pipe1 = layser;
				point = new Point(pipe2.getIdx(),pipe1.getIdx());
				pipeList.add(point);
				lasyerQueue.remove(pipe2);
				pipe2 = null;
			}else if(layser.getThing() == left) { 
				pipe2 = layser;
				lasyerQueue.offer(pipe2);
			}else {
				lasyerQueue.offer(layser);
			}
		}
		
		while(!lasyerQueue.isEmpty()) {
			layser = lasyerQueue.poll();
			if( (layser.getIdx()+1 == lasyerQueue.peek().getIdx()) && lasyerQueue.peek().getThing() == right && layser.getThing() == left) {
				layserList.add(lasyerQueue.poll().getIdx());
			}else if(pipe2!=null && layser.getThing() == right) {
				pipe1 = layser;
				point = new Point(pipe2.getIdx(),pipe1.getIdx());
				pipeList.add(point);
				lasyerQueue.remove(pipe2);
				pipe2 = null;
			}else if(layser.getThing() == left) { 
				pipe2 = layser;
				lasyerQueue.offer(pipe2);
			}else {
				lasyerQueue.offer(layser);
			}
		}
		
		
		int pipeListSize = pipeList.size();
		int cnt = 0;
		
		for(int i = 0 ; i < pipeListSize ; i++) {
			cnt = 0;
			point = pipeList.get(i);
			for(Integer layserIdx : layserList) {
				if(point.getX2() < layserIdx) {
					break;
				}else if(point.getX1() < layserIdx && point.getX2() > layserIdx) {
					cnt++;
				}
			}
			if(cnt > 0) {
				cnt += 1;
			}
			answer += cnt;
		}
		
		return answer;
	}
	
	public class Lasyer{
		
		private int idx;
		private char thing;
		
		public Lasyer(int idx, char thing) {
			this.idx = idx;
			this.thing = thing;
		}
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public char getThing() {
			return thing;
		}
		public void setThing(char thing) {
			this.thing = thing;
		}

		@Override
		public String toString() {
			return "idx : " + this.idx + "thing : " + this.thing;
		}
	}
	
	public class Point {
		private int x1;
		private int x2;
		
		public Point(int x1, int x2) {
			this.x1 = x1;
			this.x2 = x2;
		}
		
		public int getX1() {
			return x1;
		}
		public void setX1(int x1) {
			this.x1 = x1;
		}
		public int getX2() {
			return x2;
		}
		public void setX2(int x2) {
			this.x2 = x2;
		}

		@Override
		public String toString() {
			return "Point [x1=" + x1 + ", x2=" + x2 + "]";
		}
		
	}*/
	
	//타인 코드 확인 및 디버깅 
	public static int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(') {
				st.push(i);
			} else if (arrangement.charAt(i) == ')') {
				if (st.peek() + 1 == i) {
					st.pop();
					answer += st.size();
				} else {
					st.pop();
					answer += 1;
				}
			}
		}
		return answer;
	}

}

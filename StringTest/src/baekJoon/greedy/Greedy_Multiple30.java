package baekJoon.greedy;

import java.util.*;


/**
 * 
 * 10610번 30
 * 30의 배수 찾는 문제
 * 아오 컴파일 에러는 누르면 나타나네..
 * @author jjjwodls
 * 
 */
public class Greedy_Multiple30 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine();
		int inputLength = inputStr.length();
		
		char[] ary = inputStr.toCharArray();
		int checkMultiple = 0;
		List<Character> list = new ArrayList<Character>();
		for(int i = 0 ; i < inputLength ; i++) {
			checkMultiple += Character.getNumericValue(ary[i]);
			list.add(ary[i]);
		}
		//0이 없거나 더했을 때 3의 배수가 아니면 30의 배수가 아님.
		if(inputStr.indexOf("0") < 0 || checkMultiple%3 != 0) {
			System.out.println(-1);
		}else {
			Collections.sort(list, new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					return o2-o1;
				}
			});
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < list.size() ; i++) {
				sb.append(list.get(i));
			}
			System.out.println(sb.toString());
		}
		
	}

}

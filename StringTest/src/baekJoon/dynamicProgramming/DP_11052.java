package baekJoon.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DP_11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ary = new int[N+1];
		List<Card> list = new ArrayList<Card>();
		for(int i = 1 ; i <= N ; i++) {
			ary[i] = sc.nextInt();
			list.add(new Card(i,ary[i]/i));
		}
		
		Collections.sort(list,new Comparator<Card>() {
			@Override
			public int compare(Card o1, Card o2) {
                if(o2.value == o1.value) {
					return o1.cnt - o2.cnt;
				}
				return o2.value - o1.value;
			}
		});
		int cardCnt = N;
		int MAX = 0;
		Card card = null;
		for(int i = 0 ; i < N ; i++) {
		    card = list.get(i);
			if(cardCnt/card.cnt > 0) {
				MAX += cardCnt/card.cnt*ary[card.cnt];
				cardCnt = cardCnt%card.cnt;
			}else if(cardCnt-card.cnt > 0){
				cardCnt = cardCnt-card.cnt;
				MAX += ary[card.cnt]; 
			}else if(cardCnt-card.cnt < 0){
				continue;
			}
			
			if(cardCnt == 0) {
				break;
			}
		}
		System.out.println(MAX);
		
	}
	
	public static class Card{
		
		public int cnt;
		public int value;
		
		public Card(int cnt, int value) {
			super();
			this.cnt = cnt;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Card [cnt=" + cnt + ", value=" + value + "]";
		}
		
		
		
		
	}

}

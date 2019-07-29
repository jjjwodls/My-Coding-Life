package PrepareLife;

import java.util.List;

/**
 * Anna and Brian are sharing a meal at a restuarant and they agree to split the
 * bill equally. Brian wants to order something that Anna is allergic to though,
 * and they agree that Anna won't pay for that item. Brian gets the check and
 * calculates Anna's portion. You must determine if his calculation is correct.
 * 
 * 
 * Sample Input 0
 * 
 * 4 1 3 10 2 9 12 
 * 
 * Sample Output 0
 * 
 * 5
 * 
 * Sample Input 1
 * 
 * 4 1 3 10 2 9 7
 * 
 * Sample Output 1
 * 
 * Bon Appetit
 * 
 * @author JJJWODLS
 * @since 2019.07.29
 */
public class BonAppétit {

	// Complete the bonAppetit function below.
	static void bonAppetit(List<Integer> bill, int k, int b) {
		// k is don't eat anna

		bill.remove(k);
		int billSize = bill.size();
		int annaTotal = 0;
		for (int i = 0; i < billSize; i++) {
			annaTotal += bill.get(i);
		}
		int rst = b - annaTotal / 2;

		if (rst > 0) {
			System.out.println(rst);
		} else {
			System.out.println("Bon Appetit");
		}
	}

	public static void main(String[] args) {

	}

}

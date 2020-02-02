package baekJoon.implement;

import java.util.*;

public class Implement_2490 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			String[] input = sc.nextLine().split(" ");
			int front = 0;
			for (int j = 0; j < input.length; j++) {
				if (input[j].equals("1")) {
					front++;
				}
			}

			switch (front) {
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("C");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("A");
				break;
			case 4:
				System.out.println("E");
				break;

			}
		}

	}

}

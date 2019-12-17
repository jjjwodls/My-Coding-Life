package baekJoon.dynamicProgramming;

import java.util.*;

/**
 * LIS 알고리즘으로 최장순열을 구하는 방식이다.
 * 이건 다른 방법이지만 기존 문제에서 짠것을 활용했는데 런타임에러가 나타나서 이걸 사용해보자.
 * @author jjjwodls
 *
 */
public class DP_11053 {

	private static int k;
	private static int[] ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		sc.nextLine();
		ary = new int[k+1];
		int d[] = new int[k+1];
		d[1] = 1;
		for(int i = 1 ; i <= k ; i++) {
			ary[i] = sc.nextInt();
		}
		for (int i = 2; i <=k ; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (ary[i] > ary[j] && d[i] <= d[j])
                    d[i] = d[j] + 1;
                else if (ary[i] == ary[j])
                    d[i] = d[j];
            }
        }
 
        Arrays.sort(d);
        System.out.println(d[k]);
		
	}

}

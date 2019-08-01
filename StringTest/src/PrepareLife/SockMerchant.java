package PrepareLife;

import java.util.Arrays;

/**
 * John works at a clothing store. He has a large pile of socks that he must
 * pair by color for sale. Given an array of integers representing the color of
 * each sock, determine how many pairs of socks with matching colors there are.
 * 
 * For example, n=7 there are socks with colors ar=[1,2,1,2,1,3,2] . There is one pair of color 1 and one
 * of color 2. There are three odd socks left, one of each color. The number of
 * pairs is 2.
 * 
 * @author JJI
 * 
 */
public class SockMerchant {

	public static void main(String[] args) {
		int n = 9;
		int [] ary = {10 ,20 ,20, 10, 10, 30, 50, 10, 20};
		int [] ary1 = {1 ,1, 3, 1, 2, 1, 3, 3, 3, 3};
		
		
		System.out.println(sockMerchant (n,ary1));
		
	}
	
	  // Complete the sockMerchant function below.
    public static int sockMerchant(int n, int[] ar) {
        if(n < 1 && n > 100){
            throw new RuntimeException("value is not valid");
        }
        Arrays.sort(ar);
        int pairCnt = 0;
        int i = 0;
        int curSocksCnt = 1;
        
        for(i = 0 ; i < n-1 ; i ++){
        	if(ar[i] == ar[i+1]){
        		curSocksCnt++;
        	}else{
        		pairCnt += curSocksCnt/2;
        		curSocksCnt = 1;
        	}
        }
        pairCnt += curSocksCnt/2;
        
        return pairCnt;

    }

}

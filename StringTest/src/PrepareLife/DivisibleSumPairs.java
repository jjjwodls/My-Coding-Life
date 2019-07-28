package PrepareLife;
/**
 * 
 * You are given an array of  integers, , and a positive integer, . Find and print the number of  pairs where  and  +  is divisible by .

For example,  and . Our three pairs meeting the criteria are  and .

Function Description

Complete the divisibleSumPairs function in the editor below. It should return the integer count of pairs meeting the criteria.

divisibleSumPairs has the following parameter(s):

n: the integer length of array 
ar: an array of integers
k: the integer to divide the pair sum by
Input Format

The first line contains  space-separated integers,  and . 
The second line contains  space-separated integers describing the values of .

Constraints

Output Format

Print the number of  pairs where  and  +  is evenly divisible by .

Sample Input

6 3
1 3 2 6 1 2

Sample Output

 5
 *
 */
public class DivisibleSumPairs {

	public static void main(String[] args) {
		int[] ar = new int[6];
		ar[0] = 1;
		ar[1] = 3 ;
		ar[2] = 2 ;
		ar[3] = 6 ;
		ar[4] = 1 ;
		ar[5] = 2 ;
		int temp = 0;
		int total =0;
		for(int i = 0 ; i < ar.length; i++) {
			for(int j = i+1 ; j < ar.length ; j++) {
				temp = ar[i] + ar[j];
				if(temp%3 == 0) {
					total++;
				}
			}
		}
		System.out.println(total);
		//3으로 나눠지는지
		
		
		
		
		
	}

}

package studyAlgorithm;

public class BubbleSort {

	public static void main(String[] args) {
		int[] ary = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		int temp = 0;
		int aryLen = ary.length-1;
		while(aryLen > 0) {
			for(int i = 0 ; i < aryLen ; i++) {
				if(ary[i] > ary[i+1]) {
					temp = ary[i];
					ary[i] = ary[i+1];
					ary[i+1] = temp;
				}
			}
			aryLen--;
		}
		
		for(int rst : ary) {
			System.out.println(rst);
		}
		
		for(int i = 0 ; i < aryLen ; i++) {
			for(int j = 0 ; j < aryLen-i ; j++) {
				if(ary[j] > ary[j+1]) {
					temp = ary[j];
					ary[j] = ary[j+1];
					ary[j+1] = temp;
				}
			}
		}
		
	}

}

package studyAlgorithm;

public class InsertSort {

	public static void main(String[] args) {
		int [] ary = {1,10,5,6,7,4,2,3,8,9};
		int temp = 0;
		int aryLen = ary.length;
		int j = 0;
		for(int i = 0 ; i < aryLen-1 ; i++) {
			j = i;
			while(ary[j] > ary[j+1]) {
				temp = ary[j];
				ary[j] = ary[j+1];
				ary[j+1] = temp;
				j--;
			}
		}
		
		for(int rst : ary)
			System.out.println(rst);
		
	}
	
}

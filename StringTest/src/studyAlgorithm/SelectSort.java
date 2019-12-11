package studyAlgorithm;

public class SelectSort {

	public static void main(String[] args) {
		
		int [] ary = {1,10,5,6,7,4,2,3,8,9};
		int min = 0;
		int temp = 0;
		int idx = 0;

		for(int i = 0 ; i < ary.length ; i++) {
			min = ary[i];//최소값은 우선 첫번째부터 선택하면서 진행.
			//min = Integer.MAX_VALUE;
			for(int j = i ; j < ary.length; j++) {
				if(min >= ary[j]) { 		//현재 min보다 크거나 같은 놈을 기준으로 선택함.
					idx = j;
					min = ary[j];
				}
			}
			temp = ary[i];
			ary[i] = ary[idx];
			ary[idx] = temp;
		}
		
		for(int rst : ary) {
			System.out.println(rst);
		}
	}

}

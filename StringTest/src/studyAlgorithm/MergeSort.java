package studyAlgorithm;

public class MergeSort {

	private int aryLen = 8;
	private int[] sorted = new int[8];
	
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		
		int[] ary = {7,6,5,8,3,5,9,1};
		mergeSort.mergeSort(ary, 0, ary.length-1);
		for(int rst : ary) {
			System.out.println(rst);
		}
		
	}
	
	public void merge(int []a , int m , int middle , int n) {
		
		int i = m;
		int j = middle+1;
		int k = m; // 배열에 넣기 위한 시작 값.
		
		while(i <= middle && j <= n) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			}else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}
		
		if(i > middle) {
			for(int t = j; t <= n ; t++) {
				sorted[k] = a[t];
				k++;
			}
		}else {
			for(int t = i; t <= middle ; t++) {
				sorted[k] = a[t];
				k++;
			}
		}
		
		for(int t = m ; t <= n ; t++) {
			a[t] = sorted[t];
		}
	}
	
	public void mergeSort(int a[] , int m , int n) {
		//크기가 1보다 큰 경우
		if(m < n) {
			int middle = (m+n) / 2;
			mergeSort(a , m , middle);
			mergeSort(a , middle+1 , n);
			merge(a, m , middle , n);
		}
	}
}

package sortAlgorithm;

public class QuickSort {
	
	
	public static void quickSort(int low, int high, int [] ary) {
		if(low>= high) return;
		
		int pivot = pivot(low,high,ary);
		pivot(low,pivot-1,ary);
		pivot(pivot,high,ary);
	}
	
	public static void main(String[] args) {
		
		int[] ary = {5,3,8,4,9,1,6,2,7};
		quickSort(0,ary.length-1,ary);
	
		for(int i = 0 ; i < ary.length; i++) {
			System.out.println(ary[i]);
		}
	}
	
	public static int pivot(int low,int high,int []ary) {
		
		int pivot = ary[(low + high)/2];
		
		int temp = 0;

		while(low<high) {
			
			while(ary[low] < pivot) {
				low++;
			}
			
			while(ary[high] > pivot) {
				high--;
			}
			
			temp = ary[low];
			ary[low] = ary[high];
			ary[high] = temp;
			
		}
		
		
		return low;
	}
}

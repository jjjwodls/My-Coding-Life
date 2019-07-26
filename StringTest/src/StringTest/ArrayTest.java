package StringTest;

public class ArrayTest {
	
	public static int count = 1;
	
	public static void main(String[] args) {
		int[] temp = {11,4,2,3,1,5};
		//System.out.println(temp.length/2);
		int left = 0;
		int right = temp.length - 1;
		
		quickSort(temp,left,right);
		
		for(int i = 0 ; i < temp.length ; i++){
			//System.out.println(temp[i]);
		}
		
		
	}
	
	public static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];
		int temp = 0;
		System.out.println(count + " 회차 결과");
		while (left < right) {
			while ((arr[left] < pivot) && (left < right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;

			if (left < right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		for(int i = 0 ; i < arr.length ; i ++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		count++;

		return left;
	}

	public static void quickSort(int arr[], int left, int right) {

		if (left < right) {
			int pivotNewIndex = partition(arr, left, right);
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
			
		}

	}
	
	/*public static void quickSort(int[] ary , int left, int right){
		
		int pivotPoint =left;
		int pivot = ary[pivotPoint];
		int temp1 = -1;
		
		int low = left;
		int high = right;
		
		while(low<high){
			
			while(high >= left && ary[high] > pivot  ){
				high --;
			}
		
			while(low <= right && ary[low] < pivot){
				low ++;
			}
			
			temp1 = ary[high];
			ary[high] = ary[low];
			ary[low] = temp1;
			
		}
	
		temp1=ary[high];
		ary[high] = ary[left]; 
		ary[left] = temp1;
		pivotPoint = high;
		
		if(low < pivotPoint){
			quickSort(ary,left,pivotPoint-1);
		}
		if(pivotPoint > high){
			quickSort(ary,pivotPoint+1,right);
		}
		
	}*/

}

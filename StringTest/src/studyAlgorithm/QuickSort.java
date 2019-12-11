package studyAlgorithm;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int [] ary = {3,7,8,1,5,9,6,10,2,4};
		quickSort.quickSort(ary, 0, ary.length-1);
		
		for(int rst : ary) {
			System.out.print(rst + " ");
		}
		System.out.println();
		int [] ary2 = {3,7,8,1,5,9,6,10,2,4};
		quickSort.quickSort2(ary2, 0, ary.length-1);
		
		for(int rst : ary2) {
			System.out.print(rst + " ");
		}
		
	}
	
	//오름차순
	public void quickSort(int [] ary , int start , int end) {
		if(start >= end) { // 원소가 1개인경우
			return;
		}
		int pivot = start;
		int i = start + 1;
		int j = end;
		
		int temp = 0;
		while(i <= j) { //엇갈릴때 까지 반복함.
			
			while(i <= end && ary[i] <= ary[pivot]) { // 이 부분에서 값 찾는부분만 변경하면 내림차순 가능.
				i++;
			}
			
			while(ary[j] >= ary[pivot] && j > start) {
				j--;
			}
			
			if(i > j) { // 엇갈린 상태면 키값과 교체
				temp = ary[j];
				ary[j] = ary[pivot];
				ary[pivot] = temp;
			}else {
				temp = ary[i];
				ary[i] = ary[j];
				ary[j] = temp;
			}
		}
		
		quickSort(ary,start,j-1);
		quickSort(ary,j+1,end);
		
	} 
	
	//내림차순 정렬.
	public void quickSort2(int [] ary , int start , int end) {
		if(start >= end) { // 원소가 1개인경우
			return;
		}
		int pivot = start;
		int i = start + 1;
		int j = end;
		
		int temp = 0;
		while(i <= j) { //엇갈릴때 까지 반복함.
			
			while(i <= end && ary[i] >= ary[pivot]) {
				i++;
			}
			
			while(ary[j] <= ary[pivot] && j > start) {
				j--;
			}
			
			if(i > j) { // 엇갈린 상태면 키값과 교체
				temp = ary[j];
				ary[j] = ary[pivot];
				ary[pivot] = temp;
			}else {
				temp = ary[i];
				ary[i] = ary[j];
				ary[j] = temp;
			}
		}
		
		quickSort2(ary,start,j-1);
		quickSort2(ary,j+1,end);
		
	} 

}

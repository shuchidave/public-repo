package searchingSorting;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] initArr = new int[]{1,4,2,5,3,6,7,0,9};
		int[] sorted = new MergeSort().mergeSort(initArr, 0, initArr.length-1);
		for(int i=0;i<sorted.length;i++){
			System.out.println("Sorted:"+sorted[i]);
		}
	}
	
	public void mergeSort(int[] arr, int left, int right){
		if(left<right){
		int mid = (left+right)/2;
		mergeSort(arr, left, mid);
		mergeSort(arr,mid+1, right);
		merge(arr, left, mid, right);
		}
	}
	
	public void merge(int[] arr, int left, int mid, int right){
		
		// find sizes of two subarray to be merged
		int leftSize = mid-left+1;
		int rightSize=right-mid;

		// create two temporary subarrays of right sizes
		int[] L = new int[leftSize];
		int[] R = new int[rightSize];
		
		// Copy the elements
		for(int i=0;i<leftSize;i++){
			L[i]=arr[left+i];
		}
		for(int j=0;j<rightSize;j++){
			R[j]=arr[mid+1+j];
		}
		
		int i=0, j=0;
		int k=left;
		while(){
			
		}
	}

}

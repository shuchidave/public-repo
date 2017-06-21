package searchingSorting;
/*
//Java implementation of iterative Binary Search
*/

public class BinarySearchItr {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,12,14,16,18,20};
		System.out.println("Length: "+arr.length);
		int res = binarySearchItr(arr, 0,arr.length-1, 16);
		System.out.println("Result Index: "+res);
	}
	
	public static int binarySearchItr(int[] arr, int l, int r, int k){
		
		while(l<=r){
			int m=l+(r-l)/2;
			System.out.println("Mid:"+m);
			if(k==arr[m]){return m;}
			else if(k<m){r=m-1;}
			else{l=m+1;}
		}
		return -1;
		
	}

/*

	public int binarySearch(int[] arr, int s){
		int l=0, r=arr.length-1;
		while(l<=r){
			int mid = l + (r-l) / 2;
			if(arr[mid]==s)
				return mid;
			if(arr[mid]<s){
				l=mid+1;
			}
			else{
				r=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		BinarySearchItr bs=new BinarySearchItr();
		int[] arr = {10,11,12,14,18,20,25,28,35,38,40,41,42};
		int s = 14;
		int result = bs.binarySearch(arr, s);
		if(result==-1){
			System.out.println("Element not found");
		}else{
			System.out.println("Elemnt is found at: "+result);
		}
	}
*/
}

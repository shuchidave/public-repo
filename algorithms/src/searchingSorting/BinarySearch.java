package searchingSorting;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		int[] arr = {10,11,12,14,18,20,25,28,35,38,40,41,42,44,45,46,48,50};
		int s = 44;
		int result = bs.binarySearch(arr, s);
		if(result==-1){
			System.out.println("Element not found");
		}else{
			System.out.println("Elemnt is found at: "+result);
		}
	}
	
	public int binarySearch(int[] arr, int s){
		int result = -1;
		int l=0, r=arr.length-1; // l=0, r=3
		while(l<=r){ // yes
			int m = l + (r-l)/2; // m=1
			if(arr[m]==s) return m; //
			if(arr[m]>s) r= m-1;
			else l=m+1;
		}
		return result;
	}
}

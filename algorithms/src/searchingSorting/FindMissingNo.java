package searchingSorting;

public class FindMissingNo {
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,4,6,8,7,9};
		System.out.println(findMissing(arr));
	}
	
	public static int findMissing(int[] arr){
		int sum = ((arr.length+1)*(arr.length+2))/2;
		System.out.println("initial sum:"+sum);
		for(int i=0;i<arr.length;i++){
			sum-=arr[i];
		}
		return sum;
	}

}

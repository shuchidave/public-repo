package algorithms;

public class LongestIncreasingSubSeq {
	public static void main(String[] args) {
		int[] arr={3,4,-1,0,6,2,3};
		System.out.println(longestIncreasingSubSeq(arr));
	}

	public static int longestIncreasingSubSeq(int[] arr){
		if(arr.length<=0){
			return Integer.MIN_VALUE;
		}
		if(arr.length==1){
			return 1;
		}
		int[] tmp = new int[arr.length];
		for(int k=0;k<tmp.length;k++){
			tmp[k]=1;
		}
		
		for(int i=0;i<arr.length;i++){
			int j=0;
			while(j<i){
				if(arr[i]>arr[j]){
					tmp[i]=Math.max(tmp[i], tmp[j]+1);
				}
				j++;
			}
		}
		int longest=1;
		for(int t=0;t<tmp.length;t++){
			longest=Math.max(longest, tmp[t]);
		}
		return longest;
	}
}

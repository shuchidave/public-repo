package algorithms;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubseq {
public static void main(String[] args) {
int[] arr={1,3,2,4,8,7,9,4,10};
System.out.println("Length:"+findLongestConsecutiveSubseq(arr));
}

public static int findLongestConsecutiveSubseq(int[] arr){
	int res = 0;
	Set<Integer> s = new HashSet<Integer>();
	for(int i=0;i<arr.length;i++){
		s.add(arr[i]);
	}
	System.out.println("Set:"+s);
	for(int i=0;i<arr.length;i++){
		System.out.println("i:"+i);
		// This element is start of a new subsequence
		if(!s.contains(arr[i]-1)){
			System.out.println("This element is start of a new subsequence:"+arr[i]);
			int j=arr[i];
			System.out.println("j:"+arr[i]);
			while(s.contains(j)){
				j++;
				System.out.println("j:"+j);
			}
			// Highest element value in subsequence- starting element value in subsequence
			int d=j-arr[i];
			System.out.println("j-arr[i]:"+d);
			if(res<d){
				res=d;
				System.out.println("Updating result to:"+res);
			}
		}
	}
	return res;
}


}

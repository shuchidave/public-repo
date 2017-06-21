package algorithms;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElement {
public static void main(String[] args) {
	int[] arr = {1,2,3,4,2,3,2,3,5,2,2,2,2,8,2};
	findMajorityElement(arr);
}

public static void findMajorityElement(int[] arr){
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for(int i=0;i<arr.length;i++){
		if(map.containsKey(arr[i])){
			int count = map.get(arr[i])+1;
			if(count>arr.length/2)
			{
				System.out.println("Found majority element:"+arr[i]);
				return;
			}else{
				map.put(arr[i],count);
			}
		}else{
			map.put(arr[i], 1);
		}
	}
	System.out.println("Majority element Not found");
	
}
}

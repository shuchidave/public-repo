package searchingSorting;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
public static void main(String[] args) {
	List<String> perms = generatePermutations("abc");
	for (String string : perms) {
		System.out.println(string);
	}
}
private static List<String> generatePermutations(String str) {
	ArrayList<String> result = new ArrayList<String>();
	int len= str.length();
	if(len==0){
		result.add("");
		return result;
	}
	
	for(int i=0;i<len;i++){
		List<String> partials = new ArrayList<String>();
		//remove char i , generate permutations for rest of the string
		String before = str.substring(0,i);
		String after = str.substring(i+1,len);
		partials = generatePermutations(before+after);
		
		
		//append character i at the beginning of all partial permutations
		for (String part : partials) {
			result.add(str.charAt(i)+part);
		}
		
	}
	return result;
}

}

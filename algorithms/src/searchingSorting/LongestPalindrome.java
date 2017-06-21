package searchingSorting;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
public static void main(String[] args) {
	System.out.println("Max palindrome size:"+findLargestPalindromeSize("cbancana"));
}

public static int findLargestPalindromeSize(String str){
	Set<Character> s= new HashSet<Character>();
	int count=0;
	for(int i=0;i<str.length();i++){
		if(s.contains(str.charAt(i))){
			s.remove(str.charAt(i));
			count++;
		}else{
			s.add(str.charAt(i));
		}
	}
	if(s.size()>0){
		return count*2+1;
	}else{
		return count*2;
	}
}

}

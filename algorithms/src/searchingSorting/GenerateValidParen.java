package searchingSorting;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParen {
	
	/**
	 * 
	 * 1. Add left parenthesis, if there are left parenthesis remaining - and recurse
	 * 
	 * 2. If there are more right parenthesis remaining than left, i.e. there are more left parenthesis in use than
	 * right parenthesis in use, add right parenthesis - and recurse
	 * 
	 * n=3 => 
	 * 
	 * 			    	(
	 * 			  	/	  \
	 * 		 	(( 			 ()
	 * 		/  		\			\
	 * 	(((    	   (() 				()(
	 *	 |        / 	\			|	\
	 *	((()	(()(  	(())	()((	()()
	 *    |		|		  |			|	|			
	 *	((())	(()()	(())(	()(()	()()(
	 *	  |		|		  |			|	|
	 *	((()))	(()())	(())()	()(())	()()()
	 *		1	  2		  3	     4		  5	
	 * @param args
	 */
public static void main(String[] args) {
	int n=3;
	char[] str = new char[n*2]; 
	List<String> list = new ArrayList<String>();
	generateValidParen(list, n,n,str,0);
	for (String string : list) {
		System.out.println(string);
	}
}

public static void generateValidParen(List list, int leftParen, int rightParen, char[] str, int index){
	if(leftParen<0 || rightParen<leftParen){
		return;
	}
	if(str.length==index){
		list.add(String.copyValueOf(str));
	}
	else{
		str[index]='(';
		generateValidParen(list, leftParen-1, rightParen, str, index+1);
		str[index]=')';
		generateValidParen(list, leftParen, rightParen-1, str,index+1);
	}
}
}

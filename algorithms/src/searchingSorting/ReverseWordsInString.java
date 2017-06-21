package searchingSorting;

public class ReverseWordsInString {
	public static void main(String[] args) {
		System.out.println(reverseWords("Hello world"));
	}
	public static String reverseWords(String str){
		StringBuffer sb = new StringBuffer();
		char[] c = str.toCharArray();
		int i=0,j=c.length-1;
		while(i<c.length && j>=i){
			swapChars(i,j, c);
			
			i++;
			j--;
		}
		sb.append(c);
		//for(int i=0;i<sb.length();i++){
			//sb.reverse();
		//}
		
		String[] arr = sb.toString().split(" ");
		sb = new StringBuffer();
		for(String s: arr){
			char[] chArr = s.toCharArray();
			for(i=0,j=chArr.length-1;i<chArr.length && j>=i;i++,j--){
				swapChars(i,j,chArr);
			}
			sb.append(String.copyValueOf(chArr)+" ");
		}
			return sb.substring(0,sb.length()-1);
	}
	
	public static void swapChars(int i, int j, char[] c){
		
		char t = c[i];
		c[i]=c[j];
		c[j]=t;
		
	}

}

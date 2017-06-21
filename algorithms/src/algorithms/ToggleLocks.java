package algorithms;

public class ToggleLocks {
	
	public static void main(String[] args) {
		int n= 36;
		if(n>0){
			boolean[] isClosed = new boolean[n];
			if(n==1){
				System.out.println("Open locks:"+n);
			}else{
				for(int i=1;i<=n;i++){
					for(int j=2;i*j<n;j++){
						//System.out.println("Before:"+j*i+"::"+isOpen[j*i]);
						isClosed[j*i]=!isClosed[j*i];
						//System.out.println("After:"+j*i+"::"+isOpen[j*i]);
					}
				}
				int count=0;
				for(int k=1;k<=n;k++){
					int x =k-1;
					if(!isClosed[x]){
						System.out.println("Open lock:"+x);
						count++;
					}
					
				}
				System.out.println("Open lock total:"+count);
			}
		}
	}

}

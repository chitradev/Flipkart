package TestCases;

import java.util.Arrays;

public class javatest {

	public static void main(String[] args) {

	//largest number in array
		
	int [] p= {98,556,342,90,12,45};	
	
	for(int i=0;i<p.length;i++) {
		
	for(int j=i+1;j<p.length;j++) {
		
		if(p[i]<p[j]) {
		
		int temp=p[i];
		p[i]=p[j];
		System.out.println(p[i]);
		p[j]=temp;	
		System.out.println(temp);
				
		}
	}	
		
	}
	
	System.out.println(Arrays.toString(p));
	
	System.out.println(p[p.length-1]);
	
	
	//String reversal
	/*String n="Chitra", rev="";
	char[] a=n.toCharArray();
	for(int i=a.length-1;i>=0;i--) {
	
		rev+=a[i];
		
	}
	//System.out.println(rev);
	
	//half pyramid
	
	for(int i=1;i<=10;++i) {
		
	for(int j=1;j<=i;++j)	{
		
		System.out.print("A"+" ");
	}
	System.out.println("");
	}
	
	int[]jj= {1,2,3,4,5,6,7,8,9,10};
	
	
	for(int i=0;i<jj.length;i++) {
		
		if(jj[i]%2!=0) {
			
			System.out.println(jj[i]);
		}
	}*/
	
	
}
}

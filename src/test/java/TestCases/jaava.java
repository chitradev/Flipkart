package TestCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class jaava {

	public static void main(String[] args) {
		// Largest number in a given array
		
		/*int [] a= {78,89,56,144,67};
		int largest=a[0];
		for(int i=0;i<a.length;i++) {
			
			if(a[i]>largest) {
				
			 largest=a[i];
			}

		}
		System.out.println(largest);
	
		//remove duplicates from an array
	int [] b= {7,9,3,9,2,9,7,8,5};
	HashSet<Integer> set= new HashSet<Integer>();
	for(int i=0;i<b.length;i++) {
		
	set.add(b[i]);	
	}
	System.out.println(set);
	
	//reverse order
	List<Integer> li= new ArrayList<Integer>();
	li.add(15);
	li.add(78);
	li.add(90);
	li.add(99);
	li.add(15);
	Collections.sort(li, Collections.reverseOrder());
	System.out.println(li);*/
	
		//half Pyramid
	/*for(int i=1;i<=10;++i) {
	
		for(int j=1;j<=i;++j) {
		
			System.out.print(j+" ");
		
		}
		System.out.println("");
	}
/*s="Madam";
String b="";

char[] a=s.toCharArray();
for(int i=a.length-1;i>=0;i--) {
b=b+a[i];	
}
if(b.equalsIgnoreCase(s)) {
System.out.println("Given string "+b +" is palindrome");
}else {
		System.out.println("not palindrome");
	}*/

/*
String sen="I Love India", ss="";
String[] l=sen.split(" ");
//System.out.println(l.length);
//System.out.print(l[2]+" ");
//System.out.print(l[1]+" ");
//System.out.print(l[0]);

for(int i=l.length-1;i>=0;i--)
{
	
	char[] arr=l[i].toCharArray();
	//System.out.println(arr);
	int r=0;
	for(int j=arr.length-1;j>=0;j--) {		
		
		ss=ss+arr[j]+" ";
		
	}
	
	
}
//System.out.println(ss);	



String s="INDIA";
int le = s.length();
StringBuffer sb= new StringBuffer();
Set<Character> se= new LinkedHashSet<Character>();
for (int i = 0; i < le; i++) 
{
    char c = s.charAt(i);	
    se.add(c);
    
    
    
}
for(Character c: se) {
	sb.append(c);
}
//System.out.println(sb);

	
	//1 (1+2),3 (2+3),5
	int e=0,f=1,n3;
	for(int i=0;i<20;i++) {
		
		n3=e+f;
		//System.out.print(e+" ");
		e=f;
		f=n3;
		
	}

	
	
	String t=" I am good", rev = "";
	String[] nw=t.split(" ");
	for(int q=nw.length-1;q>0;q--) {
		
	 rev+=nw[q]+" ";	
	}
	//System.out.print(rev);*/

	/*
	String cha= "Knuckle Duster";
	char[] arr=cha.toCharArray();
	//int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};   
    
    System.out.println("Duplicate elements in given array: ");  
    //Searches for duplicate element  
    for(int i = 0; i < arr.length; i++) {  
        for(int j = i + 1; j < arr.length; j++) {  
            if(arr[i] == arr[j])  
                System.out.println(arr[j]);  
        }  
    }  
}  */
	
	
	/*String s="welcome to india welcome to australia welcome to england";
	String[] words=s.split(" ");
	Map<String,Integer>map= new HashMap<String,Integer>();
	for(String allWords:words) 
	{
		if (map.containsKey(allWords)) 
		{
		    Integer integer = map.get(allWords);
		    map.put(allWords, integer+1);
		}
		else 
		{
			map.put(allWords, 1);
		}
	}
	System.out.println(map);
	Set<Entry<String, Integer>> entrySet = map.entrySet();
	for (Entry<String, Integer> entry : entrySet) 
	{
	     if (entry.getValue()>1) 
	    {
			System.out.println(entry);
		}	
	}*/
		
		int[] a={45,89,90,67,77,125};
        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]<a[j])
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        //System.out.println("Second largest number"+" "+a[a.length-2]);
        System.out.println(Arrays.toString(a));
        System.out.println("Second largest number"+" "+a[a.length-2]);
    }
}
	




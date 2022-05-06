/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
		    int n=sc.nextInt();
		    int[] arr=new int[n];
		    //int[] arr=new int[];
		    for(int i=0;i<n;i++){
		        int key=sc.nextInt();
		        arr[i]=key;
		        if(tm.containsKey(key)){
		            tm.put(key,tm.get(key)+1);
		        }else{
		            tm.put(key,1);
		        }
		    }
		    int maxv=tm.lastKey();
		    int no=0,co=0,y=0,x=0,cv=0,c=Integer.MIN_VALUE;
		    Arrays.sort(arr);
		    reverse(arr);
		    
		    for(int i=0;i<n-1;i++){
		        
		        if(arr[i]==arr[i+1] && no==0){
		            co++;
		        }else if(arr[i]!=arr[i+1]){
		            no++;
		            y=0;
		            if(y>=co){
		                cv=x;
		            }
		        }else if(arr[i]==arr[i+1]){
		            x=arr[i];
		            y++;
		        }
		        c=Math.max(y,c);
		    }
		    maxv=maxv+co;
		    c=c+cv;
		    int ans=Math.max(maxv,c);
		    System.out.println(ans);
		    //if(ts.contains(ts.last()+1))
		    //System.out.println(tm.get(tm.lastKey()));
		    /*if(tm.get(tm.lastKey())==1 && ){
		        System.out.println(tm.lastKey());
		    }
		    if(tm.get(tm.lastKey())>1){
		        System.out.println(tm.lastKey()+1);
		    }else{
		        System.out.println(tm.lastKey());
		    }*/
		    
		    /*Integer[] Geeks=ts.toArray(new Integer[ts.size()]);
		    if(ts.size()==1)
		        System.out.println(ts.first());
		        
		    if(ts.contains(ts.last()-1) && ts.size()>1)
		        System.out.println(ts.last());
		    else{
		        if(ts.size()-2!=0){
    		        for(int i=ts.size()-2;i>0;i--){
    		            if(ts.contains(Geeks[i]-1)){
    		                System.out.println(Geeks[i]);
    		                break;
    		            }
    		        }
		        }else{
		            System.out.println(ts.first());
		        }
		    }*/
		    
		    
		    
		}
	}
	
	public static void reverse(int[] array)
    {
  
        // Length of the array
        int n = array.length;
  
        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
  
            // Storing the first half elements temporarily
            int temp = array[i];
  
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
  
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}

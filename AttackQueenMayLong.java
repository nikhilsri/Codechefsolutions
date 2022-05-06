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
		    
		    int n=sc.nextInt();
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    
		    int tr1=n-x+x-1+n-y+y-1;
		    int ul=Math.min(x-1,y-1);
		    int ur=Math.min(x-1,n-y);
		    int dl=Math.min(n-x,y-1);
		    int dr=Math.min(n-x,n-y);
		    
		    System.out.println(tr1+ul+ur+dr+dl);
		    
		}
	}
}

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
		    
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    int c=sc.nextInt();
		    
		    PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(
                Collections.reverseOrder());
            
            pQueue.add(a);
            pQueue.add(b);
            pQueue.add(c);
            int sum=0;
            Iterator itr = pQueue.iterator();
            int i=2;
            while (i-->0){
                sum=sum+pQueue.poll();
            }
		    System.out.println(sum);
		}
	}
}

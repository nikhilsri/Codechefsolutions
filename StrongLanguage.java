/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0){
		    int n=sc.nextInt();
		    int k=sc.nextInt();sc.nextLine();
		    String str=sc.nextLine();
		    int count=findMaxConsecutiveOnes(str);
		    if(count>=k){
		        System.out.println("YES");
		    }else{
		        System.out.println("NO");
		    }
		    
		}
	}
	public static int findMaxConsecutiveOnes(String nums) {
        int count=1;
        int max=Integer.MIN_VALUE;
        boolean found = nums.contains("*");
        
        if(nums.length()==0){
            return 0;
        }
        
        if(nums.length()==1 || !found){
            if(nums.charAt(0)!='*'){
                    return 0;
            }
        }
            for(int i=0;i<nums.length();i++){
                if(i==nums.length()-1){
                    break;
                }

                if(nums.charAt(i)=='*' && nums.charAt(i+1)=='*'){
                    count++;
                }else{
                    max=Math.max(max,count);
                    count=1;
                }
            }
        
        //System.out.println(count+" "+max);
        return Math.max(max,count);
    }
}

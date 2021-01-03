import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;
import java.lang.*;


// Remember that the class name should be "Main" and should be "public".
public class Main {
    static char[] ar={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
    
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		int t = in.nextInt();
		
		
		while(t-- >0){
		    StringBuilder sb1 = new StringBuilder(""); 
		    int n = in.nextInt();
		    String str=in.next();
		    for(int i=0;i<n;i=i+4){
		        sb1=sb1.append(search(str.substring(i,i+4)));
		    }
		    System.out.println(sb1.toString());
		}
		
	}
	static String search(String str){
	   // System.out.print(str +" ");
	   	int s=15;
	    int firstIndex=0,lastIndex=0;
	    String ans="";
	    for(int i=0;i<4;i++){
	        
	        if(i==0){
    	        if(str.charAt(i)=='0'){
    	            //System.out.print("ZERO");
    	            lastIndex=s-8;
    	            s=s-8;
    	            if(lastIndex < 8){
    	                firstIndex=0;
    	            }
    	        }else{
    	            //System.out.print("ONE");
    	            firstIndex=8;
    	            lastIndex=s;
    	            
    	        }
	        }
	        if(i==1){
	            if(str.charAt(i)=='0'){
    	            //System.out.print("ZERO");
    	            firstIndex=0;
    	            s=s-4;
    	            lastIndex=s;
    	        }else{
    	            //System.out.print("ONE");
    	            firstIndex=s-3;
    	            lastIndex=s;
    	        }
	        }
	        if(i==2){
	            if(str.charAt(i)=='0'){
    	            //System.out.print("ZERO");
    	            firstIndex=0;
    	            s=s-2;
    	            lastIndex=s;
    	        }else{
    	            //System.out.print("ONE");
    	            firstIndex=s-1;
    	            lastIndex=s;
    	        }
	        }
	        if(i==3){
	            if(str.charAt(i)=='0'){
    	            //System.out.print("ZERO");
    	            firstIndex=0;
    	            s=s-1;
    	            lastIndex=s;
    	        }else{
    	            //System.out.print("ONE");
    	            firstIndex=s;
    	            lastIndex=s;
    	        }
	        }
	    }
	   // System.out.println("firstIndex = "+firstIndex+" lastIndex = "+lastIndex);
	    if(firstIndex==lastIndex){
	        ans = String.valueOf(ar[firstIndex]);
	    }else{
	        ans = String.valueOf(ar[lastIndex]);
	    }
	    return ans;
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}

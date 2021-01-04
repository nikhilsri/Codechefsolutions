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
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		int t = in.nextInt();
		while(t-- > 0){
		    int n = in.nextInt();
		    int m= in.nextInt();
		    int count=0;
		    int johnSum=0;
            int jackSum =0;
		    
		    ArrayList<Integer> johnList=new ArrayList<Integer>();
		    ArrayList<Integer> jackList=new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        johnList.add(in.nextInt());
		        johnSum+=johnList.get(i);
		    }
		    for(int j=0;j<m;j++){
		        jackList.add(in.nextInt());
		        jackSum+=jackList.get(j);
		    }
		    if(johnSum>jackSum){
	           System.out.println(0);
	           continue;
	        }
		    Collections.sort(johnList);
		    Collections.sort(jackList); 
		    int j=m-1;
		    for(int i=0;i<n;i++){
	           johnSum=johnSum-johnList.get(i);
	           jackSum=jackSum-jackList.get(j);
	           johnSum=johnSum+jackList.get(j);
	           jackSum=jackSum+johnList.get(i);
	           count++;
	           j--;
	           if(johnSum>jackSum || j<0){
	               break;
	           }
	       }
		        if(johnSum > jackSum)
		            System.out.println(count);
		        else
		            System.out.println(-1);
		}
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

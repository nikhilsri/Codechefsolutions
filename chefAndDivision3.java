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
		    int k= in.nextInt();
		    int d= in.nextInt();
		    int ans=0;
		    List<Integer> list=new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        list.add(in.nextInt());
		    }
		    int sum = list.stream().mapToInt(Integer::intValue).sum();
		    if(k<=sum){
		        ans=sum/k;
		    }
		    if(ans > d){
		        System.out.println(d);
		    }else{
		        System.out.println(ans);
		    }
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

import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new int[m];
	    per(0,1);
	    
		System.out.println(sb);
	}
	
	private static void per(int depth, int idx) {
	    if(depth==m) {
	        for(int a:arr) {
	            sb.append(a).append(' ');
	        }
	        sb.append('\n');
	        return;
	    }
	    
	    for(int i=idx;i<=n;i++) {
	        arr[depth]=i;
	        per(depth+1,i);
	    }
	}
}
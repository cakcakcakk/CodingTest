import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    visited=new boolean[n];
	    arr=new int[m];
	    
	    per(0);
	    System.out.print(sb);

	}
	
	private static void per(int depth) {
	    if (depth==m) {
    	    for(int val:arr) {
    	        sb.append(val+" ");
    	    }
    	    sb.append("\n");
    	    return;
	    }
	    	   
	    for(int i=0;i<n;i++) {
	        if(!visited[i]) {
    	        visited[i]=true;
    	        arr[depth]=i+1;
    	        per(depth+1);
    	        visited[i]=false;	            
	        }
	    }
	}
	
}
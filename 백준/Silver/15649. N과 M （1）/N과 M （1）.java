import java.util.*;
import java.io.*;

public class Main
{   
    static int n,m;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    boolean[] visited=new boolean[n+1];
	    int[] arr=new int[n+1];
	    
	    permutation(0,visited,arr);	    
	}
	
	private static void permutation(int depth,boolean[] visited,int[] arr) {
	    if (depth==m) {
	       print(arr); 
	    }
	    	   
	    for(int i=1;i<=n;i++) {
	        if(!visited[i]) {
    	        visited[i]=true;
    	        arr[depth]=i;
    	        permutation(depth+1,visited, arr);
    	        visited[i]=false;	            
	        }
	    }
	}
	
	private static void print(int[] arr) {
	    for(int i=0;i<m;i++) {
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}	
}
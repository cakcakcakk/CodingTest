import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    n=Integer.parseInt(br.readLine());
	    
	    int[] arr=new int[n+1];
	    boolean[] visited=new boolean[n+1];

	    dfs(arr, visited,0);

	}
	
	static private void dfs(int[] arr, boolean[] visited, int depth) {
	    
	    if(depth==n) {
	        print(arr);
	    }
	    
	    
	    for(int j=1; j<=n;j++){  
	        if(!visited[j]) {
	            visited[j]=true;
	            arr[depth]=j;
	            dfs(arr,visited,depth+1);
	            visited[j]=false;
	        }
	    }
	    
	}
	
	static private void print(int[] arr){
	    for(int i=0;i<n;i++){
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}
}
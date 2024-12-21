import java.io.*;
import java.util.*;

public class Main
{
    static int n,k,cnt;
    static int now=500;
    static int[] arr;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n];
	    visited=new boolean[n];
	    
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	        arr[i]=Integer.parseInt(st.nextToken())-k;
	    }
	    dfs(0);
	    
		System.out.println(cnt);
	}
	
	private static void dfs(int depth) {
	    if(depth==n) {
	        cnt++;
	        return;
	    }
	    
	    for(int i=0;i<n;i++) {
	        if(!visited[i] && now+arr[i]>=500 ) {
	            visited[i]=true;
	            now+=arr[i];
	            dfs(depth+1);
	            visited[i]=false;
	            now-=arr[i];
	            
	        }
	    }
	    
	}
}
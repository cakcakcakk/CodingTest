import java.util.*;
import java.io.*;

public class Main
{
    static int n,m;
    static int[] arr,result;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n];
	    visited=new boolean[n];
	    result=new int[m];
	    
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	        arr[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    dfs(0,0);
	    
		System.out.println(sb);
	}
	
	private static void dfs(int depth, int idx) {
	    if(depth==m) {
	        for(int a:result) {
	            sb.append(a).append(' ');
	        }
	        sb.append('\n');
	        return;
	    }
	    
	    int before=0;
	    for(int i=idx;i<n;i++) {
	        if(!visited[i]) {
	            if(before!=arr[i]) {
	                before=arr[i];
	                visited[i]=true;
	                result[depth]=arr[i];
	                dfs(depth+1,i+1);
	                visited[i]=false;
	            }
	            
	        }
	    }
	}
}
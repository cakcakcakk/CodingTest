import java.io.*;
import java.util.*;

public class Main   
{   
    static boolean[] visited;
    static long[] order,depth;
    static List<Integer>[] list;
    static long t=1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    int r=Integer.parseInt(st.nextToken());
	    
	    list=new ArrayList[n+1];
	    order=new long[n+1];
	    depth=new long[n+1];
	    visited=new boolean[n+1];
	    
	    for(int i=1;i<=n;i++) list[i]=new ArrayList<>();
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        
	        list[u].add(v);
	        list[v].add(u);
	    }
	    
	    for(int i=1;i<=n;i++) Collections.sort(list[i],Collections.reverseOrder());
	    Arrays.fill(depth,-1);
	    
        visited[r]=true;
        depth[r]=0;
        order[r]=t++;
        
	    dfs(r);
	    
	    t=0;
	    for(int i=1;i<=n;i++) {
	        t+=order[i]*depth[i];
	    }	    
	    System.out.println(t);
	}
	
	private static void dfs(int a) {
	    
	    for(int i:list[a]) {
	        if(visited[i]) continue;
	        
	        visited[i]=true;
	        depth[i]=depth[a]+1;
	        order[i]=t++;
	        dfs(i);
	    }
	} 
}
import java.io.*;
import java.util.*;
public class Main
{   static boolean[] visited;
    static ArrayList<Integer>[] l;
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    st=new StringTokenizer(br.readLine());
	    int N=Integer.parseInt(st.nextToken());
	    int M=Integer.parseInt(st.nextToken());
	    int V=Integer.parseInt(st.nextToken());
	    
	    visited=new boolean[N+1];
	    l=new ArrayList[N+1];

	    for(int i=0;i<=N;i++) l[i]=new ArrayList<>();
	    
	    for(int i=0;i<M;i++) {
	        st=new StringTokenizer(br.readLine());
	        int x=Integer.parseInt(st.nextToken());
	        int y=Integer.parseInt(st.nextToken());
	        
	        l[x].add(y); l[y].add(x);
	    }
	    for(int i=0;i<=N;i++) Collections.sort(l[i]);
	    
	    dfs(V);
	    System.out.println();
	    Arrays.fill(visited,false);
	    bfs(V);
	    
		
	}
	private static void bfs(int v){
	    Queue<Integer> q=new LinkedList<>();
	    q.offer(v);
	    visited[v]=true;
	    System.out.print(v+" ");
	    
	    while(!q.isEmpty()){
	        int a=q.poll();
	        
	        for(int i=0;i<l[a].size();i++){
	            int adj=l[a].get(i);
	            if(!visited[adj]) {
	                visited[adj]=true;
	                System.out.print(adj+" ");
	                q.offer(adj);}
	        }
	    }
	}
	private static void dfs(int v){
	    System.out.print(v+" ");
	    visited[v]=true;
	    for(int a:l[v]) {
	        if(!visited[a]) {
	            
	            dfs(a);
	        }
	    }
	}
}

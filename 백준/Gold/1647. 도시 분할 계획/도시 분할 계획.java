import java.io.*;
import java.util.*;

public class Main
{  
    static int[] parent;
    static int count, maxEdge;
    static List<Edge>[] graph;
    static boolean[] visited;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());;
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    parent=new int[n+1];
	    graph=new ArrayList[n+1];
	    visited=new boolean[n+1];
	    
	    for(int i=0;i<=n;i++) graph[i]=new ArrayList<>();
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        int w=Integer.parseInt(st.nextToken());

	        graph[u].add(new Edge(v,w));   
	        graph[v].add(new Edge(u,w));
	    }
	    
	    prim(1);
   
	    System.out.println(count-maxEdge);	

	}

	private static void prim(int start) {
	    PriorityQueue<Edge> pq=new PriorityQueue<>();
	    
	    pq.add(new Edge(start,0));
	        
	    while(!pq.isEmpty()) {
	        Edge now=pq.poll();
	        
	        if(visited[now.v]) continue;
	        
	        visited[now.v]=true;  // 최소 간선이니까 MST에 넣기
	        
	        count+=now.w;
            if(maxEdge<now.w) maxEdge=now.w;
	        
	        for(Edge next:graph[now.v]) {
	            if(!visited[next.v]) {  // 이미 방문한 애는 최소 간선이었기에 굳이 넣을 필요 없음
	                pq.add(next);
	            }
	        }	        
	    }
        return;
	}

}

class Edge implements Comparable<Edge> {
    int v;
    int w;

    Edge(int v,int w) {
        this.v=v;
        this.w=w;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w,o.w);
    }
}

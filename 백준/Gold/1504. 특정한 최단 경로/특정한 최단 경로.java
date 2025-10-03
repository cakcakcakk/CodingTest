import java.io.*;
import java.util.*;

public class Main
{
    static List<Node>[] list;
    static int n;
    static final int INF=3*(int)1e8;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		
		list=new List[n+1];
		for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<e;i++) {
		    st=new StringTokenizer(br.readLine());
	        int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
		  	int c=Integer.parseInt(st.nextToken());
  
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
		}
		
		st=new StringTokenizer(br.readLine());
		int v1=Integer.parseInt(st.nextToken());
		int v2=Integer.parseInt(st.nextToken());
		
		int re1=0;
		re1+=dajikstra(1,v1);
		re1+=dajikstra(v1,v2);
		re1+=dajikstra(v2,n);
		
		int re2=0;
		re2+=dajikstra(1,v2);
		re2+=dajikstra(v2,v1);
		re2+=dajikstra(v1,n);
		
		// 한 번이라도 무한대가 나왔다면
		// INF를 3번 더해도 int 범위 안임 - 를 만족하는 INF 설정
		int result=(re1>=INF && re2>=INF?-1:Math.min(re1,re2));
		
		System.out.println(result);
	}
	private static int dajikstra(int start, int end) {
	    PriorityQueue<Node> pq=new PriorityQueue<>();
	    int[] dist=new int[n+1];
	    // 한 번 가능한 최단 경로: n-1 * 가중치( 799 * 1000) < 3*1e8
	    Arrays.fill(dist,INF);  
	    dist[start]=0;
	    
	    
	    boolean[] visited=new boolean[n+1];
	    
	    
	    pq.add(new Node(start,0));
	    
	    while(!pq.isEmpty()) {
	        Node cur=pq.poll();
	        if(dist[cur.dest]<cur.cost) continue;
	        
	        if(visited[cur.dest]) continue;
	        visited[cur.dest]=true;
	        
	        for(Node next:list[cur.dest]) {
	            // cur.cost 해도 되나?
	            if(dist[cur.dest]+next.cost<dist[next.dest]) {
	                dist[next.dest]=dist[cur.dest]+next.cost;  
	                pq.add(new Node(next.dest,dist[next.dest]));
	           }
	        }
	        
	    }
	    return dist[end];
	}
}
class Node implements Comparable<Node> {
    int dest, cost;
    
    Node(int dest, int cost) {
        this.dest=dest;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost,o.cost);
    }
}
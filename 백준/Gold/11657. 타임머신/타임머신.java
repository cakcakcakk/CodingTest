import java.util.*;
import java.io.*;

public class Main
{
	static List<Edge> list=new ArrayList<>();
    static int n;
    static final long INF=(int)1e8;
    static long[] dist;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    StringBuilder sb=new StringBuilder();
	    
	    
	    n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        
	        int a=Integer.parseInt(st.nextToken());
	        int b=Integer.parseInt(st.nextToken());
	        int c=Integer.parseInt(st.nextToken());
	        
	        list.add(new Edge(a,b,c));
	        
	    }
	    if(bellman_ford(1)) {
	        sb.append(-1).append("\n");
	    }
	    else {
	        for(int i=2;i<=n;i++) {
	            sb.append(dist[i]==INF?-1:dist[i]).append("\n");
	        }
	        
	    }
		System.out.println(sb);
	}
	
	private static boolean bellman_ford(int start) {
	    boolean cycle=false;
	    
	    dist=new long[n+1];
	    Arrays.fill(dist,INF);
	    dist[start]=0;
	    
	    for(int i=1;i<n;i++) { // 왜 n-1 인지 이해하기
	        for(Edge cur:list) {
	            // 무한대면 넘기기
	            if(dist[cur.s]==INF) continue;
	            // i를 거쳐서 e로 가는 게 더 작다면
                if(dist[cur.s]+cur.cost < dist[cur.e]) {
                    dist[cur.e]=dist[cur.s]+cur.cost;
                }
	            
	        }
	    }    
        // 음수 사이클 확인
        for(Edge cur:list) {
            if(dist[cur.s]==INF) continue;
            if(dist[cur.s]+cur.cost < dist[cur.e]) {
                cycle=true;
            }
        }
	    return cycle;
	}
}
class Edge {
    int s,e,cost;
    Edge(int s, int e, int cost) {
        this.s=s;
        this.e=e;
        this.cost=cost;
    }
}
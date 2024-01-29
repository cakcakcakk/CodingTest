import java.util.*;
import java.io.*;

public class Main
{   
    static int V,E,K;
    static int[] dist;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static List<Node>[] list;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    V=Integer.parseInt(st.nextToken());
	    E=Integer.parseInt(st.nextToken());
	    
	    K=Integer.parseInt(br.readLine());
	    
	    dist=new int[V+1];
	    Arrays.fill(dist,Integer.MAX_VALUE);
	    
	    list=new ArrayList[V+1];
	    for(int i=0;i<=V;i++) list[i]=new ArrayList<>();
	    
	    for(int i=0;i<E;i++){
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        int w=Integer.parseInt(st.nextToken());
	        list[u].add(new Node(v,w));
	    }
	    
	    dijkstra(K);
	    
	    for(int i=1;i<=V;i++){
	        if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
	        else System.out.println(dist[i]);
	    }
		
	}
	
	private static void dijkstra(int k){
	    dist[k]=0;
	    pq.offer(new Node(k,0));
	   
	    
	    while(!pq.isEmpty()){
	        Node now=pq.poll();
	        
	        if(now.w>dist[now.v]) continue;
	        
	        for(Node next:list[now.v]) {
	            if(dist[next.v]>dist[now.v]+next.w) {
	                dist[next.v]=dist[now.v]+next.w;
	                pq.offer(new Node(next.v,dist[next.v]));
	                
	            }
	        }
	    }
	}
}

class Node implements Comparable<Node>{
    public int v,w;
    
    public Node(int v,int w){
        this.v=v;
        this.w=w;
    }
    
    @Override
    public int compareTo(Node o){
        return this.w-o.w;
    }
    
}

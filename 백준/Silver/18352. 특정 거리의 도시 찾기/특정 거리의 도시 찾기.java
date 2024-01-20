import java.io.*;
import java.util.*;

public class Main
{   
    static boolean cnt;
    static int[] dist;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> q=new LinkedList<>();
    static final int INF=Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int N=Integer.parseInt(st.nextToken());
	    int M=Integer.parseInt(st.nextToken());
	    int K=Integer.parseInt(st.nextToken());
	    int X=Integer.parseInt(st.nextToken());
	    
	    dist=new int[N+1];
	    Arrays.fill(dist,INF);
	    
	    arr=new ArrayList[N+1];
	    for(int i=0;i<=N;i++) arr[i]=new ArrayList<>();
	    	    
	    for(int i=0;i<M;i++) {
	        st=new StringTokenizer(br.readLine());
	        int a=Integer.parseInt(st.nextToken());
	        int b=Integer.parseInt(st.nextToken());
	        arr[a].add(b);
	    }
	    dijkstra(X);
	    
	    for(int i=1;i<=N;i++) {
	        if(dist[i]==K) {
	            System.out.println(i);
	            cnt=true;
	        }
	    }
	    
	    if(!cnt) System.out.println(-1); 		
	}
	
	private static void dijkstra(int x){
	    dist[x]=0;
	    q.offer(x);
	    
	    while(!q.isEmpty()){
	        int now=q.poll();
	        
	        for(int i=0;i<arr[now].size();i++){
	            int next=arr[now].get(i);
	            if(dist[next]> dist[now]+1) {
	                dist[next]=dist[now]+1;
	                q.offer(next);
	            }
	        }
	    }
	}
}

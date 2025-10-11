import java.util.*;
import java.io.*;

public class Main
{
    static int n;
    static int[] dist;
    static final int INF=(int)1e9;
    static List<Train> list=new ArrayList<>();

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        int s=Integer.parseInt(st.nextToken());
	        int e=Integer.parseInt(st.nextToken());
	        String dir=st.nextToken();
	        int c=Integer.parseInt(st.nextToken());
	        
	        if(dir.equals("b")) {
	            list.add(new Train(s,e,c));
	        }
	        else {
	            list.add(new Train(s,e,(-1)*c));
	        }
	    }

	    dist=new int[n+1];
	    Arrays.fill(dist,INF);
	    
	    bellman_ford();
	    
	    for(int i=2;i<=n;i++) {
	        if(dist[i]<0) System.out.println(i);
	    }

	}
	private static void bellman_ford() {
	    dist[1]=0;
	    
	    for(int i=1;i<n;i++) {
	        for(Train cur:list) {
	            if(dist[cur.s]==INF) continue;
    	        if(dist[cur.e] > dist[cur.s]+cur.cost) {
    	            dist[cur.e] = dist[cur.s]+cur.cost;
 
    	        }	            
	        }

	    }
	    return;
	} 
}

class Train {
    int s,e;
    int cost;
    
    Train(int s, int e, int cost) {
        this.s=s; this.e=e; this.cost=cost;
    }
}
import java.io.*;
import java.util.*;
public class Main
{   static int[] parent;
    static ArrayList<Integer>[] l;
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int N=Integer.parseInt(br.readLine());
	    parent=new int[N+1];
	    l=new ArrayList[N+1];

	    for(int i=0;i<=N;i++) l[i]=new ArrayList<>();
	    
	    for(int i=0;i<N-1;i++) {
	        st=new StringTokenizer(br.readLine());
	        int x=Integer.parseInt(st.nextToken());
	        int y=Integer.parseInt(st.nextToken());
	        
	        l[x].add(y); l[y].add(x);
	    }
	    for(int i=0;i<=N;i++) Collections.sort(l[i]);
	    
	    bfs(1);
	    
	    for(int i=2;i<=N;i++) {System.out.println(parent[i]);}
	    
	}
	private static void bfs(int r){
	    Queue<Integer> q=new LinkedList<>();
	    q.offer(r);
	    
	    while(!q.isEmpty()){
	        int a=q.poll();
	        
	        for(int i=0;i<l[a].size();i++){
	            int adj=l[a].get(i);
	            if(parent[adj]==0) {parent[adj]=a; q.offer(adj);}
	        }
	    }
	}
}

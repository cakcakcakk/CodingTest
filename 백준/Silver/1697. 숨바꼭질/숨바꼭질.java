import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {

	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int k=Integer.parseInt(st.nextToken());
	    
		System.out.println(bfs(n,k));
		
	}
	
	private static int bfs(int n, int k) {
	    Queue<Integer> q=new LinkedList<>();
	    int[] visited=new int[100001];
	    
	    q.add(n);
	    visited[n]=1;
	    
	    while(!q.isEmpty()) {
	        int now=q.poll();
	        
	        if(now==k) {
	            return visited[now]-1;
	        }
	        
	        for(int i=0;i<3;i++) {
	            int next;
	            
	            if(i==0 && now!=0) {
	                next=now*2;
	            }
	            else if (i==1) {
	                next=now+1;
	            }
	            else {
	                next=now-1; 
	            }
	            
	            if(next>=0 && next<=100000 && visited[next]==0) {
	                visited[next]=visited[now]+1;
	                q.add(next);

	            }
	        }

	    }
	    
	    return 1;
	}
}
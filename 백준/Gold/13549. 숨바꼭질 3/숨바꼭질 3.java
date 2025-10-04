import java.util.*;
import java.io.*;

public class Main
{
    static int n,k;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    
	    boolean[] visited=new boolean[100001];
        Queue<Node> q=new LinkedList<>();
        
        visited[k]=true;
        q.add(new Node(k,0));
        
        int result=0;
        int max=100000;
        
	    while(!q.isEmpty()) {
	        Node cur=q.poll();
	        if(cur.val==n) {
	            result=cur.cnt;
	            break;
	        }
	        // 똑같은 수는 안 들어오게 하는 법
            
	        if(cur.val%2==0 && !visited[cur.val/2]) {
	            visited[cur.val/2]=true;
	            q.add(new Node(cur.val/2,cur.cnt));
	        }
	        // +1
	        if(cur.val+1<=max && !visited[cur.val+1]) {
	            visited[cur.val+1]=true;
	            q.add(new Node(cur.val+1,cur.cnt+1));
	        }
	        
	        // -1 
	        if(cur.val-1>=0 && !visited[cur.val-1]) {
	            visited[cur.val-1]=true;
	            q.add(new Node(cur.val-1,cur.cnt+1));
	        }
	    }
        System.out.println(result);
	}

}
class Node {
    int val,cnt;
    Node(int val, int cnt) {
        this.val=val;
        this.cnt=cnt;
    }
}
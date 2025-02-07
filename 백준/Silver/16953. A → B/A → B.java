import java.util.*;
import java.io.*;

public class Main
{   
    static Queue<Long> q=new LinkedList<>();
    static long a,b;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    a=Long.parseLong(st.nextToken());
	    b=Long.parseLong(st.nextToken());
	    
	    System.out.println(bfs());
	}
	
    private static int bfs() {
        q.add(a);
        int cnt=1;

	    while(!q.isEmpty()) {
	        int size=q.size();   // 변수 정의 안하고 밑에 for문에서 q.size()하면 대참사남
	        for(int i=0;i<size;i++) {
	            long val=q.poll();

    	        if(val==b) {
    	            return cnt;
    	        }	       
    	        
    	        if(val*2<=b) {   	           
	                q.add(val*2);
	            }
	        
    	        if(val*10+1<=b) {
    	            q.add(val*10 +1);
    	        }   	        
	        }
	        cnt++;
	    } 
	    return -1;
    }
}
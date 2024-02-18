import java.io.*;
import java.util.*;

public class Main
{
    static int[][] a;
    static int N;
    static Queue<int[]> q=new LinkedList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N=Integer.parseInt(br.readLine());
	    a=new int[N+1][N+1];
	    
	    for(int i=1;i<=N;i++){
	        st=new StringTokenizer(br.readLine());
	        for(int j=1;j<=N;j++){
	            a[i][j]=Integer.parseInt(st.nextToken());
	            if(a[i][j]==1) q.offer(new int[]{i,j});
	        }
	    }
	    
	    bfs();
	    
	    for(int i=1;i<=N;i++){
	        for(int j=1;j<=N;j++){
	            System.out.print(a[i][j]+" ");
	        }
	        System.out.println();
	    }
		
	}
	
	private static void bfs(){
        
        while(!q.isEmpty()){
            int[] now=q.poll();
            
            int i=now[0];
            int k=now[1];
            
            for(int j=1;j<=N;j++){
                if(a[i][j]==0 && a[k][j]==1) {
                    a[i][j]=1;
                    q.offer(new int[]{i,j});
                }
            }
        }
	    
	}
}

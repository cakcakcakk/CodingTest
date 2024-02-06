import java.util.*;
import java.io.*;

public class Main
{   static int N,M,cnt,max;
    static int zero;
    static int[][] a;
    static int[][] b;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

	public static void main(String[] args) throws IOException {
	    
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		a=new int[N][M];
		b=new int[N][M];
		
		for(int i=0;i<N;i++){
		    st=new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        a[i][j]=Integer.parseInt(st.nextToken());
		        b[i][j]=a[i][j];
		        if(a[i][j]==0) zero++;
		    }
		}	        
		dfs(0);		
        System.out.println(max);
	}
	
	private static void dfs(int w){
	    if(w==3) {
	        bfs();
	        return;
	    }
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(a[i][j]==0) {
	                
	                a[i][j]=1;
	                dfs(w+1);
	                a[i][j]=0;
	            }
	        }
	    }
	}
	
	private static void bfs(){
	    Queue<int[]> q=new LinkedList<>();
	    cnt=zero-3;
	      
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            b[i][j]=a[i][j];

	            if(b[i][j]==2) {
	                q.offer(new int[]{i,j});
	            }	            
	        }	       
	    }
	    
	    while(!q.isEmpty()){
	        int[] now=q.poll();
	        for(int i=0;i<4;i++){
	            int nx=now[0]+dx[i];
	            int ny=now[1]+dy[i];
	            
	            if(nx>-1&&nx<N&&ny>-1&&ny<M&&b[nx][ny]==0) {
	                b[nx][ny]=2;
	                cnt--;
	                q.offer(new int[]{nx,ny});
	            }
	        }
	    }

	    max=Math.max(cnt,max);	    
	}	
}

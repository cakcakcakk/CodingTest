import java.io.*;
import java.util.*;

public class Main
{
    static int N,M,K;
    static int cnt,max;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static Queue<int[]> q=new LinkedList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    
	    a=new int[N+1][M+1];
	    visited=new boolean[N+1][M+1];
	    
	    for(int i=0;i<K;i++){
	        st=new StringTokenizer(br.readLine());
	        int r=Integer.parseInt(st.nextToken());
	        int c=Integer.parseInt(st.nextToken());
	        a[r][c]=1;
	        
	    }
	    
	    for(int i=1;i<=N;i++){
	        for(int j=1;j<=M;j++){
	            if(a[i][j]==1&&!visited[i][j]) {
	                cnt=0;
	                dfs(i,j);
	                max=Math.max(max,cnt);
	            }
	            
	        }
	    }
	    
		System.out.println(max);
	}
	
	private static void dfs(int x, int y){
	    cnt++;
	    visited[x][y]=true;
	        
        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx<1||nx>N||ny<1||ny>M) continue;
            if(a[nx][ny]==1&&!visited[nx][ny]) {
                dfs(nx,ny);
            }
        }
	        
	    
	}
}

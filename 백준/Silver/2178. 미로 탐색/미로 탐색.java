import java.util.*;
import java.io.*;

public class Main
{   
    static int N,M,cnt;
    static int[][] visited;
    static int[][] a;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    
	    a=new int[N][M];
	    visited=new int[N][M];
	    
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<M;j++){
                a[i][j]=str.charAt(j)-'0';
            }
        }
        
		bfs(0,0);
		System.out.println(visited[N-1][M-1]);
	}
	
	private static void bfs(int r, int c){
	    Queue<int[]> q=new LinkedList<>();
	    
	    visited[r][c]=1;
        q.offer(new int[]{r,c});
        	    
	    while(!q.isEmpty()){
            int[] now=q.poll();
            int x=now[0];
            int y=now[1];
            if(x==N-1&&y==M-1) return;
            
            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>-1&&nx<N&&ny>-1&&ny<M&&a[nx][ny]==1&&visited[nx][ny]==0) {
                    visited[nx][ny]=visited[x][y]+1;
                    q.offer(new int[]{nx,ny});
                }
            }
	    }
	    	   
	}
}

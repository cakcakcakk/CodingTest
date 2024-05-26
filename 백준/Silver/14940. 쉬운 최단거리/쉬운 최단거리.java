import java.io.*;
import java.util.*;

public class Main
{
    static int n,m;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] dist;
    static boolean[][] visited;
    static int x,y;
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		visited=new boolean[n+1][m+1];
		dist=new int[n+1][m+1];;
		
		for(int i=1;i<=n;i++){
		    st=new StringTokenizer(br.readLine());
		    
		    for(int j=1;j<=m;j++){
		        dist[i][j]=Integer.parseInt(st.nextToken());
                if(dist[i][j]==2) {
                     x=i;
                     y=j;
		        }
		        else if (dist[i][j]==1) dist[i][j]=-1;
		    }
		    
		}
		
		bfs(x,y);
		
		StringBuilder sb=new StringBuilder();

		for(int i=1;i<=n;i++){
		    for(int j=1;j<=m;j++){
		  
		        sb.append(dist[i][j]+" ");
		    }
		    sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static void bfs(int x, int y){
	    
	    Queue<int[]> q=new LinkedList<>();
	    dist[x][y]=0;
	    q.offer(new int[]{x,y});
	    visited[x][y]=true;
	    
	    while(!q.isEmpty()){
	        int[] now=q.poll();
	        	        
	        for(int i=0;i<4;i++){
	            int nx=now[0]+dx[i];
	            int ny=now[1]+dy[i];
	            
	            if(nx<1||nx>n||ny<1||ny>m) continue;
	            if(!visited[nx][ny] && dist[nx][ny]==-1) {
	                dist[nx][ny]=dist[now[0]][now[1]]+1;
	                q.offer(new int[]{nx,ny});
	                visited[nx][ny]=true;
	            }	            
	            
	        }
	        	        
	    }
	    
	}
	
}

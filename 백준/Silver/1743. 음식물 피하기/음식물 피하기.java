import java.io.*;
import java.util.*;

public class Main
{   
    static int max,cnt;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,m,k;
    static int[][] list;
    static boolean[][] visited;

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    
	    visited=new boolean[n+1][m+1];
	    list=new int[n+1][m+1];
	    
	    for(int i=0;i<k;i++){
	        st=new StringTokenizer(br.readLine());
	        int x=Integer.parseInt(st.nextToken());
	        int y=Integer.parseInt(st.nextToken());
	        
	        list[x][y]=1; 
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=m;j++) {
	            if(list[i][j]==1 && !visited[i][j]) {
	                cnt=1;
	                bfs(i,j);
	                max=Math.max(max,cnt);
	            } 
	        }
	    }        
        System.out.println(max);	    
	}
	
	private static void bfs(int r,int c){
	    Queue<int[]> q=new LinkedList<>();
	    
	    q.add(new int[]{r,c});
	    visited[r][c]=true;
	    
	    while(!q.isEmpty()) {
	        int[] now=q.poll();
	        int x=now[0];
	        int y=now[1];
	        
	        for(int i=0;i<4;i++) {
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            
	            if(nx<1||nx>n||ny<1||ny>m) continue;
	           
	            if(list[nx][ny]==1&&!visited[nx][ny]) { // visited확인문 있어야힘!!
	                list[nx][ny]=++cnt;
	                visited[nx][ny]=true;
	                q.add(new int[]{nx,ny});
	            }
	        }
	    }
	}
}
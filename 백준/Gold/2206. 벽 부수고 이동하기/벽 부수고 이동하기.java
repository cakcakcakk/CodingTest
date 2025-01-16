import java.io.*;
import java.util.*;

public class Main
{
    static int n,m;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n][m];
	    visited=new boolean[n][m][2];
	    
	    for(int i=0;i<n;i++) {
	        String str=br.readLine();
	        for(int j=0;j<m;j++){
	            arr[i][j]=str.charAt(j)-'0';
	        }
	    }	    
		System.out.println(bfs());
	}
	
	private static int bfs(){
	    Queue<Point> q=new ArrayDeque<>();
	    q.add(new Point(0,0,1,false));
	    
	    while(!q.isEmpty()) {
	        Point now=q.poll();
	        int x=now.x;
	        int y=now.y;
	        
	        if(x==n-1 && y==m-1) {
	            return now.cnt;
	        }
	        
	        for(int i=0;i<4;i++) {
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            
	            if(nx<0||nx>=n||ny<0||ny>=m) continue;

	            if(arr[nx][ny]==0) { // 벽이 아니면 그냥 가자
	                if(now.wall && !visited[nx][ny][1]) {  // 벽 부신적 있으면
	                    visited[nx][ny][1]=true;
	                    q.add(new Point(nx,ny,now.cnt+1,true));
	                }
	                else if(!(now.wall) && !visited[nx][ny][0]){
	                    visited[nx][ny][0]=true;
	                    q.add(new Point(nx,ny,now.cnt+1,false));
	                }
	            }
	            
	            else { // 벽인 경우
	                if(!(now.wall)) { // 벽 부순 적 없을 때만
	                    visited[nx][ny][1]=true;
	                    q.add(new Point(nx,ny,now.cnt+1,true));
	                }
	            }
	        }
	    }
	    
	    return -1;
	}
	
	static class Point{
	    int x;
	    int y;
	    int cnt;
	    boolean wall; // 벽 부쉈으면 true, 안 부쉈으면 true
	    
	    public Point(int x, int y, int cnt, boolean wall){
	        this.x=x; this.y=y; this.cnt=cnt; this.wall=wall;
	    }
	}
}
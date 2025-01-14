import java.io.*;
import java.util.*;

public class Main
{   
    static int max,zero;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n,m;
    static int[][] list;
    static boolean[][] visited;
    static boolean ripe=true;
    static Queue<int[]> q=new LinkedList<>();

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    m=Integer.parseInt(st.nextToken());
	    n=Integer.parseInt(st.nextToken());
	    
	    visited=new boolean[n][m];
	    list=new int[n][m];
	    
	    for(int i=0;i<n;i++){
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<m;j++) {
	            list[i][j]=Integer.parseInt(st.nextToken());
	            
	            if(list[i][j]==0) {
	                zero++;  // 새로 익어야 할 토마토 개수
	                ripe=false;
	            }	            
	            // 익은 애들은 이미 다 있어야 한다!
	            if(list[i][j]==1) {
	                q.add(new int[]{i,j});
	            }
	        }
	    }
	    
	    if(ripe) {
	        System.out.println(0); // 이미 모두 익은 경우
	        return;
	    }
	    
	    bfs();
	}
	
	private static void bfs(){
	    int tomato=0;

	    while(!q.isEmpty()) {
	        int[] now=q.poll();
	        int x=now[0];
	        int y=now[1];
	        
	        for(int i=0;i<4;i++) {
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            
	            if(nx<0||nx>=n||ny<0||ny>=m) continue;
	           
	            if(list[nx][ny]==0) { 
	                list[nx][ny]=list[x][y]+1;
	                tomato++;
	                q.add(new int[]{nx,ny});
	            }
	        }
	        max=Math.max(max,list[x][y]);
	    }
	    System.out.println(tomato==zero?max-1:-1);
	}
}
import java.io.*;
import java.util.*;

public class Main
{
    static int M,N,K,cnt;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static List<Integer> l=new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    StringBuilder sb=new StringBuilder();
	    
	    M=Integer.parseInt(st.nextToken());
	    N=Integer.parseInt(st.nextToken());
	    K=Integer.parseInt(st.nextToken());
	    
	    a=new int[N][M];
	    visited=new boolean[N][M];
	    
	    for(int i=0;i<K;i++){
    	    st=new StringTokenizer(br.readLine());
    	    int x1=Integer.parseInt(st.nextToken());
    	    int y1=Integer.parseInt(st.nextToken());
    	    int x2=Integer.parseInt(st.nextToken());
    	    int y2=Integer.parseInt(st.nextToken());
    	    
    	    square(x1,y1,x2-1,y2-1);      
	    }

	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(!visited[i][j]&&a[i][j]==0) {
	                cnt=0;
	                dfs(i,j);
	                l.add(cnt);	                
	            }
	        }
	    }
	    Collections.sort(l);
	    
	    
	    sb.append(l.size()).append("\n");
	    for(int s:l) sb.append(s).append(" ");
	    
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y){
	    visited[x][y]=true;
	    cnt++;
	    
	    for(int i=0;i<4;i++){
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        
	        if(nx<0||nx>=N||ny<0||ny>=M) continue;
	        if(!visited[nx][ny]&&a[nx][ny]==0) {
	            dfs(nx,ny);
	        }
	    }
	}
	
	private static void square(int x1,int y1, int x2, int y2){
	    for(int i=x1;i<=x2;i++){
	        for(int j=y1;j<=y2;j++){
	            a[i][j]=1;
	        }
	    }
	} 
}

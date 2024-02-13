import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] a;
    static boolean[][] visited;
    static int N,max,cnt;
    static Set<Integer> s=new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N=Integer.parseInt(br.readLine());
	    
	    a=new int[N][N];
	    visited=new boolean[N][N];
	    
	    for(int i=0;i<N;i++){
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<N;j++){
	            a[i][j]=Integer.parseInt(st.nextToken());
	            if(s.contains(a[i][j])) continue;
	            s.add(a[i][j]);
	        }
	    }
	    	    
        if(s.size()==1) {System.out.println(1); return;}
        
        List<Integer>l=new ArrayList<>(s);
        
        for(int height:l){
            cnt=0;
            visited=new boolean[N][N];
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(a[i][j]>height&&!visited[i][j]) {
                        dfs(i,j,height);
                        cnt++;
                    }
                }
            }
            max=Math.max(max,cnt);
        }
	    
	    System.out.println(max);
		
	}
	
	private static void dfs(int r, int c, int h) {
        visited[r][c]=true;
        
        for(int i=0;i<4;i++){
            int nx=r+dx[i];
            int ny=c+dy[i];
            
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(a[nx][ny]>h&&!visited[nx][ny]) {
                dfs(nx,ny,h);
            }
        }
        
	}
}

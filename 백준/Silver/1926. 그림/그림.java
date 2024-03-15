import java.io.*;
import java.util.*;
public class Main
{
    static int n,m,cnt;
    static boolean one;
    static int[][] a;
    static boolean[][] visited;
    static List<Integer>list=new ArrayList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    a=new int[n][m];
	    visited=new boolean[n][m];
	    
	    for(int i=0;i<n;i++){
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<m;j++){
	            a[i][j]=Integer.parseInt(st.nextToken());
	            if(a[i][j]==1) one=true;
	        }
	    }
	    
	    if(!one) {
	        System.out.println(cnt);
	        System.out.println(0);
	        return;
	    }
	    
	    for(int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(a[i][j]==1&&!visited[i][j]) {
	                cnt=0;
	                dfs(i,j);
	                list.add(cnt);
	            }
	        }
	    }
	    
	    Collections.sort(list);
	    System.out.println(list.size());
	    System.out.println(list.get(list.size()-1));		
	}
	private static void dfs(int x, int y){
	    visited[x][y]=true;
	    cnt++;
	    
	    for(int i=0;i<4;i++){
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        
	        if(nx<0||nx>=n||ny<0||ny>=m) continue;
	        if(a[nx][ny]==1&&!visited[nx][ny]) dfs(nx,ny);
	    }
	} 
}

import java.util.*;
import java.io.*;

public class Main
{
    static int n,m,cnt;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static char[][] arr;
    static boolean[][] visited;
    static List<Integer>[] list=new ArrayList[2];
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new char[m][n];
	    visited=new boolean[m][n];
	    
	    list[0]=new ArrayList<>();  //w에 대한 저장
	    list[1]=new ArrayList<>();  //b에 대한 저장

	    for(int i=0;i<m;i++) {
	        arr[i]=br.readLine().toCharArray();
	    }
	    
	    for(int i=0;i<m;i++) {
	        for(int j=0;j<n;j++) {
	            if(!visited[i][j]) {
	                int idx=1;
	                cnt=1;
	                visited[i][j]=true;
	                dfs(i,j);
	                if(arr[i][j]=='W') {
	                    idx=0;
	                }
	                list[idx].add(cnt);
	            }	            
	        }
	    }
	    
	    for(int i=0;i<2;i++) {
	        int sum=0;
	        for(int a:list[i]) {
	            sum+=(int)Math.pow(a,2);
	        }
	        sb.append(sum).append(' ');
	    }
	    
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y) {
	    
	    for(int i=0;i<4;i++) {
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        
	        if(nx>-1&&nx<m&&ny>-1&&ny<n&&!visited[nx][ny]&&arr[nx][ny]==arr[x][y]) {
	            visited[nx][ny]=true;
	            cnt++;
	            dfs(nx,ny);
	        }
	    }
	}
}
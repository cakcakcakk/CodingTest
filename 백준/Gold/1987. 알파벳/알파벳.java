import java.util.*;
import java.io.*;

public class Main
{
    static int R,C,max,cnt,sel;
    static char[][] a;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    R=Integer.parseInt(st.nextToken());
	    C=Integer.parseInt(st.nextToken());
	    a=new char[R][C];
	    
	    for(int i=0;i<R;i++){
	        StringBuilder sb=new StringBuilder(br.readLine());
	        for(int j=0;j<C;j++){
	            a[i][j]=sb.charAt(j);
	        }
	    }
	    
	    dfs(0,0);	    
		System.out.println(max);
	}
	private static void dfs(int r, int c){
	    sel|= (1<< (a[r][c]-'A'));
	    cnt++;
	    max=Math.max(max,cnt);
	    
	    for(int i=0;i<4;i++){
	        int nx=r+dx[i];
	        int ny=c+dy[i];
	        
    	    if(nx>-1&&nx<R&&ny>-1&&ny<C&& (sel& (1<<(a[nx][ny]-'A')))==0 ) {

    	        dfs(nx,ny);
    	        cnt--;
    	        sel&=~(1<<(a[nx][ny]-'A'));       
    	    }	        
	    }	    
	}

}

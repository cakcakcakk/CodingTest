import java.util.*;
import java.io.*;

public class Main
{   static int N,cnt;
    static int[][] a;

	public static void main(String[] args) throws IOException {
	    
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		a=new int[N][N];
		
		for(int i=0;i<N;i++){
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        a[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		dfs(0,1,0);
		
        System.out.println(cnt);
	}
	
	private static void dfs(int r, int c, int state){

	    if(r==N-1&&c==N-1) {
	        cnt++;
	        return;
	    }
	    
	    if(state==0) {
	        if(c+1<N &&a[r][c+1]==0) {
	            dfs(r,c+1,0);
	        }
	        if (r+1<N&&c+1<N&&a[r][c+1]==0&&a[r+1][c]==0&&a[r+1][c+1]==0) {
	            dfs(r+1,c+1,2);
	        }
	    }
	    else if (state==1) {
	        if(r+1<N&&a[r+1][c]==0) {
	            dfs(r+1,c,1);
	        }
	        
	        if(r+1<N&&c+1<N&&a[r][c+1]==0&&a[r+1][c]==0&&a[r+1][c+1]==0) {
	            dfs(r+1,c+1,2);
	        }
	    }
	    else {
	        if(c+1<N&&a[r][c+1]==0) {
	            dfs(r,c+1,0);
	        }
	        if (r+1<N&&a[r+1][c]==0) {
	            dfs(r+1,c,1);
	        }
	        if (r+1<N&&c+1<N&&a[r][c+1]==0&&a[r+1][c]==0&&a[r+1][c+1]==0) {
	            dfs(r+1,c+1,2);
	        }
	    }
	    
	}
}

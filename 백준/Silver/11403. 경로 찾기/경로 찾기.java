import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int[][] arr;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb=new StringBuilder();
	    
	    n=Integer.parseInt(br.readLine());
	    
	    arr=new int[n][n];
	    
	    for(int i=0;i<n;i++) {
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<n;j++) {
	            arr[i][j]=Integer.parseInt(st.nextToken());
	        } 
	    }
	    
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(arr[i][j]==1) {
	                dfs(i,j);
	            }
	        }
	    }

	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            sb.append(arr[i][j]).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
		
	}
	private static void dfs(int start, int end) {
	    for(int j=0;j<n;j++) {
	        if(arr[end][j]==1 && arr[start][j]==0) {
	            arr[start][j]=1;
	            dfs(start,j);
	        }
	    }
	}
}
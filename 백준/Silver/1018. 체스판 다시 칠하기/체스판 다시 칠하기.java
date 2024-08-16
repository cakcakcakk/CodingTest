import java.io.*;
import java.util.*;

public class Main
{   
    static boolean[][] board;
    static int cnt;
    static int min=64;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    board=new boolean[n][m];
	    
	    for(int i=0;i<n;i++){
	        String s=br.readLine();
	        for(int j=0;j<m;j++) {
	            if(s.charAt(j)=='W') board[i][j]=true;
	            else board[i][j]=false;
	        }
	    }
	    for(int i=0;i<n-7;i++){
	        for(int j=0;j<m-7;j++){
	           find(i,j);
	        }
	    }
	        
		System.out.println(min);
	}
	
	private static void find(int i, int j) {
	    boolean color=board[i][j];
	    int cnt=0;
	    
	    for(int row=i;row<i+8;row++){
	        for(int col=j;col<j+8;col++) {
	            if(color!=board[row][col]) {
	                cnt++;
	            }
	            color=(!color);
	        }
	        color=!color;
	    }
	    
	    cnt=Math.min(cnt,64-cnt);
	    min=Math.min(cnt,min);

	}
}
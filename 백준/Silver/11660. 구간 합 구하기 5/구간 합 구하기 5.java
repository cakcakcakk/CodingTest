import java.io.*;
import java.util.*;

public class Main
{
    static int[][] dp;
    static int n,m;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    StringTokenizer st=new StringTokenizer(br.readLine());	    
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());

	    dp=new int[n+1][n+1];

	    for(int i=1;i<=n;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+Integer.parseInt(st.nextToken());
            }
	    }
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        int x1=Integer.parseInt(st.nextToken());
	        int y1=Integer.parseInt(st.nextToken());
	        int x2=Integer.parseInt(st.nextToken());
	        int y2=Integer.parseInt(st.nextToken());

	        sb.append(dp[x1-1][y1-1]+dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]).append("\n");	        
	    }
	    System.out.print(sb);
	}
}
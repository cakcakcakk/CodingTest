import java.util.*;
import java.io.*;

public class Main
{   
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int t=Integer.parseInt(br.readLine());
	        
	    for(int tc=0;tc<t;tc++){
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        int n=Integer.parseInt(st.nextToken());
	        int m=Integer.parseInt(st.nextToken());
	        
	        int[][] dp=new int[30][30];
	        
	        //함수 시작
	        for(int i=1;i<=m;i++){
    	        dp[i][0]=dp[i][i]=1;
    	        dp[i][1]=i;
    	    }
    	    
    	    for(int i=1;i<=m;i++){
    	        for(int j=1;j<=n&&j<=i;j++){
    	            if(j==1||j==m) continue;
    	            else {
    	                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    	            }
    	        }
    	    }
    	    
    	    sb.append(dp[m][n]+"\n");	        
	    }	    
	    System.out.print(sb);

	}

}
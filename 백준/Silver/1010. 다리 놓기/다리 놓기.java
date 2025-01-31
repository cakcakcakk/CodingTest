import java.io.*;
import java.util.*;

public class Main
{   
    static int[][] dp=new int[31][31];

	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    StringTokenizer st;
	    StringBuilder sb=new StringBuilder();
	    
	    for(int tc=0;tc<t;tc++){
	        
	        st=new StringTokenizer(br.readLine());
	        
	        int a=Integer.parseInt(st.nextToken());
	        int b=Integer.parseInt(st.nextToken());
	        
            sb.append(comb(b,a)).append("\n");        
	    }
        
        System.out.println(sb);
	}
	
	    private static int comb(int n, int r) {
	        if(dp[n][r]>0) return dp[n][r];
	        
	        if(n==r||r==0) return dp[n][r]=1;	            
	        
	        return dp[n][r]=comb(n-1,r-1)+comb(n-1,r);
	    }
}

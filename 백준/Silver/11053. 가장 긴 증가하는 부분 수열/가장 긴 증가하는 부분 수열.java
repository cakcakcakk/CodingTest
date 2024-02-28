import java.io.*;
import java.util.*;

public class Main
{
    static int N,max;
    static int[] dp=new int[1001];
    static int[] seq=new int[1001];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    N=Integer.parseInt(br.readLine());
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    for(int i=1;i<=N;i++){
	        seq[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1;i<=N;i++){
	        
	        dp[i]=1;
	        
	        for(int j=1;j<i;j++){
	            if(seq[i]>seq[j] && dp[i]<dp[j]+1) dp[i]=dp[j]+1;
	        }
	    }
	    	    
        for(int i=1;i<=N;i++){
            max=dp[i]>max ? dp[i]:max; 
        }
	    System.out.println(max);	        
	}	    
}

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	    int n=Integer.parseInt(br.readLine());

	    int[] time=new int[16];
	    int[] pay=new int[16];
	    int[] dp=new int[16];
	    int max=0;
	    
	    for(int i=1;i<=n;i++){
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        
	        time[i]=Integer.parseInt(st.nextToken());
	        pay[i]=Integer.parseInt(st.nextToken());
	    }	    
	    
	    for(int i=1;i<=n;i++) {
	        // i: current day
	        int new_day=i+time[i]-1;
	        dp[i]=Math.max(dp[i-1],dp[i]);
	        
	        // dp[i]를 지금까지의 최댓값으로 해야 함
	        if(new_day>n) continue;
	        dp[new_day]=Math.max(dp[new_day],dp[i-1]+pay[i]);
	        max=Math.max(dp[new_day],max);
	        
	    }
	    System.out.println(max);
		
	}
}
import java.io.*;
import java.util.*;

public class Main
{
    static int[] dp;
    static int[] a;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    
	    dp=new int[n+1];
	    a=new int[n+1];

	    
	    for(int i=1;i<=n;i++){
	        a[i]=Integer.parseInt(br.readLine());
	    }
	    
	    dp[1]=a[1];
	    
	    if(n<3) {
	        int sum=0;
	        for(int i:a) sum+=i;
	        System.out.println(sum);
	        return;
	    }
	    
	    dp[2]=dp[1]+a[2];
	    
	    for(int i=3;i<=n;i++){
	        dp[i]=Math.max(dp[i-2],dp[i-3]+a[i-1])+a[i];
	    }
	    
		System.out.println(dp[n]);
	}
}
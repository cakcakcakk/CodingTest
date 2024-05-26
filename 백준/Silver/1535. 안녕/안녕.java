import java.util.*;
import java.io.*;

public class Main
{
    static int[] power_list=new int[21];
    static int[] happy_list=new int[21];
    static int[][] dp=new int[21][101];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) power_list[i]=Integer.parseInt(st.nextToken());
	    
	    st=new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) happy_list[i]=Integer.parseInt(st.nextToken());
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=100;j++) {
	            //체력 잃고 기쁨 얻음
	            if(j>power_list[i]) {
	                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-power_list[i]]+happy_list[i]);
	            }
	            // 체력 없어서 못함
	            else {
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    
		System.out.println(dp[n][100]);
	}
}

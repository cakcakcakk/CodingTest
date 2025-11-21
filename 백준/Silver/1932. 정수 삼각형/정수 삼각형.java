import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    int n=Integer.parseInt(br.readLine());
	    int[][] arr=new int[n][n];
	    int[][] result=new int[n][n];
	    
	    for(int i=0;i<n;i++) {
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<=i;j++) {
	            arr[i][j]=Integer.parseInt(st.nextToken());
	        }
	    }
	    result[0][0]=arr[0][0];
	    
	    for(int i=1;i<n;i++) {
	        for(int j=0;j<=i;j++) {
	            if(j==0) {
	                result[i][j]=arr[i][j]+result[i-1][j];
	            }
	            else result[i][j]=arr[i][j]+Math.max(result[i-1][j-1],result[i-1][j]);
	        }
	    }
	    int max=0;
	    for(int i=0;i<n;i++) max=Math.max(max,result[n-1][i]);
		System.out.println(max);
	}
}
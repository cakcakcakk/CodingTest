import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    int[] arr=new int[n];
	    int[] inc=new int[n];
	    int[] dec=new int[n];
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
	    
	    int max=0;
	    
	    // inc 정리
	    for(int i=0;i<n;i++) {
	        
	        for(int j=0;j<i;j++) {
	            // 증가하는 부분
	            if(arr[j]<arr[i]) {
	                inc[i]=Math.max(inc[i],inc[j]+1);
	            }
	        }
	        if(inc[i]==0) inc[i]=1;
	    }
	    
	    // dec 정리
	    for(int j=n-1;j>=0;j--) {
            for(int k=n-1;k>j;k--) {
                if(arr[k]<arr[j]) {
                    dec[j]=Math.max(dec[k]+1,dec[j]);
                }
            }
	        if(dec[j]==0) dec[j]=1;
	    }
	    for(int i=0;i<n;i++) {
	        max=Math.max(max,inc[i]+dec[i]);
	    }
		System.out.println(max-1);
	}
}
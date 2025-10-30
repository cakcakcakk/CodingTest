import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    
	    int[] arr=new int[n];
	    
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
	    
	    int s=0,e=0;
	    int count=0,sum=0;
	    
	    while(s<n) {
	        // s는 포함, e는 미포함 [s,e)
	        if (sum>=m) {
	            sum-=arr[s++];
	        }

            else if (sum<m) {
                if(e==n) break;
                sum+=arr[e++];
	        }
	        
	        if(sum==m) {
	            count++;
	        }
	    }
	    
		System.out.println(count);
	}
}
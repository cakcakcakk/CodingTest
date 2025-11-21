import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int[] arr=new int[n];
	    int[] result=new int[n];
	    
	    for(int i=0;i<n;i++) {
	       arr[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    result[0]=1;
	    
	    for(int i=1;i<n;i++) {
	        for(int j=0;j<i;j++) {
                if(arr[j]>arr[i]) {
                    result[i]=Math.max(result[i],result[j]+1);
                }
	        }
	        result[i]=Math.max(1,result[i]);
	    }
	    int max=0;
	    for(int i=0;i<n;i++) max=Math.max(max,result[i]);
		System.out.println(max);
	}
}
import java.util.*;
import java.io.*;

public class Main
{   
    static int cnt=0;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int k=Integer.parseInt(st.nextToken());
	    
	    int[] arr=new int[n];
	    
	    for(int i=0;i<n;i++){
	        arr[i]=Integer.parseInt(br.readLine());
	    }
	    
	    for(int i=n-1;i>-1;i--){
	        if(k>=arr[i]) {
	            cnt+=(k/arr[i]);
	            k%=arr[i];
	        }
	        if(k==0) {
	            break;
	        }
	    }	    
	    	    
		System.out.println(cnt);
	}
}
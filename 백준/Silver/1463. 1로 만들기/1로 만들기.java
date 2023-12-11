import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    int[] arr=new int[1000001];
	    
	    arr[2]=arr[3]=1;
	    
	   for(int i=2;i<=N;i++){
	        
	        if(i+1<arr.length) {
                arr[i+1]=(arr[i+1]==0? arr[i]+1:Math.min(arr[i]+1,arr[i+1]));
	        }
	        if(i*2<arr.length) {
                arr[i*2]=(arr[i*2]==0? arr[i]+1:Math.min(arr[i]+1,arr[i*2]));
            }
	        
	        if(i*3<arr.length) {
	            arr[i*3]=(arr[i*3]==0? arr[i]+1:Math.min(arr[i]+1,arr[i*3]));
	        }
	    }
	    
		System.out.println(arr[N]);
	}
}

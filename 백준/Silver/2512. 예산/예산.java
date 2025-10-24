import java.util.*;
import java.io.*;

public class Main
{
    static int[] arr;
    static int result;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    
	    arr=new int[n];
	    int sum=0;
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	        arr[i]=Integer.parseInt(st.nextToken());
	        sum+=arr[i];
	    }
	    
	    int m=Integer.parseInt(br.readLine());
	    int low=1;
	    int high=arr[0];
	    
	    for(int i=1;i<n;i++) high=(arr[i]>high?arr[i]:high); // high는 최댓값
	    
	    if(sum<=m) {
	        // 예산이 엄청 넉넉할 때
	        System.out.println(high);
	        return;
	    }
	    
	    while(low<=high) {
	        int mid=(low+high)/2;
	        sum=0;
	        
	        for(int i=0;i<n;i++) {
	            if(arr[i]>=mid) {
	                sum+=mid;
	            }
	            else {
	                sum+=arr[i];
	            }
	        }

	        if(sum<=m) {
	            low=mid+1;
	        }
	        
	        else if (sum>m) {
	            high=mid-1;
	        }
	    }
		System.out.println(high);
	}
}
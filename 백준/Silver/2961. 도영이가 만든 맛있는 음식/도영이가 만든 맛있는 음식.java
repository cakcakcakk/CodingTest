import java.io.*;
import java.util.*;

public class Main
{
    static int[][] arr;
    static int n;
    static boolean[] visited;
    static long result=(int)1e10;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    n=Integer.parseInt(br.readLine());
	    arr=new int[n][2];
	   
	    StringTokenizer st;
	    
	    for(int i=0;i<n;i++) {
	        st=new StringTokenizer(br.readLine());
	        arr[i][0]=Integer.parseInt(st.nextToken());
	        arr[i][1]=Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1;i<=n;i++) {
	        visited=new boolean[n];
	        comb(0,0,i);
	    }
		System.out.println(result);
	}
	private static void comb(int idx, int depth, int r) {
	    if(depth==r) {
	        cal();
	        return;
	    }
	    
	    for(int i=idx;i<n;i++) {
	         if(visited[i]) continue;
	         
	         visited[i]=true;
	         comb(i+1,depth+1,r);
	         visited[i]=false;
	    }
	    
	}
	private static void cal() {
	    long sour=1, bitter=0;
        for(int i=0;i<n;i++) {
            if(visited[i]) {
                sour*=arr[i][0];
                bitter+=arr[i][1];
            }
        }
        result=Math.min(result,Math.abs(sour-bitter));
	} 
}
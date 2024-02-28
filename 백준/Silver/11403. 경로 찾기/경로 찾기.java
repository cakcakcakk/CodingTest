import java.io.*;
import java.util.*;

public class Main
{
    static int N,cnt;
    static int[][] a;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    N=Integer.parseInt(br.readLine());
	    
	    a=new int[N][N];
	    
	    for(int i=0;i<N;i++){
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        for(int j=0;j<N;j++){
	            a[i][j]=Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int k=0;k<N;k++){
	        for(int i=0;i<N;i++){
	            for(int j=0;j<N;j++){
	                if(a[i][k]==1 && a[k][j]==1) a[i][j]=1;
	            }
	            
	        }
	    }

	    for(int[] i:a){
	        for(int j:i) System.out.print(j+" ");
	        System.out.println();
	    }
        
	}
	

}

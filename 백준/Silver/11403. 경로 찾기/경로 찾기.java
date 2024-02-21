import java.io.*;
import java.util.*;

public class Main
{
    static int N;
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
	    
	    fw();
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            System.out.print(a[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
	
	private static void fw(){
	    for(int k=0;k<N;k++){
	        for(int i=0;i<N;i++){
	            for(int j=0;j<N;j++){
	                if(a[i][k]==1 && a[k][j]==1){
	                    a[i][j]=1;
	                }
	            }
	        }     
	    }
	}
}

import java.io.*;
import java.util.*;

public class Main
{
    static int[][] arr;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int i,j,idx;
   
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int c=Integer.parseInt(st.nextToken());
	    int r=Integer.parseInt(st.nextToken());
	    
	    int k=Integer.parseInt(br.readLine());
	    
	    if(k>r*c) {
	        System.out.println(0);
	        return;
	    }
	    
	    arr=new int[c][r];
	    arr[0][0]=1;
	    

        // k가 1일 때는 while문 안가고바로 출력하기
	    while(arr[i][j]!=k) {

	        int nx=i+dx[idx];
	        int ny=j+dy[idx];
	        
	        // 범위 이탈하거나 이미 채워져있으면 방향 틀기
	        if(nx>=c || nx<0 || ny>=r || ny<0 || arr[nx][ny]!=0) {
	            idx=(idx+1)%4;
	            continue;
	        }
	        
	        arr[nx][ny]=arr[i][j]+1;
	        i=nx;
	        j=ny;
	        	        
	    }

		System.out.println((i+1)+" "+(j+1)); 

	}
}
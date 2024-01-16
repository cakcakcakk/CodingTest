import java.io.*;
import java.util.*;

public class Main
{   static int[][] rgb,rrb;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int N;
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb=new StringBuilder();
	    int cnt=0;
	    N=Integer.parseInt(br.readLine());
	    
        rgb=new int[N][N];
        rrb=new int[N][N];
	    
	    for(int i=0;i<N;i++){
	        sb=new StringBuilder(br.readLine());
	        for(int j=0;j<N;j++){
	            switch(sb.charAt(j)) {
	                
	                case 'R':
	                   rgb[i][j]=rrb[i][j]=1;
	                   break;
	                case 'G':
	                    rgb[i][j]=2;  rrb[i][j]=1;
	                    break;
	               default:
	                    rgb[i][j]=rrb[i][j]=3;
	            } //switch	            
	        } 
	    } // insert RGB
	    	    
	    // rgb_dfs
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(rgb[i][j]!=-1) {
	                int v=rgb[i][j];
	                rgb[i][j]=-1;
	                dfs(i,j,v);
	                cnt++;
	            }
	        }
	    }
	    sb=new StringBuilder();
	    sb.append(cnt).append(" ");
	    cnt=0;
	    
	    // change_rgb_to_rrb
	    for(int i=0;i<N;i++) rgb[i]=Arrays.copyOf(rrb[i],N);
	    
	    //rrb_dfs
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(rgb[i][j]!=-1) {
	                int v=rgb[i][j];
	                rgb[i][j]=-1;
	                dfs(i,j,v);
	                cnt++;
	            }
	        }
	    }
	    sb.append(cnt).append("\n");
		System.out.print(sb);
	}
	private static void dfs(int x, int y, int v){
	    
	    for(int i=0;i<4;i++){
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        
	        if(range(nx,ny)&&rgb[nx][ny]==v) {
	            rgb[nx][ny]=-1;
	            dfs(nx,ny,v);	            
	        }
	    }
	}
	private static boolean range(int nx ,int ny) { return nx>-1 && nx<N && ny>-1 && ny<N;}
}

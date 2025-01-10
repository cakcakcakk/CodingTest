import java.io.*;
import java.util.*;

public class Main
{   
    static int[][] arr=new int[5][5];
    static int[] result=new int[6];
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static Set<String> set=new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    for(int i=0;i<5;i++) {
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<5;j++) {
	            arr[i][j]=Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0;i<5;i++) {
	        for(int j=0;j<5;j++) {
	            dfs(i,j,0);
	        }
	    }	    
	    System.out.println(set.size());	    
	}
	
	private static void dfs(int x,int y, int depth){
	    result[depth]=arr[x][y];
	    
	    if(depth==5) {
	        StringBuilder sb=new StringBuilder();
	        for(int i=0;i<6;i++) {
	            sb.append(result[i]);
	        }
	        set.add(sb.toString());
	        return;
	    }
	    
	    for(int i=0;i<4;i++) {
	        int nx=x+dx[i];
	        int ny=y+dy[i];
	        
	        if(nx>-1&&nx<5&&ny>-1&&ny<5) {
	            dfs(nx,ny,depth+1);
	        }
	    }	    

	}
}
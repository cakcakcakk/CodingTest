import java.io.*;
import java.util.*;
public class Main
{   
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int cnt,result,N;
    static List<Integer> l=new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb=new StringBuilder();
	    
	    N=Integer.parseInt(br.readLine());
	    arr=new int[N][N];
	    
	    for(int i=0;i<N;i++){
	        sb=new StringBuilder(br.readLine());
	        for(int j=0;j<N;j++){	            
	            arr[i][j]=sb.charAt(j)-'0';
	        }	     
	    }    

	        for(int i=0;i<N;i++){
	            for(int j=0;j<N;j++){
	                if(arr[i][j]==1) {
	                    arr[i][j]=0; //방문처리
	                    cnt=1;
	                    dfs(i,j);
	                    result++;
	                    l.add(cnt);
	                }
	            }
	        }
	        	        
        System.out.println(result);
        Collections.sort(l);
        for(int a:l) System.out.println(a);	    
	}

	private static void dfs(int x, int y){
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(range(nx,ny)&&arr[nx][ny]==1) {
                arr[nx][ny]=0;
                cnt++;
                dfs(nx,ny);
            }
        }
	}
	
	private static boolean range(int nx, int ny){
	    return nx>-1 && nx<N && ny>-1 && ny<N;
	}
}

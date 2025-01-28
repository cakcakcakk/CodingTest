import java.io.*;
import java.util.*;

public class Main
{
    static int n,m,h,max;
    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dz={0,0,0,0,-1,1};
    static int[][][] arr;
    static boolean ripe=true;
    static Queue<int[]> q=new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    m=Integer.parseInt(st.nextToken());
	    n=Integer.parseInt(st.nextToken());
	    h=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n][m][h];
	    
	    for(int k=0;k<h;k++) {
	        for(int i=0;i<n;i++) {
	            st=new StringTokenizer(br.readLine());
	            for(int j=0;j<m;j++) {
	                arr[i][j][k]=Integer.parseInt(st.nextToken());
	                if(arr[i][j][k]==0) {
	                    ripe=false;
	                }
	                else if (arr[i][j][k]==1) {
	                    q.add(new int[]{i,j,k});
	                }
	            }
	        }
	    }
	    
	    if(ripe) {
	        System.out.println(0);
	        return;
	    }
	    
	    int day=bfs();
	    
	    for(int k=0;k<h;k++) {
	        for(int i=0;i<n;i++) {
	            for(int j=0;j<m;j++) {
	                if(arr[i][j][k]==0) {
	                    System.out.println(-1);
	                    return;
	                }
	            }
	        }
	    }
	    System.out.println(day);		
	}
	
	static int bfs() {
	    int day=-1;
	    while(!q.isEmpty()) {
	        int size=q.size();
	        day++;
	        
	        for(int s=0;s<size;s++) {
    	        int[] now=q.poll();
    	        int x=now[0]; int y=now[1];  int z=now[2];  
    	        
    	        for(int i=0;i<6;i++) {
    	            int nx=x+dx[i];
    	            int ny=y+dy[i];
    	            int nz=z+dz[i];
    	            
    	            if(nx<0||nx>=n||ny<0||ny>=m||nz<0||nz>=h) continue;
    	            
    	            if(arr[nx][ny][nz]==0) {
    	                arr[nx][ny][nz]=1;
    	                q.add(new int[]{nx,ny,nz});
    	            }
    	        }	            
	        }
	    }	    
	    return day;
	}
}
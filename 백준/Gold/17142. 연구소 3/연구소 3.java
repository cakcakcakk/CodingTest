import java.util.*;
import java.io.*;

public class Main
{
    static int n,m,empty;
    static final int INF=(int)1e5;
    static int result=INF;
    static int[][] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    static List<int[]> list=new ArrayList<>();
    static int[][] virus;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n][n];
	    virus=new int[m][2];
	    
	    for(int i=0;i<n;i++) {
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<n;j++) {
	            arr[i][j]=Integer.parseInt(st.nextToken());
	            if(arr[i][j]==2) list.add(new int[]{i,j}); //q.add(new int[]{i,j});
	            // visited를 사용하지 않기 위해, 1과 구분하기 위해 10을 추가해줌
	            else if (arr[i][j]==0) empty++; 	            	            
	        }
	    }
	    
	    if(empty==0) { // 빈칸 없는 경우
	        System.out.println(0);
	        return;
	    }
	    
	    virusActivation(0,0);
	    System.out.println(result==INF?-1:result);
	    
		
	}
	private static void virusActivation(int idx,int depth) {
	    if(depth==m) {
	        result=Math.min(bfs(virus),result);
	        return;
	    }
	    for(int i=idx;i<list.size();i++) {
	        int[] cur=list.get(i);
	        virus[depth][0]=cur[0];
	        virus[depth][1]=cur[1];
	        virusActivation(i+1, depth+1);
	    }
	    
	}
	private static int bfs(int[][] virus) {
	    Queue<int[]> q=new LinkedList<>();
	    
	    int[][] activated=new int[n][n]; // 복제 걸리는 시간 (나중에 -1 해야함)
	    int cnt=0; // 초기 빈칸 갯수
	    
        for(int i=0;i<m;i++) {
            int x=virus[i][0];
            int y=virus[i][1];
            activated[x][y]=1; 
            q.add(new int[]{x,y});
            
        }
	    while(!q.isEmpty()) {
	        int[] cur=q.poll();
	        int x=cur[0]; 
	        int y=cur[1];
	        
	        for(int i=0;i<4;i++) {
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            
	            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
	            if(activated[nx][ny]==0 && arr[nx][ny]!=1) { // 활성화된 적 없고, 벽이 아닐때
	                activated[nx][ny]=activated[x][y]+1;
	                
	                q.add(new int[]{nx,ny});
	                
	                if(arr[nx][ny]==0) cnt++;  // 활성화됐는데 빈칸인 경우
	            }	            
	        }
	    }
	    int max=0;
	    if(empty==cnt) {
	        // 모두 활성화됨
	        for(int i=0;i<n;i++) {
	            for(int j=0;j<n;j++) {
	                if(arr[i][j]==0) max=Math.max(max,activated[i][j]);
	            }
	        }
	        return max-1;
	    }
        else return INF;
	    
	}

}
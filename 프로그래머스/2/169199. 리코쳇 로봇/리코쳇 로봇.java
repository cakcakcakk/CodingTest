import java.util.*;

class Solution {
    static int n,m;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public int solution(String[] board) {
        int answer = 0;
        
        n=board.length;
        m=board[0].length();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i].charAt(j)=='R') {
                    answer=bfs(i,j,board);
                }
            }
        }
        
        
        return answer;
    }
    
    int bfs(int x, int y, String[] board) {
        
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[n][m];
        visited[x][y]=true;
        
        q.add(new int[]{x,y,0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if(board[now[0]].charAt(now[1])=='G') {
                return now[2];
            }
            
            for(int i=0;i<4;i++) {
                int nx=now[0];
                int ny=now[1];
                int count=now[2];  
                                
                while(nx>=0 && nx<n && ny>=0 && ny<m && board[nx].charAt(ny)!='D') {
                    nx+=dx[i];
                    ny+=dy[i];
                }
                
                // 장애물이나 벽 만났을 때 제자리
                nx-=dx[i];
                ny-=dy[i];
                
                if(!visited[nx][ny]) {
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,count+1});
                }
                
            }
                        
        }
        return -1;
        
    }
}
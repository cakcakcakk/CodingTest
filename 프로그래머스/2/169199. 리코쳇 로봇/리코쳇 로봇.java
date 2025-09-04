import java.util.*;

class Solution {
    static int n,m;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    public int solution(String[] board) {
        int answer = 0;
        
        n=board.length;
        m=board[0].length();
        
        // 미끄러지는 게 한 번의 이동이다! 이동 후  좌표 큐에 넣는다
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i].charAt(j)=='R') {
                    answer=bfs(i,j,board);
                }
            }
        }
        return answer;
    }
    private int bfs(int sx, int sy, String[] board) {
        Queue<int[]> q=new ArrayDeque<>();
        int[][] visited=new int[n][m];
        
        q.add(new int[]{sx,sy});
        visited[sx][sy]=1;  // 1로 해놔야 방문 확인과 혼동 없음
        
        while(!q.isEmpty()) {
            int[] now=q.poll();
            
            int x=now[0];
            int y=now[1];
            
            if(board[x].charAt(y)=='G') {
                return visited[x][y]-1;
            }
            
            
            for(int i=0;i<4;i++) {
                
                int nx=x;
                int ny=y;
                
                while(nx>=0&&nx<n && ny>=0 && ny<m && board[nx].charAt(ny)!='D') {
                    nx+=dx[i];
                    ny+=dy[i];
                }
                // 벽이나 장애물인 경우 제자리
                nx-=dx[i];
                ny-=dy[i];
                
                if(visited[nx][ny]==0) { // 방문 안했다면
                    visited[nx][ny]=visited[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }  // for문
        }
        return -1;
    }
}
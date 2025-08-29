import java.util.*;

class Solution {
    boolean[] visited;
    int row, col;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    String[] MIRO;  // maps를 전역으로 쓰기 위함 
    int[] start; int[] labor;
    
    public int solution(String[] maps) {

        row=maps.length;
        col=maps[0].length();
        MIRO=new String[row];
        
        for(int i=0;i<row;i++) MIRO[i]=maps[i];
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(MIRO[i].charAt(j)=='S') {
                    start=new int[]{i,j};
                }
                                
                if(MIRO[i].charAt(j)=='L') {
                    labor=new int[]{i,j};
                }                
            }
        }
        
        int result1=bfs(start,'L');
        int result2=bfs(labor,'E');
        
        if(result1==-1 || result2==-1) return -1;
        else return result1 + result2;
    }
    
    private int bfs(int[] start, char target) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[row][col];
        
        q.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]]=true;
        
        while(!q.isEmpty()) {
            int[] now=q.poll();
            int x=now[0];
            int y=now[1];
            int count=now[2];
            
            if(MIRO[x].charAt(y)==target) {
                return count;
            }
            
            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0 || nx>=row || ny<0 || ny>=col || MIRO[nx].charAt(ny)=='X') continue;
                                               
                if(!visited[nx][ny]) {
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,count+1}); 
                }                                                       
            }
        }
        
        return -1;  // target 으로 못 가면 -1 출력
    }
}
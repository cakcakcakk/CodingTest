import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static char[][] a;
    static boolean[][] visited;
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer=new ArrayList<>();
        boolean zero=false;
        a=new char[maps.length][maps[0].length()];
        visited=new boolean[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                a[i][j]=maps[i].charAt(j);
            }
        }
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(a[i][j]!='X'&& !visited[i][j]){
                    visited[i][j]=true;
                    answer.add(bfs(i,j,maps));
                    zero=true;
                }
            }
        }  // 순회 끝
         
        if(!zero) answer.add(-1);
        Collections.sort(answer);
        return answer;
    }
    
    public static int bfs(int x, int y,String[] maps){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{x,y});
        int cnt=Character.getNumericValue(a[x][y]);
        
        while(!q.isEmpty()){
            int[] p=q.poll();
            
            for(int i=0;i<4;i++){
                int nx=p[0]+dx[i];
                int ny=p[1]+dy[i];
                
                if(nx<0 || ny<0||nx>=maps.length||ny>=maps[0].length()) continue;
                if(a[nx][ny]!='X'&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx,ny});
                    cnt+=Character.getNumericValue(a[nx][ny]);
                }
                
            }  // 상하좌우 
        }
        
        return cnt;
    }
}
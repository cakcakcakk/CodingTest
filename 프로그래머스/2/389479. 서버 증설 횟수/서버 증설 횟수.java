import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설 횟수
        int current=0; // 증설된 서버의 수
        int[] visited=new int[players.length]; // 사라질 서버의 수
        
        for(int i=0;i<players.length;i++) {
            current-=visited[i]; // 서버 시간 지나서 사라짐            

            if(current<players[i]/m) {  // 서버 증설해야 할 때
                int add=players[i]/m - current;
                current+=add;
                answer+=add;

                if(i+k<players.length) visited[i+k]=add;

            }
            
            
        }
        return answer;
    }
}
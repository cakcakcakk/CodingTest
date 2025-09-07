import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        // bfs로 해도 되거나, dp로 해도 될듯
        // 거꾸로 y -> x
        int[] arr=new int[y+1];
        Arrays.fill(arr,12345678);
        arr[y]=0;
        
        for(int i=y;i>=x;i--) {
            if(arr[i]==12345678) continue;
            
            if(i-n>0) {
                arr[i-n]=Math.min(arr[i-n],arr[i]+1);
            }
            if(i%2==0) {
                arr[i/2]=Math.min(arr[i/2],arr[i]+1);
            }
            if(i%3==0) {
                arr[i/3]=Math.min(arr[i/3],arr[i]+1);
            }
        }
        answer=(arr[x]==12345678?-1:arr[x]);
        return answer;
    }
}
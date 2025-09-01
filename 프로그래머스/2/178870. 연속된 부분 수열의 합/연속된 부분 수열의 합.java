import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,sequence.length-1};
        
        // 모두 int로 가능, 투포인터
        int left=0; 
        int tmp=0;
        
        
        for(int right=0;right<sequence.length;right++) {
            
            tmp+=sequence[right];
            
            while(left<right && tmp>k) {
                tmp-=sequence[left];
                left++;          
            }
            
            if(tmp==k) {
                if(right-left < answer[1]-answer[0]) {
                    answer[0]=left;
                    answer[1]=right;
                }
            }        
        
        }
        
        return answer;
    }
}
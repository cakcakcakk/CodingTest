import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int h=0;
        Arrays.sort(citations);
        
        // 왜 뒤에서부터 확인하면 안될까?
        for(int i=citations.length-1;i>-1;i--){
            if(citations[i]>=citations.length-i) {
                h=Math.max(h,citations.length-i);
            }
        }

        return h;
    }
}
import java.util.*;
class Solution {
    public ArrayList<Long> solution(int n, long left, long right) {

        ArrayList<Long> arr=new ArrayList<>();
        
        for(long idx=left;idx<=right;idx++){
            long i=idx/n;
            long j=idx%n;
            
            arr.add(Math.max(i,j)+1);
        }
        
        return arr;
    }

}
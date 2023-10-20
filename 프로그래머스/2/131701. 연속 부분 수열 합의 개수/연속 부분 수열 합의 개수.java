import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<elements.length;i++){
            
            for(int j=0;j<elements.length;j++){
                int value=0;
                for(int k=j;k<j+i+1;k++){
                    value+=elements[k%elements.length];
                }
                set.add(value);
            }
        
        }
        
        return set.size();
    }
}
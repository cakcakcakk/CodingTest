import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> strList = new ArrayList<>();
        strList.add(words[0]);

        for(int i=1;i<words.length;i++){
            
            char pre=words[i-1].charAt(words[i-1].length()-1);
            char post=words[i].charAt(0);
            
            if(pre==post && !strList.contains(words[i])){
                strList.add(words[i]);
                continue;
            }
            
            else {
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
                                                                                  
        } // for i

        return answer;
    }
}
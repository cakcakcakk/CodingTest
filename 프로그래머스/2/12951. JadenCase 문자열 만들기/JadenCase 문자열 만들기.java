import java.util.*;
class Solution {
    public String solution(String s) {
        s=s.toLowerCase();
        
        for(int i=0;i<s.length();i++){
            if(i==0 || i>=1 &&s.charAt(i-1)==' '){
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'|| s.charAt(i)==' '){
                    continue;
                }
                else {
                    s=s.substring(0,i)+Character.toUpperCase(s.charAt(i))+s.substring(i+1);
                }
            }
        }
        return s;
    }
}
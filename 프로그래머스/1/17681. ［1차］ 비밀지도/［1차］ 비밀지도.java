import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] str=new String[n];
        
        for(int i=0;i<n;i++){
            str[i]=Integer.toBinaryString(arr1[i]|arr2[i]);
            str[i]=String.format("%16s",str[i]);
            str[i]=str[i].substring(16-n);
            
            str[i]=str[i].replace("1","#");
            str[i]=str[i].replace("0"," ");
            
        }
        
        return str;
    }
}
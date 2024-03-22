import java.util.*;
class Solution {
    public StringBuilder solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str=s.split(" ");
        int[] a=new int[str.length];
        
        for(int i=0;i<a.length;i++) a[i]=Integer.parseInt(str[i]);
        

        Arrays.sort(a);
        
        answer.append(a[0]+" "+a[a.length-1]);
        //answer+=Integer.toString(a[0])+" "+Integer.toString(a[a.length-1]);


        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(dartResult, "SDT*#");

        int idx=-1;
        int n=0;
        
   while(st.hasMoreTokens()){
        list.add(Integer.parseInt(st.nextToken()));
    }
    
    for(int i=0;i<dartResult.length();i++){
        switch(dartResult.charAt(i)) {
                
            case 'S':
                idx++;
                break;
                
            case 'D':
                idx++;
                n=(int)Math.pow(list.get(idx),2);
                list.set(idx,n);
                break;
                
            case 'T':
                idx++;
                n=(int)Math.pow(list.get(idx),3);
                list.set(idx,n);
                break;
                
            case '*':   
                if(idx>0) {
                    list.set(idx-1,list.get(idx-1)*2);
                }
                list.set(idx, list.get(idx)*2);
                break;
                
            case '#':    
                list.set(idx,list.get(idx)*(-1));
                break;
        }
    }
    
    for(int a:list) answer+=a;
        return answer;
    }
}
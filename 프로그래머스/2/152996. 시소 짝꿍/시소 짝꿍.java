import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer,Integer>m=new HashMap<>();
        
        for(int i=0;i<weights.length;i++){
            m.put(weights[i],m.getOrDefault(weights[i],0)+1);            
        }
        Arrays.sort(weights);
	    int prev=0;

	    for(int i=0;i<weights.length;i++){
	        
	        int d1=weights[i];

	        if(i>0&&weights[i]==weights[i-1]){
	            prev--;
	            answer+=prev;
	            
	            continue;
	        }
	        prev=0;
	        if(m.containsKey(weights[i])&&m.get(weights[i])>1) {prev+=(m.get(weights[i])-1);}
	        if(weights[i]*3%2==0&&m.containsKey(weights[i]*3/2)) {d1=weights[i]*3/2; prev+=m.get(d1);}
	        if(weights[i]*4%2==0&&m.containsKey(weights[i]*4/2)) {d1=weights[i]*4/2; prev+=m.get(d1);}
	        if(weights[i]*4%3==0&&m.containsKey(weights[i]*4/3)) {d1=weights[i]*4/3; prev+=m.get(d1);}

	        answer+=prev;
	    }                
        
        return answer;
    }
    
}
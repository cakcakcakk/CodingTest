class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 일의 자리 
        while(storey!=0) {
            int lower=storey%10;
            int upper=storey%100/10;
            
            if(lower>5 || lower==5 && upper>=5) {
                answer+=10-lower;
                storey+=10;
                
            }
            else {
                answer+=lower;                
            }
            storey/=10;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 돌을 최소로 사용해 0층으로 이동        
        // dp 같다고 생각한다. storey -> 0 이 아닌, 거꾸로 생각하기?
        // 근데 기억이 났다... 5 이하면 어쩌구 아니면 어쩌구....

        while(storey>0) {
            int left=storey%10;
            storey/=10;
            
            if(left==5) {  // 일의 자리가 5인 경우는 뒷자리까지 봐야 한다
                if(storey%10>=5) { // 다음 앞자리가 5보다 크면 
                    storey++;
                    answer+=(10-left);
                }
                else {
                    answer+=left;
                }                
            }
            else if (left>5){  // 일의 자리 5보다 클 때
                answer+=(10-left);
                storey++;
            }
            else {          // 일의 자리 5보다 작을 때
                answer+=left;
            }            
        }
        return answer;
    }
}
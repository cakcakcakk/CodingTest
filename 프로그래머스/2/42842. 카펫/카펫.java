class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x,y;
        
        for(x=3,y=3;x+y<=2502;x++){
            y=(brown+4-2*x)/2;
            if((x-2)*(y-2)==yellow&&x>=y) {
                answer[0]=x; answer[1]=y;
                return answer;
            }

        }
        
        return answer;
    
    }
}
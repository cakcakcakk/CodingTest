class Solution {
    public long solution(int[] weights) {
        long answer = 0;  // nC2 인데 n<=10^5 니까
        long[] arr=new long[1001];
        
        for(int i=0;i<weights.length;i++) {
            arr[weights[i]]++;
        }
        
        for(int i=100;i<1001;i++) {
            if(arr[i]==0) continue;
            int j;
            
            // 1:1
            answer+= arr[i]*(arr[i]-1)/2;
            
            // 1:2
            if(i*2<1001) {
                answer+=arr[i]*arr[i*2];
            }
            
            // 2:3
            if(i*3%2==0 && i*3/2<1001) {
                j=i*3/2;
                answer+=arr[i]*arr[j];
            }
            // 3:4
            if(i*4%3==0 && i*4/3<1001) {
                j=i*4/3;
                answer+=arr[i]*arr[j];
            }
            
        }
        
        return answer;
    }
}
class Solution {
    int solution(int[][] land) {
        int answer=0,max=0;
        int[] a=new int[4];
        int[] b=new int[4];
        for(int i=0;i<4;i++) a[i]=land[0][i];
        
        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                max=0;
                for(int k=0;k<4;k++){
                    if(k==j) continue;
                    max=Math.max(max,a[k]);
                }
                
                b[j]=max+land[i][j];
            }
            for(int j=0;j<4;j++)a[j]=b[j];

        }
        
        for(int i=0;i<4;i++) 
            answer=Math.max(answer,a[i]);

        return answer;
    }
}
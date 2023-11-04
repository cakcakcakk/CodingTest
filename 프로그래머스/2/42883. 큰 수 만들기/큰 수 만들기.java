class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int idx=0;
        StringBuilder sb=new StringBuilder();
       
        
        for(int i=0;i<number.length()-k;i++){
            char max=0;
            //최대 idx, 값을 answer에 넣기
            for(int j=idx;j<=k+i;j++){
                if(number.charAt(j)>max) {
                    max=number.charAt(j);
                    idx=j+1;
                }
            }
            sb.append(max);
            
        }
        
        return sb.toString();
    }
}

class Solution {
    static String[] str={"A","E","I","O","U"};
    static String wordstr=new String();
    static int answer;
    static boolean found;
    public int solution(String word) {
        //int answer = 0;
        wordstr=word;
        dfs("");
        
        return answer-1;
    }
    
    private void dfs(String s) {
        if(found) return;
        answer++;

        if(wordstr.equals(s)) {
            found=true;
            return;
        }
        
            
        if(s.length()==5) return;  
        
        for(int i=0;i<5;i++) {
            
            dfs(s+str[i]); 
            
        }
    }
}
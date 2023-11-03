import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String[] cache=new String[cacheSize];
        Map<String,Integer> m=new HashMap<>();
        
        if(cacheSize==0) {
            for(String str:cities) answer+=5;
            return answer;
        }
        
        
        for(int i=0;i<cities.length;i++){
            boolean same=false;
            //대소문자 상관없이 같은애 있는지 찾기
            for(String str:m.keySet()){

                //같은애 찾으면 인덱스 바꿔주기
                if(cities[i].equalsIgnoreCase(str)) {
                    m.put(str,i);
                    answer+=1;
                    same=true;
                    break;
                   
                }
            }
            
            //같은애 없을 때
            if(!same) {
                //꽉차서 LRU 시행
                if(cacheSize==m.size()) { 
                    int min = Integer.MAX_VALUE;

                    for (Integer value : m.values()) {
                        if (value < min) {
                            min = value;
                        }
                    }
                    
                    for (Map.Entry<String, Integer> entry : m.entrySet()) {
                        if (entry.getValue() == min) {
                            m.remove(entry.getKey());
                            break; 
                        }
                    }

                }
                //공간남아서 그냥 넣기 or LRU 처리
                answer+=5;
                m.put(cities[i],i);
            }           
            
        }      

        return answer;
    }
}
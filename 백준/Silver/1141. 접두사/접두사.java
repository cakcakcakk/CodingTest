import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    int n=Integer.parseInt(br.readLine());
	    String[] str=new String[n];
	    
	    for(int i=0;i<n;i++) {
	        str[i]=br.readLine();
	    }
	    
	    Arrays.sort(str,new Comparator<>(){
	        public int compare(String s1, String s2) {
	            return Integer.compare(s2.length(),s1.length());
	        }
	        
	    });
	    
	    Set<String> set=new HashSet<>();
	    
	    
	    set.add(str[0]);
	    
	    for(String word: str) {
	        boolean available=true;
	        
	        for(String comp: set) {
	            
	            if(comp.indexOf(word)==0) {  // 어느 string이 먼저인지 확인하기
	                                        //  set에 이미 있는 중복단어 있어도 ㄱㅊ
	                available=false;
	                break;
	            }
	        }
	        
	        if(available) {
	            set.add(word);
	        }
	    }


		System.out.println(set.size());
	}
}
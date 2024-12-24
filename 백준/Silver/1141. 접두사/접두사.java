import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static Set<String> set=new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    n=Integer.parseInt(br.readLine());
	    String[] str=new String[n];
	    
	    for(int i=0;i<n;i++) {
	        str[i]=br.readLine();
	    }
	    
	    Arrays.sort(str, new Comparator<>(){
	        public int compare(String s1, String s2) {
	            return Integer.compare(s2.length(),s1.length());
	        }
	    });
	    
	    set.add(str[0]);
	    
	    for(String s1:str) {
	        boolean contain=false;
	        for(String s2:set) {
	            // 모든 s2에 대해 -1 나온 s1은 add할 것
	            if(s2.indexOf(s1)==0) { //주체(s2)에서 인자(s1)를 찾아라 
	                contain=true;
	                break;	               
	            }	          	            	            
	        }
	        //set에 들어가도 되는 애애들
	        if(!contain) {
	            set.add(s1);
	        }	        
	    }
	    
		System.out.println(set.size());
	}
}
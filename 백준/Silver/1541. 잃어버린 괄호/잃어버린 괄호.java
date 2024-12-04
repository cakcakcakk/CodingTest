import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String[] sub=br.readLine().split("-");
	    boolean first=true;
	    int sum=0;
	    
	    for(String s:sub) {
	        int tmp=0;
	        String[] add=s.split("\\+");  // '+'는 특수문자라 특수 이스케이프 처리해야함
	        
	        for(String num:add) {
	            tmp+=Integer.parseInt(num);	            
	        }
	        // tmp는 괄호 안 덧셈들
	        
	        if(first) {
	            sum+=tmp;
	            first=false;
	        }
	        else {
	            sum-=tmp;
	        }	        
	    }
	    
	    System.out.println(sum);
		
	}
}
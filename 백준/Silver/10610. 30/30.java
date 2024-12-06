import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String str=br.readLine();
	    StringBuilder result=new StringBuilder("-1");
	    
	    int[] num=new int[str.length()];
	    
	    for(int i=0;i<num.length; i++) {
	        num[i]=str.charAt(i)-'0';
	    }
	    Arrays.sort(num);
	    
	    if(num[0]==0) {
	        int sum=0;
	        
	        for(int a:num) {sum+=a;}
	        
	        if(sum%3==0) {
	            result=new StringBuilder();
	            
	            for(int i=num.length-1;i>=0;i--) {
	                result.append(num[i]);
	                
	            }
	            
	        }
	
	    }
	    
	     System.out.println(result);
		
	}
}
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    boolean first=true;
	    int sum=0;
	    
	    
	    StringTokenizer sub=new StringTokenizer(br.readLine(),"-");

	    while(sub.hasMoreTokens()) {
	        int tmp=0;
	        
	        StringTokenizer add=new StringTokenizer(sub.nextToken(),"+");
	        
	        while(add.hasMoreTokens()) {
	            tmp+=Integer.parseInt(add.nextToken());
	        }
	        
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
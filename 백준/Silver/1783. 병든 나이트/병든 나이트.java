import java.io.*;
import java.util.*;

public class Main
{
    static int N,M,cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine()); 
	    
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	   
        if(N==1) cnt=1;
        
        else if(N==2) cnt=Math.min((M+1)/2,4);
        
        // 높이 N>=3일 때
        else {
            if(M<7) {
                cnt=Math.min(M,4);
            }
            else {
                cnt=M-2;
            }           
        }
	    System.out.println(cnt);	        
	}	    
}

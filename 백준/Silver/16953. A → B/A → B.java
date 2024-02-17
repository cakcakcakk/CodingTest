import java.io.*;
import java.util.*;

public class Main
{
    static long A,B;
    static int cnt=1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());

        A=Long.parseLong(st.nextToken());
        B=Long.parseLong(st.nextToken());
		
		while(A!=B){
		    if(B<A ||B%10!=1 && B%2!=0) {
		        cnt=-1;
		        break;
		    }
		    
		    if(B%10==1) B/=10;		    
		    else if (B%2==0)  B>>=1;
		    
		    cnt++;
		}
		System.out.println(cnt);
		
	}
	
}

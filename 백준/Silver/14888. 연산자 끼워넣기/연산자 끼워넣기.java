import java.io.*;
import java.util.*;

public class Main
{   
    static int n;
    static int[] num;
    static int min=1000000000;
    static int max=-1000000000;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    n=Integer.parseInt(br.readLine());
	    
	    num=new int[n];
	    int[] operator=new int[4];
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	        num[i]=Integer.parseInt(st.nextToken());
	    }
	    
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<4;i++) operator[i]=Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<4;i++){

	        if(operator[i]>0) {
	            
	            operator[i]-=1;
	            dfs(operator,1,i,num[0]);
	            operator[i]+=1;
	        }
	        
	    }

	    //모든 값은 int 범위에 있다
	    System.out.println(max);
		System.out.println(min);
		
	}
	
	private static void dfs(int[] operator, int operand, int now, int result) {

        // 덧셈
        if(now==0) result+=num[operand];
        else if (now==1) result-=num[operand];
        else if (now==2) result*=num[operand];
        else {
            if(Math.abs(result)==result) // 양수일때
                result/=num[operand];
            else                        //음수일 때
                result=(Math.abs(result)/num[operand])*(-1);
            
        }	    

	    if(operand==n-1) {
	        min=Math.min(min,result);
	        max=Math.max(max,result);
	        return;
	    }
    	    for(int i=0;i<4;i++) {
    	        int next=(now+i)%4;
    	        if(operator[next]<1) continue;

           	    operator[next]-=1;
                dfs(operator,operand+1, next, result);
                operator[next]+=1;
	        }	        
	    
	}
}
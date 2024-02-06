import java.util.*;
import java.io.*;

public class Main
{   
    static int N,R,C,cnt;

    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    N=Integer.parseInt(st.nextToken());
	    R=Integer.parseInt(st.nextToken());
	    C=Integer.parseInt(st.nextToken());

	    dfs(0,0,N);
	    System.out.println(cnt);
	}
	
	static int dfs(int r, int c,int n) {

	    // 2X2 일 때
	    if(n==1) {
	        
	        if(r==R&&c+1==C)cnt+=1;
	        if(r+1==R &&c==C) cnt+=2;
	        if(r+1==R && c+1==C) cnt+=3;
	        
	        return cnt;
	    }
	    
	    int size=(int)Math.pow(2,n-1);
	    int next=(int)Math.pow(4,n-1);

	    if(range(r,c,size)) {
	        return dfs(r,c,n-1);
	    }
	    cnt+=next;
	    
	    if(range(r,c+size,size)){
	        return dfs(r,c+size,n-1);
	    }
	    
	    cnt+=next;
	    if(range(r+size,c,size)) {
	        return dfs(r+size,c,n-1);
	    }
	    cnt+=next;
	    
	    if(range(r+size,c+size,size)) {
	        return dfs(r+size, c+size, n-1);
	    }

	    return -10;
	   
	}
	
	static boolean range(int r, int c,int size) {

	    if(R>=r && R<r+size&&C>=c && C<c+size) return true;
	    return false;
	}
}

import java.util.*;
import java.io.*;

public class Main
{
    static int k;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    while(true) {
	        st=new StringTokenizer(br.readLine());
	        k=Integer.parseInt(st.nextToken());
	        
	        if(k==0) {
	            break;
	        }
	        arr=new int[k];
	        visited=new boolean[k];
	        //정렬이 되는 treeset, 할 필요 없는 hashset, 또는 배열 중... 배열 선택-이유는?
	        for(int i=0;i<k;i++) {
	            arr[i]=Integer.parseInt(st.nextToken());
	        }
	        per(0,0);
	        sb.append("\n");
	        
	    }
	    System.out.println(sb);
		
	}
	
	static void per(int depth, int idx){
	    if(depth==6) {
	        for(int i=0;i<k;i++) {
	            if(visited[i]) {
	                sb.append(arr[i]+" ");
	            }
	        }
	        sb.append("\n");
	    }
	    
	    for(int i=idx;i<k;i++) {
	        if(!visited[i]) {
	            visited[i]=true;
	            per(depth+1, i+1);
	            visited[i]=false;
	        }
	    }
	}
}
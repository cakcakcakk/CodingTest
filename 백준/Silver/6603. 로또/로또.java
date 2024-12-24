import java.util.*;
import java.io.*;

public class Main
{
    static int k;
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
	        int[] arr=new int[k];
	        //정렬이 되는 treeset, 할 필요 없는 hashset, 또는 배열?
	        for(int i=0;i<k;i++) {
	            arr[i]=Integer.parseInt(st.nextToken());
	        }
	        per(0, 0, arr, new int[6]);
	        sb.append("\n");
	        
	    }
	    System.out.println(sb);
		
	}
	
	static void per(int depth, int idx, int[] arr, int[] result){
	    if(depth==6) {
	        for(int i=0;i<6;i++) {
                sb.append(result[i]).append(' ');
	        }
	        sb.append('\n');
	        return;
	    }
	    
	    for(int i=idx;i<k;i++) {
	        result[depth]=arr[i];
            per(depth+1, i+1,arr,result);

	    }
	}
}
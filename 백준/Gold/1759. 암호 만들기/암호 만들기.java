import java.io.*;
import java.util.*;

public class Main
{   
    static char[] arr;
    static int L,C;
    static StringBuilder sb=new StringBuilder();
 
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    L=Integer.parseInt(st.nextToken());
	    C=Integer.parseInt(st.nextToken());
	    
	    boolean[] visited=new boolean[C];
	    	    
	    arr=br.readLine().replace(" ","").toCharArray();
	    Arrays.sort(arr);  // 오름차순이므로 조합으로 뽑기만 하면 순서는 알아서 결정됨
	    
	    comb(visited,0,0);
	    System.out.println(sb);	    	    
		
	}
	
	private static void comb(boolean[] visited, int start, int depth) {
	    if(depth==L) {
	        print(visited);
	        return;
	    }
	    
	    for(int i=start;i<C;i++) {
            visited[i]=true;
            comb(visited,i+1,depth+1);
            visited[i]=false;	        
	    }	    
	}
	
	private static void print(boolean[] visited){
	    String str=new String();
	    
	    for(int i=0;i<C;i++){
	        if(visited[i]) {
	            str+=arr[i];
	        }	        
	    }
   
	    // 만들어진 문자열 검증하기
	    if(valid(str.toCharArray())) {
	        sb.append(str).append("\n");
	    }
	 
	}
	
	private static boolean valid(char[] ch) {
	    int aeiou=0,etc=0;

	    for(int i=0;i<ch.length;i++){
	        if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u') {
	            aeiou++;
	        }
	        else {
	            etc++;
	        }
	    }
	    
	    if(aeiou>=1 && etc>=2) { return true;}
	    else { return false; }
	    
	}
	
}
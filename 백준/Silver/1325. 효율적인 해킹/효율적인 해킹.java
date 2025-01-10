import java.io.*;
import java.util.*;

public class Main
{   
    static int max;
    static List<Integer>[] list;
    static StringBuilder sb=new StringBuilder();
    static boolean[] visited;
    static int[] result;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	   
	    result=new int[n+1];
	    
	    list=new ArrayList[n+1];
	    for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
	    
	    for(int i=0;i<m;i++){
	        st=new StringTokenizer(br.readLine());
	        int a=Integer.parseInt(st.nextToken());
	        int b=Integer.parseInt(st.nextToken());
	        
	        list[a].add(b); 
	    }
	    	    
	    for(int i=1;i<=n;i++) {
	        visited=new boolean[n+1];
	        dfs(i);
	       
	    }
	   
	   for(int r:result) {
	       if(max<r) max=r;
	   }
	    
	    for(int i=1;i<=n;i++) {
	        if(result[i]==max) {
	            sb.append(i).append(' ');
	        }	        
	    }
	    
	    System.out.println(sb);
	    
	}
	
	private static void dfs(int i){
	    visited[i]=true;
	    
	    for(int num:list[i]) {
	        if(!visited[num]) {
	            result[num]++;
	            dfs(num);
	        }	        
	    }
	}
}
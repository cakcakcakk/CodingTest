import java.io.*;
import java.util.*;

public class Main
{   
    static int result=-1;
    static int min,max;
    static List<Integer>[] list;
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    int n=Integer.parseInt(br.readLine());
	    
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int a=Integer.parseInt(st.nextToken());
	    int b=Integer.parseInt(st.nextToken());
	    
	    visited=new boolean[n+1];
	    list=new ArrayList[n+1];
	    for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
	    
	    int m=Integer.parseInt(br.readLine());
	    for(int i=0;i<m;i++){
	        st=new StringTokenizer(br.readLine());
	        int x=Integer.parseInt(st.nextToken());
	        int y=Integer.parseInt(st.nextToken());
	        
	        list[x].add(y); 
	        list[y].add(x); 
	        // 공통 조상을 찾고 각 조상까지 거리의 합을 구해야하는데 부모-자식 방향성이 있지만
	        // 정방향으로만 하기에는 구현에 한계가...
	    }
	    
	    min=Math.min(a,b);
	    max=Math.max(a,b);

        dfs(min,0);
	    System.out.println(result);
	    
	}
	
	private static void dfs(int i, int cnt){
	    visited[i]=true;
	    
	    if(i==max) {
	        result=cnt;
	        return;
	    }
	    
	    for(int num:list[i]) {
	        if(!visited[num]) {
	            dfs(num,cnt+1);
	        }
	    }
	}
}
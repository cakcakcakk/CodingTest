import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,R;
    static ArrayList<Integer>[] a;
    static boolean[] visited;
    static int[] result;
    static int cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    R=Integer.parseInt(st.nextToken());
	    
	    a=new ArrayList[N+1];
	    result=new int[N+1];
	    visited=new boolean[N+1];
	    
	    for(int i=0;i<=N;i++) a[i]=new ArrayList<>();
	    
	    for(int i=0;i<M;i++){
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        a[u].add(v); a[v].add(u);
	    }
	    // 내림차순 방문! 정렬 잘 해주기
	    for(int i=1;i<=N;i++) Collections.sort(a[i],Collections.reverseOrder());

        dfs(R);
        
        for(int i=1;i<=N;i++) System.out.println(result[i]);
	}
	
	private static void dfs(int r){
	    visited[r]=true;
	    result[r]=++cnt;
	    
	    for(int i:a[r]) {
	        if(!visited[i]) {
	            dfs(i);
	        }
	    }
	} 
}

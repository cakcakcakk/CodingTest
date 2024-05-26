import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,R;
    static ArrayList<Integer>[] a;
    static int[] visited;
    static int cnt;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
	    
	    N=Integer.parseInt(st.nextToken());
	    M=Integer.parseInt(st.nextToken());
	    R=Integer.parseInt(st.nextToken());
	    
	    a=new ArrayList[N+1];
	    visited=new int[N+1];
	    
	    for(int i=0;i<=N;i++) a[i]=new ArrayList<>();
	    
	    for(int i=0;i<M;i++){
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        a[u].add(v); a[v].add(u);
	    }
	    // 내림차순 방문! 정렬 잘 해주기
	    for(int i=1;i<=N;i++) Collections.sort(a[i],(o1,o2)->o2-o1);

        dfs(R);
        
        for(int i=1;i<=N;i++) sb.append(visited[i]+"\n");
        System.out.print(sb);
	}
	
	private static void dfs(int r){
	    visited[r]=++cnt;
	    
	    for(int i=0;i<a[r].size();i++) {
            int k=a[r].get(i);
	        if(visited[k]==0) {
	            dfs(k);
	        }
	    }
	} 
}

import java.io.*;
import java.util.*;

public class Main
{  
    static int[] parent;
    static int count;
    static List<Node> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int n=Integer.parseInt(br.readLine());
	    int m=Integer.parseInt(br.readLine());
	    
	    parent=new int[n+1];
	    
	    for(int i=0;i<m;i++) {
	        st=new StringTokenizer(br.readLine());
	        int u=Integer.parseInt(st.nextToken());
	        int v=Integer.parseInt(st.nextToken());
	        int w=Integer.parseInt(st.nextToken());
	        
	        // 같은 컴퓨터일 때는 노드 연결 필요 없다고 생각
	        if(u==v) {
	            continue;
	        }
	        list.add(new Node(u,v,w));      
	    }
	    
	    // 부모 초기화
	    for(int i=0;i<=n;i++) parent[i]=i;
	    Collections.sort(list);
	    
	    for(Node now:list) {
	        // 부모가 다르면 합칠 수 있음
	        if(find(now.start)!=find(now.end)) {
	            union(now.start, now.end);
	            count+=now.cost;	            
	        }	        
	    }	    
	    System.out.println(count);		
	}

	// parent를 통해 최종 루트를 확인
	private static int find(int x) {
	    if(parent[x]==x) return x;
	    else return parent[x]=find(parent[x]);
	}
	
	// 사이클이 되지 않음을 확인한 후에 합칠 때, 어떤 부모를 선행할지 결정
	private static void union(int x1, int y1) {
	    int x0=find(x1);
	    int y0=find(y1);
	    
	    if(x0<y0) {
	        parent[y0]=x0;
	    }
	    else parent[x0]=y0;
	}
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;
    
    Node(int start, int end, int cost) {
        this.start=start;
        this.end=end;
        this.cost=cost;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost,o.cost);
    }
}

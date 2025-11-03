import java.io.*;
import java.util.*;

public class Main {
    static long[] dist;
    static List<Edge>[] list;
    static boolean[] seen;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        seen=new boolean[n];
        dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        list=new ArrayList[n];
        for(int i=0;i<n;i++) list[i]=new ArrayList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++) {  // 어차피 마지막은 안해도 될것 같다고 생각함
            if(Integer.parseInt(st.nextToken())==1) seen[i]=true;
        }

        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());

            if(seen[a] || seen[b]) continue;
            list[a].add(new Edge(b,t));
            list[b].add(new Edge(a,t));
        }
        dajikstra(0,n);
        System.out.println(dist[n-1]!=Long.MAX_VALUE?dist[n-1]:-1);
    }
    private static void dajikstra(int start, int n) {
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dist[start]=0;
        boolean[] visited=new boolean[n];

        while(!pq.isEmpty()) {
            Edge now=pq.poll();
            if(visited[now.end]) continue;
            visited[now.end]=true;

            for(Edge next:list[now.end]) {
                if(dist[next.end]<next.cost) continue;
                if(dist[next.end]>dist[now.end]+next.cost) {
                    dist[next.end]=dist[now.end]+next.cost;
                    pq.add(new Edge(next.end,dist[next.end]));
                }
            }
        }
    }
}
class Edge implements Comparable<Edge> {
    int end;
    long cost;

    Edge(int end, long cost) {
        this.end=end;
        this.cost=cost;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.cost<o.cost) return -1;
        return 1;
    }
}